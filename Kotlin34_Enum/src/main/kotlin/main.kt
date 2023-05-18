fun main() {
    // 열거형
    // 프로그램 개발 시 특정 그룹 안의 구성요소를 정의하는 값이 필요할 때 사용한다.
    // 월을 나타내는 단어들, 혈액형을 나타내는 단어들, 방향, 성별 등...

    printDirection(Direction.NORTH)
    printDirection(Direction.WEST)

    printDirection2(Direction2.NORTH)
    printDirection2(Direction2.WEST)

    printNumber(Number.TWO)

}

// companion
class Direction2 {
    companion object {
        val NORTH = 0
        val SOUTH = 1
        val WEST = 2
        val EAST = 3
    }
}

//열거형 정의
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun printDirection(a1: Direction) {
    when (a1) {
        Direction.NORTH -> println("북쪽")
        Direction.SOUTH -> println("남쪽")
        Direction.WEST -> println("서쪽")
        Direction.EAST -> println("동쪽")
    }
}

fun printDirection2(a1: Int) {
    when (a1) {
        Direction2.NORTH -> println("북쪽")
        Direction2.SOUTH -> println("남쪽")
        Direction2.WEST -> println("서쪽")
        Direction2.EAST -> println("동쪽")
    }
}

// 열거형을 정의할 때 값도 설정할 수 있다.
// 주 생성자는 열거형 하나를 만드는 양식을 의미한다.
// 변수의 개수는 무제한이다
enum class Number(val num: Int, val str: String) {
    ONE(1, "하나"), TWO(2, "둘"), THREE(2, "셋")
}

fun printNumber(a1: Number) {
    when (a1) {
        Number.ONE -> println("one")
        Number.TWO -> println("tow")
        Number.THREE -> println("three")
    }

    when(a1.num) {
        1-> println("1이다")
        2 -> println("2이다")
        3 -> println("3이다")
    }

    when(a1.str){
        "하나"-> println("하나이다")
        "둘" -> println("둘이다")
        "셋" -> println("셋이다")
    }
}