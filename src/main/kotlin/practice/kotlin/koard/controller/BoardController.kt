package practice.kotlin.koard.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import practice.kotlin.koard.entity.Board
import practice.kotlin.koard.service.BoardService

@Controller
class BoardController(private val boardService: BoardService) {

    @GetMapping("/board/{page}")
    fun index(@PathVariable("page")page: Int, model: Model): String {
        val pageRequest: PageRequest = PageRequest.of(page, 5)
        val boards: Page<Board> = boardService.findAll(pageRequest)
        model.addAttribute("boards", boards)
        return "board/list"
    }

}