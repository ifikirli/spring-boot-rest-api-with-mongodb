package tr.com.ifikirli.sbrestapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.ifikirli.sbrestapi.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByEmail(String email);
}
