package by.itechart.Server.dto;

import java.time.LocalDate;


public class UserDto {
    private int id;

    private String name;

    private String patronymic;

    private String surname;

    private String passportNumber;

    private String passportIssued;

    private LocalDate dateOfBirth;

    private String email;

    private int role;

    private String login;

    private String password;

    private AddressDto address;

    private UserDto(){}

    public static Builder builder() {
        return new UserDto().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            UserDto.this.id = id;
            return this;
        }

        public Builder withName(final String name) {
            UserDto.this.name = name;
            return this;
        }

        public Builder withSurname(final String surname) {
            UserDto.this.surname = surname;
            return this;
        }

        public Builder withPatronymic(final String patronymic) {
            UserDto.this.patronymic = patronymic;
            return this;
        }

        public Builder withPassportNumber(final String passportNumber) {
            UserDto.this.passportNumber = passportNumber;
            return this;
        }

        public Builder withPassportIssued(final String passportIssued) {
            UserDto.this.passportIssued = passportIssued;
            return this;
        }

        public Builder withDateOfBirth(final LocalDate dateOfBirth) {
            UserDto.this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withRole(final int role) {
            UserDto.this.role = role;
            return this;
        }

        public Builder withLogin(final String login) {
            UserDto.this.login = login;
            return this;
        }

        public Builder withEmail(final String email) {
            UserDto.this.email = email;
            return this;
        }

        public Builder withPassword(final String password) {
            UserDto.this.password = password;
            return this;
        }

        public Builder withAddressDto(final AddressDto addressDto) {
            UserDto.this.address = addressDto;
            return this;
        }

        public UserDto build() {
            return UserDto.this;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassportIssued() {
        return passportIssued;
    }

    public void setPassportIssued(final String passportIssued) {
        this.passportIssued = passportIssued;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(final AddressDto address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}