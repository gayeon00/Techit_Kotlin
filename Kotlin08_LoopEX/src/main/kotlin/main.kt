import java.util.*

fun  main() {
    val scanner = Scanner(System.`in`);
    print("몇 명의 학생 정보를 입력 받을까요? : ")
    val numStudent = scanner.nextInt()

    val nameList = ArrayList<String>()
    val gradeList = ArrayList<Int>()
    val koreanScoreList = ArrayList<Int>()
    val englishScoreList = ArrayList<Int>()
    val mathScoreList = ArrayList<Int>()

    for(i in 1..numStudent){
        println("${i+1}번째 학생 정보 입력")
        print("이름 : ")
        nameList.add(scanner.next());
        print("학년 : ")
        gradeList.add(scanner.nextInt())
        print("국어 성적 : ")
        koreanScoreList.add(scanner.nextInt())
        print("영어 성적 : ")
        englishScoreList.add(scanner.nextInt())
        print("수학 성적 : ")
        mathScoreList.add(scanner.nextInt())
    }

    println("----------학생 정보 출력----------")

    var koreanTotal = 0
    var englishTotal = 0
    var mathTotal = 0
    for(i in 0 until numStudent){
        println("${i+1}번째 학생")
        println("이름 : ${nameList[i]}")
        println("학년 : ${gradeList[i]}")
        koreanTotal+=koreanScoreList[i]
        println("국어 성적 : ${koreanScoreList[i]}")
        englishTotal+=englishScoreList[i]
        println("영어 성적 : ${englishScoreList[i]}")
        mathTotal+=mathScoreList[i]
        println("수학 성적 : ${mathScoreList[i]}")
    }

    println("-----------과목 별 총점-----------")
    println("국어 : $koreanTotal")
    println("영어 : $englishTotal")
    println("수학 : $mathTotal")

    println("-----------과목 별 평균-----------")
    println("국어 : ${koreanTotal/numStudent}")
    println("영어 : ${englishTotal/numStudent}")
    println("수학 : ${mathTotal/numStudent}")

}