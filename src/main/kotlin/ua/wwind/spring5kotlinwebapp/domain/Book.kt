package ua.wwind.spring5kotlinwebapp.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val title: String,
    val isbn: String,
    @ManyToMany
    @JoinTable(
        name = "author_book", joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: MutableSet<Author> = mutableSetOf()
) {
    override fun toString(): String {
        return "Book(id=$id, title='$title', isbn='$isbn', authors=${authors.map { it.id to "${it.firstName} ${it.lastName}" }})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}
