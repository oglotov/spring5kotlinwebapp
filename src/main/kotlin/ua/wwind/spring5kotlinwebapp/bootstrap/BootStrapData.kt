package ua.wwind.spring5kotlinwebapp.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.spring5kotlinwebapp.domain.Author
import ua.wwind.spring5kotlinwebapp.domain.Book
import ua.wwind.spring5kotlinwebapp.repositories.AuthorRepository
import ua.wwind.spring5kotlinwebapp.repositories.BookRepository

@Component
class BootStrapData: CommandLineRunner {

    @Autowired
    lateinit var authorRepository: AuthorRepository
    @Autowired
    lateinit var bookRepository: BookRepository

    override fun run(vararg args: String?) {
        val eric = Author(null, "Eric", "Evans")
        val ddd = Book(null, "Domain Driven Design", "123123")
        eric.books.add(ddd)
        ddd.authors.add(eric)
        authorRepository.save(eric)
        bookRepository.save(ddd)
        val rod = Author(null, "Rod", "Jhonson")
        val noEJB = Book(null, "J2EE Development without EJB", "1242353245")
        rod.books.add(noEJB)
        noEJB.authors.add(rod)
        authorRepository.save(rod)
        bookRepository.save(noEJB)
        println("Started in BootStrap")
        println("Number of books: ${bookRepository.count()}")
    }

}