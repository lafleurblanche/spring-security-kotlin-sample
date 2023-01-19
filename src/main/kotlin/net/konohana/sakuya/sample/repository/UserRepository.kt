package net.konohana.sakuya.sample.repository

import net.konohana.sakuya.sample.entity.User2
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User2, Int> {
    fun findByUsername(username: String): User2
}
