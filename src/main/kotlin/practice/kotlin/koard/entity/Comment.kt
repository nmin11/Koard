package practice.kotlin.koard.entity

import javax.persistence.*

@Entity
class Comment (board: Board, user: User, content: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var content: String = content
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    var user: User = user
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "board_id")
    var board: Board = board
}