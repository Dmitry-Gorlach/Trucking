package by.itechart.server.dto;


import by.itechart.server.entity.Address;
import by.itechart.server.transformers.ToEntityTransformer;

public class AddressDto implements ToEntityTransformer {

    private Integer id;

    private String city;

    private String street;

    private Integer building;

    private Integer flat;

    private String latitude;

    private String longitude;

    static {
        final AddressDto addressDto = new AddressDto();
        new AddressDto();
    }

    private AddressDto() {
    }

    public static Builder builder() {
        return new AddressDto().new Builder();
    }

    @Override
    public Address transformToEntity() {
        final Address address = new Address();
        address.setBuilding(this.building);
        address.setCity(this.city);
        address.setFlat(this.flat);
        address.setId(this.id);
        address.setLatitude(this.latitude);
        address.setLongitude(this.longitude);
        address.setStreet(this.street);
        return address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(final Integer building) {
        this.building = building;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(final Integer flat) {
        this.flat = flat;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    public class Builder {

        private Builder() {
        }

        public Builder withId(final int id) {
            AddressDto.this.id = id;
            return this;
        }

        public Builder withCity(final String city) {
            AddressDto.this.city = city;
            return this;
        }

        public Builder withStreet(final String street) {
            AddressDto.this.street = street;
            return this;
        }

        public Builder withBuilding(final Integer building) {
            AddressDto.this.building = building;
            return this;
        }

        public Builder withFlat(final Integer flat) {
            AddressDto.this.flat = flat;
            return this;
        }

        public Builder withLatitude(final String latitude) {
            AddressDto.this.latitude = latitude;
            return this;
        }

        public Builder withLongtitude(final String longitude) {
            AddressDto.this.longitude = longitude;
            return this;
        }

        public AddressDto build() {
            return AddressDto.this;
        }
    }
}