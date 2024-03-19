package com.example.demo.student

import jakarta.persistence.*
import java.time.LocalDate
import java.time.Period

@Entity
@Table
data class Student(
        @Id
        @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
        var id: Long?,
        var name: String,
        var email: String,
        var dateOfBirth: LocalDate?
) {

        constructor(name: String, email: String, dateOfBirth: LocalDate): this(null, name, email, dateOfBirth)

        fun getAge(): Int? {
                if (dateOfBirth == null) return null

                return Period.between(dateOfBirth, LocalDate.now()).years
        }
}