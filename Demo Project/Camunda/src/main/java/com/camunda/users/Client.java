package com.camunda.users;

public class Client {

    private String id;
    private String clientName;
    private String clientDetails;
    private String phone;
    private String street;
    private String city;
    private String country;
    private String postalCode;

    private String workerName;

    private Boolean valid = true;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public String getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(final String clientDetails) {
        this.clientDetails = clientDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(final String workerName) {
        this.workerName = workerName;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean canBeSaved() {
        if (!this.clientName.isEmpty() && !this.phone.isEmpty() && !this.street.isEmpty() && !this.city.isEmpty()
                && !this.country.isEmpty() && !this.postalCode.isEmpty()) {
            return true;
        }
        ;
        this.valid = false;
        this.message = "Please fill the following required fields, ";

        if (this.clientName.isEmpty()) {
            this.message += "Name\n";
        }

        if (this.phone.isEmpty()) {
            this.message += "Phone Number \n";
        }

        if (this.street.isEmpty()) {
            this.message += "Address\n";
        }

        if (this.city.isEmpty()) {
            this.message += "City Name\n";
        }

        if (this.country.isEmpty()) {
            this.message += "Country\n";
        }

        if (this.postalCode.isEmpty()) {
            this.message += "Postal Code\n";
        }

        return false;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", clientName=" + clientName + ", clientDetails=" + clientDetails + ", phone="
                + phone + ", street=" + street + ", city=" + city + ", country=" + country + ", postalCode="
                + postalCode + ", workerName=" + workerName + "]";
    }

}
