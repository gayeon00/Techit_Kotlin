fun main(){
    testFunction1()

    // 코틀린은 함수의 이름을 통해 다른 변수에 함수를 넣는 것은 불가능하다.
    // val testFunction2 = testFunction1

    testFunction2()
}

fun testFunction1(){
    println("testFunction1 입니다")
}

// 익명함수
//함수에 변수를 담아 관리할 때 사용한다.
//익명 함수는 아래 예제와 같이 중괄호({})를 열고 닫아 그 내부에 작성합니다.
val testFunction2 = fun(){
    println("익명 함수 입니다")
}

//코틀린에서는 람다표현식(==람다함수)과 익명함수의 개념을 명확히 구분한다.
//익명함수는 함수의 리턴값의 자료형을 지정해 줄 수 있고 람다 표현식은 그렇지 못하다
//https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions
{ x: Int, y: Int -> x + y }
fun(x: Int, y: Int): Int = x + y