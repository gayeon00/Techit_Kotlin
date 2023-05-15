fun main() {
    val a1: Int = 10

    if(a1 == 10){
        println("a1은 10입니다")
    }
    if(a1 == 20){
        println("a1은 20입니다")
    }

    if(a1 == 20){
        println("a1은 20입니다")
    } else {
        println("a1은 20이 아닙니다")
    }

    if(a1 == 0){
        println("a1은 0입니다")
    } else if(a1 == 10){
        println("a1은 10입니다")
    } else if(a1 == 20){
        println("a1은 20입니다")
    } else {
        println("a1은 0, 10, 20이 아닙니다.")
    }

    var a4: String = ""
    val a5: Int = 10

    if(a5==10){
        a4 = "10 입니다"
    } else {
        a4 = "10이 아닙니다"
    }

    println("a4 : $a4")

    // 위의 코드를 아래와 같이 작성할 수 있다.
    val a6:String = if (a5 == 10) "10d 입니다" else "10이 아닙니다"
    println("a6 : $a6")

    var a7: String = ""

    //변수에 저장될 값을 어떠한 처리나 계산을 통해
    //구한 다음 변수에 저장하는 경우
    if(a5 == 10){
        var a8:String = ""
        a8 += "안녕하세요 "
        a8 += "반갑습니다"
        a7 = a8
    } else {
        var a8:String = ""
        a8 += "감사합니다 "
        a8 += "또 만났네요"
        a7 = a8
    }

    print("a7: $a7")

    // 위의 코드는 아래와 같이 작성할 수 있다.
    // 각 코드 블럭 내에서 제일 마지막에 작성한 값이나 변수의 값을
    // 변수에 저장해준다
    val a9:String = if(a5 == 10) {
        var a8: String = ""
        a8 += "안녕하세요 "
        a8 += "반갑습니다"
        a8
    } else {
        var a8:String = ""
        a8 += "감사합니다 "
        a8 += "또 만났네요"
        a8
    }
    println("a9 : $a9")
}