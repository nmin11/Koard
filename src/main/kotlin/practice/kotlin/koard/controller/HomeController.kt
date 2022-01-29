package practice.kotlin.koard.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import practice.kotlin.koard.entity.Board
import practice.kotlin.koard.service.BoardService

@Controller
class HomeController(private val boardService: BoardService) {

    @GetMapping("/")
    fun index(model: Model): String {
        val pageRequest: PageRequest = PageRequest.of(1, 5)
        val boards: Page<Board> = boardService.findAll(pageRequest)
        model.addAttribute("boards", boards)
        return "index"
    }

}