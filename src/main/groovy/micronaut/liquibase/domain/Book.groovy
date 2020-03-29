package micronaut.liquibase.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString


@ToString(includeNames = true)
@Entity
class Book {

    String bookId
    String name
    String author
    String genre

    static constrains = {
        bookId inde:'book_idx'
        name nullable: false
        author nullable: false
        genre nullable: true
    }


}
