package ua.wwind.spring5kotlinwebapp.repositories

import org.springframework.data.repository.CrudRepository
import ua.wwind.spring5kotlinwebapp.domain.Publisher

interface PublisherRepository: CrudRepository<Publisher, Long> {
}