fun main(){
    val a1 = 5

    when(a1){
        //수행될 코드가 한줄만 있다면 {} 생략
        1 -> println("a1은 1입니다")
        //수행될 코드가 두줄 이상이면 {}로 묶어줌
        5 -> {
            println("a1은 5입니다")
            println("코드가 두줄")
            println("코드가 세줄")
        }
        10 -> println("a1은 10입니다")
        else -> println("a1은 1,5,10이 아닙니다")
    }

    // 두 가지 이상의 조건을 만족하는 것도 설정이 가능하다.
    val a2 = 3
    when(a2){
        1, 2 -> println("a2는 1이거나 2입니다")
        3, 4 -> println("a2는 3이거나 4입니다")
        5, 6 -> println("a2는 5이거나 6입니다")
        else -> println("a2는 1, 2, 3, 4, 5, 6이 아닙니다")
    }

    // 실수도 가능하다.
    val a3 = 55.55
    when(a3){
        33.33 -> println("a3은 33.33입니다")
        55.55 -> println("a3은 55.55입니다")
        77.77 -> println("a3은 77.77입니다")
        else -> println("a3은 33.33, 55.55, 77.77 이 아닙니다")
    }

    // 문자열
    val a4 = "문자열2"
    when(a4){
        "문자열1" -> println("첫 번째 문자열 입니다")
        "문자열2" -> println("두 번째 문자열 입니다")
        "문자열3" -> println("세 번째 문자열 입니다")
        else -> println("else 문자열 입니다")
    }

    // 논리값
    // 논리값은 허용되지 않는다.
//    val a5 = true
//    when(a5){
//
//    }

    // 범위 지정
    val a5 = 5
    when(a5){
        in 1..3 -> println("a5는 1부터 3사이입니다")
        in 4..6 -> println("a5는 4부터 6사이입니다")
        in 1..6 -> println("a5는 1부터 6사이입니다")
        else -> println("a5는 1 ~ 6사이의 숫자가 아닙니다")
    }

    val str1 = setValue1(1)
    val str2 = setValue1(2)
    val str3 = setValue1(3)
    println("str1 : $str1")
    println("str2 : $str2")
    println("str3 : $str3")

    val str4 = setValue2(1)
    val str5 = setValue2(2)
    val str6 = setValue2(3)
    println("str4 : $str4")
    println("str5 : $str5")
    println("str6 : $str6")

}

fun setValue1(a1:Int) : String{
    if(a1 == 1){
        return "문자열1"
    } else if(a1 == 2){
        println("두 번째 경의 수")
        return "문자열2"
    } else {
        return "그 외의 문자열"
    }
}

// when 사용
// when에 설정한 변수의 값에 따라서 해당 부분에 제일 마지막에 작성한
// 값을 반환한다.
fun setValue2(a1:Int) = when(a1){
    1 -> "문자열1"
    2 -> {
        println("두 번째 경우의 수")
        "문자열2"
    }
    else -> "그 외의 문자열"
}