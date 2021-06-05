package tr.com.ifikirli.sbrestapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.ifikirli.sbrestapi.model.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByCreatedDateBetweenAndStatusIsNot(Date startDate, Date endDate, String status);
    Page<Order> findAllByCustomerId(String customerId, Pageable paging);
}
