package micronaut.liquibase.controller

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post
import io.reactivex.Single
import micronaut.liquibase.domain.Book
import micronaut.liquibase.service.BookService
import org.grails.datastore.mapping.validation.ValidationException

import javax.inject.Inject


@Controller("/book")
@Slf4j
@CompileStatic
class BookController {

    @Inject BookService bookService;
    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Post('/')
    Single<Map> create(@Body Map data)
    {
        try {
            Book dc = bookService.create(data)
            log.info("save book request is being processed ...")
        } catch (ValidationException ve) {
            log.error "create datacenter: ${ve.message}"
        } catch (URISyntaxException e) {
            log.error "create datacenter: ${e.reason}"
        }
    }
}