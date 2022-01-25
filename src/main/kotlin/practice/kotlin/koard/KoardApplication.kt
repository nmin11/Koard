package practice.kotlin.koard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KoardApplication

fun main(args: Array<String>) {
    runApplication<KoardApplication>(*args)
}
