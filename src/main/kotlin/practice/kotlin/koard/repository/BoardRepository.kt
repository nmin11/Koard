package practice.kotlin.koard.repository

import org.springframework.data.jpa.repository.JpaRepository
import practice.kotlin.koard.entity.Board

interface BoardRepository: JpaRepository<Board, Long> {
}