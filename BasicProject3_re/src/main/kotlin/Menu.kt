import java.util.*

class Menu {
    fun display() {
        println()
        println("1. 메모 카테고리 관리")
        println("2. 메모 카테고리 선택")
        println("3. 메모 내용 전체 보기")
        println("4. 종료")
        print("메뉴를 선택해주세요 : ")
    }

    fun selectOption(): Int{
        val sc = Scanner(System.`in`)
        return sc.nextInt()
    }

}