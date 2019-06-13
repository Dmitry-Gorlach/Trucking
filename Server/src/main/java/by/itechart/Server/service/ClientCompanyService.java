package by.itechart.Server.service;

import by.itechart.Server.dto.ClientCompanyDto;
import by.itechart.Server.entity.ClientCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientCompanyService {
    void save(ClientCompanyDto clientCompanyDto);

    Page<ClientCompanyDto> findAll(Pageable pageable);

    ClientCompanyDto findById(int id);

    void delete(ClientCompanyDto clientCompany);

    void deleteById(int id);
}
