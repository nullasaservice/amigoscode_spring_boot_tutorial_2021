package com.example.demo.student

import java.time.LocalDate

data class Student(val id: Long, var name: String, var email: String, var dateOfBirth: LocalDate, var age: Int)