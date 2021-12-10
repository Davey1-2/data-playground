package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student
import java.util.stream.Collectors


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.stream().anyMatch { grade: Grade -> grade.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.stream()
        .map { obj: Student -> obj.age }
        .collect(Collectors.toList())
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.stream()
        .filter { student: Student -> student.age <= minAge }
        .collect(Collectors.toList())
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.stream()
        .filter { student: Student -> student.gender == Gender.MALE }
        .count().toInt()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.stream()
        .filter { student: Student -> student.gender == Gender.FEMALE }
        .mapToInt { obj: Student -> obj.age }
        .average()
        .orElseThrow()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.stream().mapToInt { obj: Student -> obj.age }
        .reduce { studentFirst: Int, studentSecond: Int -> studentFirst * studentSecond }
        .orElseThrow()
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.stream().mapToInt { grade: Grade -> grade.type.value }
        .filter { grade: Int -> grade != GradeType.F.value }
        .reduce { grade1: Int, grade2: Int -> grade1 * grade2 }
        .orElseThrow()
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion
