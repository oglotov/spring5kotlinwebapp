package ua.wwind.spring5kotlinwebapp.repositories

import org.springframework.data.repository.CrudRepository
import ua.wwind.spring5kotlinwebapp.domain.Book

interface BookRepository: CrudRepository<Book, Long> {
}