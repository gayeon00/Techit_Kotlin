import java.util.*

fun main(){
    // 확장 함수
    // 이미 있는 클래스에 메서드를 추가하는 개념
    // 추가된 메서드는 같은 프로그램 내에서만 사용이 가능하다.
    // 자바 코드로 변경될 때 객체의 ID를 받아 사용하는 코드로 변경된다.

    val str1 = "abcd"

    // 추가한 메서드 호출
    println(str1.getUpperString())
    str1.printString()
}

// 확장함수 정의
// 클래스명.추가할 메서드
fun String.getUpperString() : String {
    return this.uppercase(Locale.getDefault())
}

fun String.printString() {
    println("문자열 : $this")
}