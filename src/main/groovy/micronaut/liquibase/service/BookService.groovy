package micronaut.liquibase.service

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import micronaut.liquibase.domain.Book
import org.grails.datastore.mapping.validation.ValidationException

@Slf4j
@Singleton
@Transactional
class BookService {

    Book create(Map data) throws ValidationException {
        Book book = new Book();
        String name = data.get("name")
        String author = data.get("author")
        String genre = data.get("genre")

        book.setName(name)
        book.setAuthor(author)
        book.setGenre(genre)
        book.save()
    }

    // find all the books
    List<Book> get()
    {
        Book.findAll()
    }
}
