package practice.kotlin.koard.config.auth

import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import practice.kotlin.koard.entity.User

@Data
class PrincipalDetails : UserDetails, OAuth2User {
    private var user: User
    private var attributes: Map<String, Any>? = null

    //일반 로그인
    constructor(user: User) {
        this.user = user
    }

    //OAuth 로그인
    constructor(user: User, attributes: Map<String, Any>?) {
        this.user = user
        this.attributes = attributes
    }

    override fun getAttributes(): Map<String, Any> {
        return attributes!!
    }

    //해당 유저의 권한 리턴
    override fun getAuthorities(): Collection<GrantedAuthority> {
        val collection: MutableCollection<GrantedAuthority> = ArrayList()
        collection.add(GrantedAuthority { "GENERAL" })
        return collection
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.nickname
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getName(): String? {
        return null
    }
}