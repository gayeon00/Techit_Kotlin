import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("숫자1 입력 : ")
    val number1 = scanner.nextInt()

    print("숫자2 입력 : ")
    val number2 = scanner.nextInt()

    val cal = Calculator()
    val r1 = cal.processing(number1, number2) { a1: Int, a2: Int ->
        a1 + a2
    }
    val r2 = cal.processing(number1, number2) { a1: Int, a2: Int ->
        a1 - a2
    }
    val r3 = cal.processing(number1, number2) { a1: Int, a2: Int ->
        a1 * a2
    }
    val r4 = cal.processing(number1, number2) { a1: Int, a2: Int ->
        a1 / a2
    }
    println(r1)
    println(r2)
    println(r3)
    println(r4)
}

class Calculator2 {
    fun processing(a1: Double, a2: Double, m: (Double, Double) -> Double): Double {
        return m(a1, a2)
    }
}

// 계산기
class Calculator {

    fun processing(a1: Int, a2: Int, m1: (Int, Int) -> Int): Int {
        return m1(a1, a2)
    }
}