package com.example.demo

import com.example.demo.student.Student
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@SpringBootApplication
@RestController
class DemoApplication {
	@GetMapping
	fun hello() = listOf(Student(1, "Pepe", "pepe@example.com", LocalDate.of(2000, Month.JANUARY, 5), 24))
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}