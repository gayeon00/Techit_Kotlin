import java.util.*

fun main() {
    val mainClass = MainClass()
    mainClass.running()
}


// 프로그램 상태를 나타내는 enum
enum class ProgramState {
    // 학생 정보 입력받는 상태
    PROGRAM_STATE_INPUT_STUDENT_INFO,
    PROGRAM_STATE_PRINT_STUDENT_INFO
}

// 학생 정보를 관리하는 클래스
data class Student(var name: String, var kor: Int) {
    fun printInfo() {
        println()
        println("이름 : $name")
        println("국어 : $kor")
    }
}

// 메인 클래스
class MainClass {

    val sc = Scanner(System.`in`)
    val studentList = mutableListOf<Student>()

    // 학생 정보를 입력받는 상태를 초기 상태로 설정
    var programState = ProgramState.PROGRAM_STATE_INPUT_STUDENT_INFO

    // 프로그램 상태 전체를 관리하며 운영하는 메서드
    fun running() {
        while (true) {
            println()
            when (programState) {
                //학생 정보 입력 받는 상태
                ProgramState.PROGRAM_STATE_INPUT_STUDENT_INFO -> {
                    inputStudentInfoState()
                    programState = ProgramState.PROGRAM_STATE_PRINT_STUDENT_INFO
                }
                //학생 정보 출력하는 상태
                ProgramState.PROGRAM_STATE_PRINT_STUDENT_INFO -> {
                    printStudentListInfo()
                    break
                }
            }
        }
    }

    fun inputStudentInfo() {
        println()
        print("이름 : ")
        val name = sc.next()
        print("국어 : ")
        val kor = sc.nextInt()

        val student = Student(name, kor)
        studentList.add(student)
    }

    //학생정보 입력 상태 처리 메서드
    fun inputStudentInfoState() {
        while (true) {
            print("학생 정보를 입력 하시겠슴까? (1. 입력, 2. 입력 종료) : ")
            when (sc.nextInt()) {
                1 -> {
                    inputStudentInfo()
                }
                2 -> {
                    break
                }
            }
        }
    }

    fun printStudentListInfo() {
        for (student in studentList) {
            println()
            student.printInfo()
        }
    }
}