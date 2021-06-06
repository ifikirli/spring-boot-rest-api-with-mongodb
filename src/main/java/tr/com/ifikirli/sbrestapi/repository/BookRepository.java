package tr.com.ifikirli.sbrestapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.ifikirli.sbrestapi.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findByName(String name);
}
