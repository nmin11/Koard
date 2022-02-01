package practice.kotlin.koard.config.oauth.provider

class NaverUserInfo(  //getAttributes()를 받아옴
    private val attributes: Map<String, Any>
) : OAuth2UserInfo {
    override val name: String?
        get() = attributes["name"] as String?
    override val email: String?
        get() = attributes["email"] as String?
    override val provider: String
        get() = "naver"
    override val providerId: String?
        get() = attributes["id"] as String?
}