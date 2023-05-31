fun main(){
    // inline 함수
    // 자바 코드로 변경될 때 inline 함수를 호출하는 부분들은
    // 함수 내부의 코드로 변경된다.
    // 코드가 다소 늘어나지만 함수 호출과 관련된 작업을 하지 않는 장점이 있다.
    // 딱 한번만 사용하는 함수가 있을 때 사용하는 경우가 종종 있다.

    testFunction1()
    testFunction1()

    testFunction2()
    testFunction2()
}

fun testFunction1(){
    println("----------------------------")
    println("testFunction1")
    println("----------------------------")
}

inline fun testFunction2(){
    println("----------------------------")
    println("testFunction2")
    println("----------------------------")
}