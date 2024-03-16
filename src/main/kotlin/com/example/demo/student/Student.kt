package com.example.demo.student

import java.time.LocalDate

data class Student(var id: Long, val name: String, val email: String, val dateOfBirth: LocalDate, val age: Int)