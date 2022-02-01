package practice.kotlin.koard.config.oauth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import practice.kotlin.koard.config.auth.PrincipalDetails
import practice.kotlin.koard.config.oauth.provider.FacebookUserInfo
import practice.kotlin.koard.config.oauth.provider.GoogleUserInfo
import practice.kotlin.koard.config.oauth.provider.NaverUserInfo
import practice.kotlin.koard.config.oauth.provider.OAuth2UserInfo
import practice.kotlin.koard.entity.User
import practice.kotlin.koard.repository.UserRepository
import java.util.*

@Service
class PrincipalOAuth2UserService : DefaultOAuth2UserService() {
    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(OAuth2AuthenticationException::class)
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        println("Get Client Registration : " + userRequest.clientRegistration)
        println("Get Access Token : " + userRequest.accessToken.tokenValue)
        val oAuth2User = super.loadUser(userRequest)
        println("Get Attributes : " + oAuth2User.attributes)
        var oAuth2UserInfo: OAuth2UserInfo? = null
        if (userRequest.clientRegistration.registrationId == "google") {
            oAuth2UserInfo = GoogleUserInfo(oAuth2User.attributes)
        } else if (userRequest.clientRegistration.registrationId == "facebook") {
            oAuth2UserInfo = FacebookUserInfo(oAuth2User.attributes)
        } else if (userRequest.clientRegistration.registrationId == "naver") {
            oAuth2UserInfo = NaverUserInfo(oAuth2User.attributes["response"] as Map<String, Any>)
        } else {
            println("Google, Facebook, Naver 로그인만 지원합니다.")
        }
        val username: String? = oAuth2UserInfo?.name
        val password = "GetInThere"
        val findUser: User? = userRepository.findByNickname(username)
        var user: User? = null
        if (findUser == null) {
            println("최초의 OAuth 로그인입니다.")
            user = User(nickname = username.orEmpty(), password = password)
            userRepository.save(user)
        } else {
            println("이미 OAuth 로그인을 진행했습니다. 자동 회원가입이 되어 있습니다.")
            user = findUser
        }
        return PrincipalDetails(user, oAuth2User.attributes)
    }
}