package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DetailedCustomerDto extends CustomerDto{

    boolean isAdministrator;

    public DetailedCustomerDto(Customer customer) {

        super(customer);
        this.isAdministrator = customer.isAdministrator();
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public static List<DetailedCustomerDto> convertFromCustomers(List<Customer> customers){

        List<DetailedCustomerDto> result = new ArrayList<>();

        for(Customer customer : customers) {

            result.add(new DetailedCustomerDto(customer));
        }

        return result;
    }
}
