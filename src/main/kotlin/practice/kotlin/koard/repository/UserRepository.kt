package practice.kotlin.koard.repository

import org.springframework.data.jpa.repository.JpaRepository
import practice.kotlin.koard.entity.User

interface UserRepository: JpaRepository<User, Long> {
    fun findByNickname(username: String?): User?
}