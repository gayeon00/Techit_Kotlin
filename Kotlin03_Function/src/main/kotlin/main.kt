fun main() {
    test1()
    test2(100,11.11)
    // 함수를 호출할 때 넘겨주는 값을 어떤 매개변수에 담을지 정할 수 있다.
    test2(a2=22.22, a1=200)
    //기본 값을 가지고 있는 함수 호출
    test3(100,200)
    test3(100)
    test3(a2 = 200)
    test3()

    // 반환값이 있는 메서드 호출
    var r1 = test4(100, 200)
    println("r1 : $r1")

    //반환 값이 없는 함수
    test5()
    test6()

    // overloading 개념을 적용하여 만든 함수들 호출
    test7()
    test7(100)
    test7(100, 11.11)

    //지역함수를 가진 함수 호출
    test8()
}

//함수 밖에 변수 선언
//Java 코드로 변경되면 파일이름클래스 내부의 static 변수로 정의됨
//-> test1같은 static변수 내부에서 사용할 수 있다는 거니까!
var a1: Int = 100

//기본함수
//fun 함수이름(매개변수): 반환타입 {
//Java 코드로 변경되면 파일이름클래스 내부의 static 메서드로 정의됨
fun test1() {
    println("test1 호출")
    //함수 밖의 변수 사용
    println("a1: $a1")
    println("----------------------")
}

//함수의 매개변수
//타입을 생략할 수 없다!
fun test2(a1: Int, a2: Double){
    println("test2호출")
    println("a1: $a1")
    println("a2: $a2")
}

//기본 값을 가지고 있는 매개변수
fun test3(a1:Int = 1, a2:Int = 2){
    println("test3 호출")
    println("a1: $a1")
    println("a2: $a2")
}

// 반환타입
// 매개변수 뒤에 반환할 값의 타입을 작성해준다.
fun test4(a1:Int, a2:Int) : Int {
    return a1 + a2
}

//반환 값이 없는 경우 반환 타입에 Unit을 작성
fun test5(): Unit {
    println("test5 함수 호출")
}

//Unit 생략해도 됨
fun test6() {
    println("test6 함수 호출")
}

//Overloading: 매개변수의 형태(개수, 타입)을 다르게 하여
//같은 이름의 함수를 다수 만들 수 있는 개념
fun test7() {
    println("test7 호출 - 매개변수 없음")
}

fun test7(a1: Int){
    println("test7 호출 - a1: $a1")
}

fun test7(a1: Int, a2: Double){
    println("test7 호출 - a1: $a1, a2: $a2")
}

// 지역 함수
// 함수 내부에 만든 함수 로써 함수 내부에서만 사용이 가능하다.
fun test8(){
    println("test8 호출")

    fun test9(){
        println("test9 호출")
    }
    // 지역함수 호출
    test9()
}