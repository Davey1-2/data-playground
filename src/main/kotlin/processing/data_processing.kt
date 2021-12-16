package processing

import streams.Gender
import streams.Grade
import streams.GradeType
import streams.Student
import java.util.stream.Collectors


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { grade: Grade -> grade.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { obj: Student -> obj.age }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { student: Student -> student.age <= minAge }

}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.filter { student: Student -> student.gender == Gender.MALE }.count()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.asSequence()
        .filter { student: Student -> student.gender == Gender.FEMALE }
        .map { obj: Student -> obj.age }
        .average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.asSequence()
        .map { obj: Student -> obj.age }
        .reduce { studentFirst: Int, studentSecond: Int -> studentFirst * studentSecond }

}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.asSequence()
        .map { grade: Grade -> grade.type.value }
        .filter { grade: Int -> grade != GradeType.F.value }
        .reduce { grade1: Int, grade2: Int -> grade1 * grade2 }

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
