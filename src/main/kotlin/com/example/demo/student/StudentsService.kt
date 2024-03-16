package com.example.demo.student

import java.time.LocalDate
import java.time.Month

class StudentService {
    fun getStudents() = listOf(Student(1, "Pepe", "pepe@example.com", LocalDate.of(2000, Month.JANUARY, 5), 24))
}