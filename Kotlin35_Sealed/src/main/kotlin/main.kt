fun main() {
    //enum은 무언가를 의미하는 값들을 관리하는 개념
    // 값을 바꾸거나, 값을 그 자체로 출력해보거나 하지 않음
    // 분기용으로 많이 씀

    //sealed 클래스는 클래스들을 모아 관리하는 개념

    checkNumber1(Number1.TWO)

//    println(Number1.TWO)
    Number1.TWO.num = 100
    Number1.TWO.str = "안녕하세요"
    //안바뀜!!
    checkNumber1(Number1.TWO)

    //Sealed 클래스 내부에 정의한 클래스의 객체를 생성한다.
    val s1 = Number2.One(100,200)
    val s2 = Number2.Two(100)
    val s3 = Number2.Three(100,11.11)
    val s4 = Number2.Two(400)

    checkNumber2(s1)
    checkNumber2(s2)
    checkNumber2(s3)
    checkNumber2(s4)
}

enum class Number1(var num: Int, var str: String) {
    ONE(1, "일"), TWO(2, "이"), THREE(3, "삼")
}

fun checkNumber1(a1: Number1) {
    when (a1) {
        Number1.ONE -> println("ONE 입니당")
        Number1.TWO -> println("TWO 입니당")
        Number1.THREE -> println("THREE 입니당")
    }

    when (a1.num) {
        1 -> println("1입니당")
        2 -> println("2입니당")
        3 -> println("3입니당")
    }

    when (a1.str) {
        "일" -> println("일입니당")
        "이" -> println("이입니당")
        "삼" -> println("삼입니당")
    }
}

//그냥 특정 틀래스를 상속받은 여러 자식 클래스들을 한데 모아 관리하는 것!!
//그 이상 그 이하도 아님
sealed class Number2 {
    open fun number2Method() {
        println("Number2의 number2Method입니다.")
    }

    class One(var a1: Int, var a2: Int) : Number2()
    class Two(var a1: Int) : Number2() {
        fun twoMethod() {
            println("Two의 메서드 입니다")
        }

        override fun number2Method() {
            println("overriding된 number2메서드")
        }
    }

    class Three(var a1: Int, var a2: Double) : Number2()
}

//sealed 클래스를 매개변수로
fun checkNumber2(obj1: Number2) {
    //when으로 분기할 때, is를 통해 어떤 클래스로 만든 객체인지 확인
    when(obj1){
        is Number2.One -> {
            // 스마트 캐스팅도 이루어진다.
            println("OneClass 입니다")
            println(obj1.a1)
            println(obj1.a2)
            obj1.number2Method()
        }
        is Number2.Two -> {
            println("TwoClass 입니다")
            println(obj1.a1)
            obj1.twoMethod()
            obj1.number2Method()
        }
        is Number2.Three -> {
            println("ThreeClass 입니다")
            println(obj1.a1)
            println(obj1.a2)
            obj1.number2Method()
        }
    }
}
