package ua.wwind.spring5kotlinwebapp.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.spring5kotlinwebapp.domain.Author
import ua.wwind.spring5kotlinwebapp.domain.Book
import ua.wwind.spring5kotlinwebapp.domain.Publisher
import ua.wwind.spring5kotlinwebapp.repositories.AuthorRepository
import ua.wwind.spring5kotlinwebapp.repositories.BookRepository
import ua.wwind.spring5kotlinwebapp.repositories.PublisherRepository

@Component
class BootStrapData : CommandLineRunner {

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var publisherRepository: PublisherRepository

    override fun run(vararg args: String?) {
        val eric = Author(null, "Eric", "Evans")
        val ababa = Publisher(null, "Ababagalamaga")
        val ddd = Book(id = null, title = "Domain Driven Design", isbn = "123123", publisher = ababa)
        publisherRepository.save(ababa)
        eric.books.add(ddd)
        ddd.authors.add(eric)
        ababa.books.add(ddd)
        authorRepository.save(eric)
        bookRepository.save(ddd)
        publisherRepository.save(ababa)
        val rod = Author(null, "Rod", "Jhonson")
        val noEJB = Book(id = null, title = "J2EE Development without EJB", isbn = "1242353245", publisher = ababa)
        rod.books.add(noEJB)
        noEJB.authors.add(rod)
        ababa.books.add(noEJB)
        authorRepository.save(rod)
        bookRepository.save(noEJB)
        publisherRepository.save(ababa)
        println("Started in BootStrap")
        println("Number of books: ${bookRepository.count()}")
        println("Publisher Number of Books: ${ababa.books.size}")
    }

}