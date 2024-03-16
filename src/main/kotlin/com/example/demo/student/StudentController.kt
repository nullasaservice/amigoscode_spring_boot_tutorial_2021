package com.example.demo.student

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/student")
class StudentController(val studentService: StudentService) {
    @GetMapping
    fun getStudents() = studentService.getStudents()
}