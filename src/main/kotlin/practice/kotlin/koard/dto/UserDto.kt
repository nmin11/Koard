package practice.kotlin.koard.dto

import lombok.Data
import lombok.NoArgsConstructor

@Data @NoArgsConstructor
data class UserDto (
    val nickname: String = "",
    val password: String = ""
)