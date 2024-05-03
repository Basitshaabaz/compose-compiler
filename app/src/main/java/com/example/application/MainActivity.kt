package com.example.application

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application.model.Student
import com.example.application.ui.theme.MyApplicationTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val students = listOf(
                        Student(1, "Alice", LocalDate.now()),
                        Student(2, "Bob", LocalDate.now()),
                        Student(3, "Charlie", LocalDate.now())
                    )


                    StudentList(
                        students = students,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Student(student: Student, modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "Hello ${student.name}!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.size(2.dp))
        Registration(student.registrationDate)
    }
}

@Composable
fun Registration(registrationDate: LocalDate) {
    Text(
        text = "Registration on ${registrationDate}!",
    )
}

@Composable
fun StudentList( modifier: Modifier = Modifier,students: List<Student>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        students.forEach { student ->
            Student(student = student, modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Student(Student(
            id = 1,
            name = "John Smith",
            registrationDate = LocalDate.now()
        ))
    }
}