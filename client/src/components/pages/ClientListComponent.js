import React from 'react';
import {Button, ButtonGroup, Container, Input, Table} from 'reactstrap';
import {Link} from 'react-router-dom';
import axios from 'axios';
import Pagination from "react-js-pagination";


class ClientListComponent extends React.Component {

    clientTypeMap = {
        'INDIVIDUAL': 'Физическое лицо',
        'LEGAL': 'Юридическое лицо'
    };

    clientStatusMap = {
        'ACTIVE': 'Активен',
        'BLOCKED': 'Заблокирован'
    };

    constructor(props) {
        super(props);
        this.state = {
            clients: [],
            activePage: 0,
            totalPages: null,
            itemsCountPerPage: null,
            totalItemsCount: null
        };
        this.handlePageChange = this.handlePageChange.bind(this);
        this.fetchURL = this.fetchURL.bind(this);
        this.removeChecked = this.removeChecked.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange = e => {
        const id = e.target.id;
        this.setState(prevState => {
            return {
                clients: prevState.clients.map(
                    client => (client.id === +id ? {
                        ...client, value: !client.value
                    } : client)
                )
            }
        })
    };

    fetchURL(page) {
        axios.get(`/client/list?page=${page}&size=5`, {
            proxy: {
                host: 'http://localhost',
                port: 8080
            }
        })
            .then(response => {
                    console.log(response);
                    const totalPages = response.data.totalPages;
                    const itemsCountPerPage = response.data.size;
                    const totalItemsCount = response.data.totalElements;

                    this.setState({totalPages: totalPages});
                    this.setState({totalItemsCount: totalItemsCount});
                    this.setState({itemsCountPerPage: itemsCountPerPage});

                    const results = response.data.content;
                    console.log(this.state);

                    if (results != null) {
                        this.setState({clients: results});
                        console.log(results);
                    }

                    console.log(this.state.activePage);
                    console.log(this.state.itemsCountPerPage);
                }
            );
    }

    componentDidMount() {
        this.fetchURL(this.state.activePage)
    }

    handlePageChange(pageNumber) {
        console.log(`active page is ${pageNumber}`);
        this.setState({activePage: pageNumber});
        this.fetchURL(pageNumber - 1)
    }

    populateRowsWithData = () => {
        const clients = this.state.clients.map(client => {
            return <tr key={client.id}>
                <td><Input
                    type="checkbox"
                    id={client.id || ''}
                    name="selected_clients"
                    value={client.id || ''}
                    checked={client.value || ''}
                    onChange={this.handleChange}/></td>
                <td style={{whiteSpace: 'nowrap'}}><Link to={"/client/" + client.id}>{client.name}</Link></td>
                <td>{this.clientTypeMap[client.type]}</td>
                <td>{this.clientStatusMap[client.status]}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/client/" + client.id}>Редактировать</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(client.id)}>Удалить</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return clients
    };

    async remove(id) {
        await fetch(`/client/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updateClients = [...this.state.clients].filter(i => i.id !== id);
            this.setState({clients: updateClients});
            this.handlePageChange(0);
        });
    }

    async removeChecked() {
        const selectedClients = Array.apply(null,
            document.clients.selected_clients).filter(function (el) {
            return el.checked === true
        }).map(function (el) {
            return el.value
        });
        console.log(selectedClients);
        await fetch(`/client/${selectedClients}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updateClients = [...this.state.clients].filter(client => !client.value);
            this.setState({products: updateClients});
            this.handlePageChange(0);
        });
    }


    render() {
        return (
            <form name="clients">
                <div>
                    <Container fluid>
                        <div className="float-right">
                            <ButtonGroup>
                                <Button color="success" tag={Link} to="/client/create">Добавить</Button>
                                <Button color="danger" onClick={() => this.removeChecked()}>Удалить выбранные</Button>
                            </ButtonGroup>
                        </div>
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th></th>
                                <th width="30%">Название</th>
                                <th width="30%">Тип</th>
                                <th>Статус</th>
                                <th width="10%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            {this.populateRowsWithData()}
                            </tbody>
                        </Table>

                        <div className="d-flex justify-content-center">
                            <Pagination
                                activePage={this.state.activePage}
                                itemsCountPerPage={this.state.itemsCountPerPage}
                                totalItemsCount={this.state.totalItemsCount}
                                itemClass='page-item'
                                linkClass='btn btn-light'
                                onChange={this.handlePageChange}

                            />
                        </div>
                    </Container>
                </div>
            </form>
        );
    }
}

export default ClientListComponent;