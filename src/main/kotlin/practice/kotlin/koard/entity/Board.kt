package practice.kotlin.koard.entity

import javax.persistence.*

@Entity
class Board (user: User, title: String, content: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @ManyToOne @JoinColumn(name = "user_id")
    var user: User = user
    var title: String = title
    var content: String = content
    var hit: Int = 0
}