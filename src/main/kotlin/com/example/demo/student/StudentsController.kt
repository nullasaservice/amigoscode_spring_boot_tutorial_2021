package com.example.demo.student

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping("/api/v1/students")
class StudentsController {
    @GetMapping
    fun index() = listOf(Student(1, "Pepe", "pepe@example.com", LocalDate.of(2000, Month.JANUARY, 5), 24))
}