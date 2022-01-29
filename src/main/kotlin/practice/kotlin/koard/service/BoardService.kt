package practice.kotlin.koard.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import practice.kotlin.koard.entity.Board
import practice.kotlin.koard.repository.BoardRepository

@Service
class BoardService(private val boardRepository: BoardRepository) {

    fun findAll(pageable: Pageable): Page<Board> {
        return boardRepository.findAll(pageable)
    }

}