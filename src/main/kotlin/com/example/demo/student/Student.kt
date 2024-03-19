package com.example.demo.student

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table
data class Student(
        @Id
        @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
        var id: Long?,
        var name: String,
        var email: String,
        var dateOfBirth: LocalDate,
        var age: Int
) {
        constructor(name: String, email: String, dateOfBirth: LocalDate, age: Int): this(null, name, email, dateOfBirth, age)
}