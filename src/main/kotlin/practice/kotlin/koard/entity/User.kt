package practice.kotlin.koard.entity

import javax.persistence.*

@Entity
class User (nickname: String, password: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var nickname: String = nickname
    var password: String = password
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    var boards: MutableList<Board> = mutableListOf()
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    var comments: MutableList<Comment> = mutableListOf()
}