package practice.kotlin.koard.entity

import javax.persistence.*

@Entity
class Board (user: User, title: String, content: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String = title
    var content: String = content
    var hit: Int = 0
    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL])
    var comments: MutableList<Comment> = mutableListOf()
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    var user: User = user
}