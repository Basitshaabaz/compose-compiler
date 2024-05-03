package com.example.application.model

import androidx.compose.runtime.Immutable
import java.time.LocalDate


data class Student(
    val id:Long,
    val name:String,
    val registrationDate:LocalDate
)