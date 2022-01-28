package practice.kotlin.koard.entity

import javax.persistence.*

@Entity
class Comment (board: Board, user: User, content: String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @ManyToOne @JoinColumn(name = "board_id")
    var board: Board = board
    @ManyToOne @JoinColumn(name = "user_id")
    var user: User = user
    var content: String = content
}