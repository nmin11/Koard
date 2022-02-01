package practice.kotlin.koard.config.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import practice.kotlin.koard.entity.User
import practice.kotlin.koard.repository.UserRepository

@Service
class PrincipalDetailsService : UserDetailsService {
    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user: User? = userRepository?.findByNickname(username)
        return if (user != null) {
            PrincipalDetails(user)
        } else null
    }
}