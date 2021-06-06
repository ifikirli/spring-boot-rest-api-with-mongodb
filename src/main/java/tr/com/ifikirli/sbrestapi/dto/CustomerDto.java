package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.Customer;

public class CustomerDto extends BaseDto{

    String email;
    String name;
    String surname;

    public CustomerDto(Customer customer) {

        super(customer.getId());
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.surname = customer.getSurname();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
