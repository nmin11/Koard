package practice.kotlin.koard.config.oauth.provider

interface OAuth2UserInfo {
    val name: String?
    val email: String?
    val provider: String?
    val providerId: String?
}