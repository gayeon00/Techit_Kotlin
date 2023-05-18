import java.util.*

fun main() {
    val school = School()

    school.getStudent()
    school.printStudentList()

    school.ClassRoom().study()
    school.Field().playSoccer()
    school.Stadium().playVolleyBall()
    school.Pool().swim()

    school.printSchoolInfo()
}

//학교 클래스
//축구부 클래스
//배구부 클래스
//수영부 클래스

//교실 클래스 : 공부하기
//운동장 클래스 : 축구하기
//체육관 클래스 : 배구하기
//수영장 클래스 : 수영하기

//학생 클래스 -> 학생 정보 출력 기능, 공부하는 기능
//축구부 학생 클래스 -> 축구하는 기능, 수영하는 기능
//배구부 학생 클래스 -> 배구하는 기능, 축구하는 기능
//수영부 학생 클래스 -> 수영하는 기능, 배구하는 기능


class School {
    val studentList = arrayListOf<Student>()
    val sc = Scanner(System.`in`)

    //입력 통해 학생 받는 메서드
    fun getStudent() {
        while (true) {
            println("어디 소속 학생을 입력하시겠어요?")
            print("1. 소속 없음, 2. 축구부, 3. 배구부, 4. 수영부, 0. 종료 : ")
            val inputNum = sc.nextInt()

            if(inputNum !in 0..4){
                println("잘못된 입력입니다.")
                continue
            }

            if (inputNum == 0) {
                break
            }

            println("나머지 학생 정보를 입력해주세요.")
            print("이름 : ")
            val name = sc.next()
            print("학년 : ")
            val grade = sc.nextInt()
            print("국어 : ")
            val korScore = sc.nextInt()
            print("영어 : ")
            val engScore = sc.nextInt()
            print("수학 : ")
            val matScore = sc.nextInt()

            studentList.add(createStudent(inputNum, name, grade, korScore, engScore, matScore))
        }
    }

    fun createStudent(inputNum: Int, name: String, grade: Int, korScore: Int, engScore: Int, matScore: Int) =
        when (inputNum) {
            1 -> {
                Student(Department.DEFAULT, name, grade, korScore, engScore, matScore)
            }

            2 -> {
                SoccerClubStudent(Department.SOCCER, name, grade, korScore, engScore, matScore)
            }
            3 -> {
                VolleyBallClubStudent(Department.VOLLEY, name, grade, korScore, engScore, matScore)
            }
            4 -> {
                SwimmingClubStudent(Department.SWIM, name, grade, korScore, engScore, matScore)
            }
            else -> {
                Student(Department.DEFAULT, "", 0, 0, 0, 0)
            }
        }

    //학생 리스트 출력 메서드
    fun printStudentList() {
        for (student in studentList) {
            student.printStudentInfo()
        }
    }

    //학교 정리 출력 메서드
    fun printSchoolInfo() {
        println("전체 학생 수 : ${studentList.size}")
        println("일반 학생 수 : ${studentList.size - (getSoccerClubCount()+getSwimClubCount()+getVolleyClubCount())}")
        println("축구부 학생 수 : ${getSoccerClubCount()}명")
        println("배구부 학생 수 : ${getVolleyClubCount()}명")
        println("수영부 학생 수 : ${getSwimClubCount()}명")
        println("축구를 하는 학생 수 : ${getSoccerPlayerCount()}명")
        println("배구를 하는 학생 수 : ${getVolleyPlayerCount()}명")
        println("수영을 하는 학생 수 : ${getSwimPlayerCount()}명")
    }

    fun getSoccerPlayerCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is SoccerPlayer) count++
        }
        return count
    }

    fun getVolleyPlayerCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is VolleyBallPlayer) count++
        }
        return count

    }

    fun getSwimPlayerCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is SwimmingPlayer) count++
        }
        return count

    }

    fun getSoccerClubCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is SoccerClubStudent) count++
        }
        return count
    }

    fun getVolleyClubCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is VolleyBallClubStudent) count++
        }
        return count

    }

    fun getSwimClubCount(): Int {
        var count = 0
        for (student in studentList) {
            if (student is SwimmingClubStudent) count++
        }
        return count

    }

    inner class ClassRoom{
        fun study(){
            for(student in studentList){
                student.study()
            }
        }
    }
    inner class Field{
        fun playSoccer(){
            for(student in studentList){
                if(student is SoccerPlayer){
                    student.playSoccer()
                }
            }
        }
    }

    inner class Stadium{
        fun playVolleyBall(){
            for(student in studentList){
                if(student is VolleyBallPlayer){
                    student.playVolleyBall()
                }
            }
        }
    }

    inner class Pool{
        fun swim(){
            for(student in studentList){
                if(student is SwimmingPlayer){
                    student.swim()
                }
            }
        }
    }
}

enum class Department(val title:String){
    DEFAULT("일반"), SOCCER("축구"), VOLLEY("배구"), SWIM("수영")
}

open class Student(
    var department: Department,
    var name: String,
    var grade: Int,
    var korScore: Int,
    var engScore: Int,
    var matScore: Int,
) {
    fun printStudentInfo() {
        println("소속 : ${department.title}부")
        println("이름 : ${name}")
        println("학년 : ${grade}")
        println("국어 : ${korScore}")
        println("영어 : ${engScore}")
        println("수학 : ${matScore}")
        println("개인 총점 : ${korScore + engScore + matScore}점")
        println("개인 평균 : ${(korScore + engScore + matScore).toDouble() / 3}점")
    }

    fun study() {
        println("$name 학생이 교실에서 공부하고 있습니다.")
    }
}

class SoccerClubStudent(department: Department, name: String, grade: Int, korScore: Int, engScore: Int, matScore: Int) :
    Student(department, name, grade, korScore, engScore, matScore), SoccerPlayer, SwimmingPlayer {
    override fun playSoccer() {
        println("$name 학생이 운동장에서 축구를 하고 있습니다.")
    }

    override fun swim() {
        println("$name 학생이 수영장에서 수영을 하고 있습니다.")

    }
}

class VolleyBallClubStudent(department: Department, name: String, grade: Int, korScore: Int, engScore: Int, matScore: Int) :
    Student(department, name, grade, korScore, engScore, matScore), VolleyBallPlayer, SoccerPlayer {
    override fun playSoccer() {
        println("${name} 학생이 운동장에서 축구를 하고 있습니다.")
    }

    override fun playVolleyBall() {
        println("${name} 학생이 체육관에서 배구를 하고 있습니다.")
    }
}

class SwimmingClubStudent(department: Department, name: String, grade: Int, korScore: Int, engScore: Int, matScore: Int) :
    Student(department, name, grade, korScore, engScore, matScore), SwimmingPlayer, VolleyBallPlayer {
    override fun playVolleyBall() {
        println("${name} 학생이 체육관에서 배구를 하고 있습니다.")
    }

    override fun swim() {
        println("${name} 학생이 수영장에서 수영을 하고 있습니다.")
    }
}

interface SoccerPlayer {
    fun playSoccer()
}

interface VolleyBallPlayer {
    fun playVolleyBall()
}

interface SwimmingPlayer {
    fun swim()
}




