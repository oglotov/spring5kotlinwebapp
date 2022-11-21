package ua.wwind.spring5kotlinwebapp.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val firstName: String,
    val lastName: String,
    @ManyToMany(mappedBy = "authors")
    val books: MutableSet<Book> = mutableSetOf()
) {
    override fun toString(): String {
        return "Author(id=$id, firstName='$firstName', lastName='$lastName', books=${books.map { it.id }})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}
