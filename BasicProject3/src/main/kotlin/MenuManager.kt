import java.util.*

class MenuManager {
    // 1. 메모 카테고리 관리, 2. 카테고리 선택, 3. 메모 내용 전체보기, 4. 종료
    val sc = Scanner(System.`in`)
    val categoryManager = CategoryManager()

    //번호 입력받는 기능 -> 1,2,3,4
    private fun getNumberInput() {
        while (true) {
            println()
            println("1. 메모 카테고리 관리")
            println("2. 메모 카테고리 선택")
            println("3. 메모 내용 전체 보기")
            println("4. 종료")
            print("메뉴를 선택해주세요 : ")
            try {
                val input = sc.nextInt()

                when (input) {
                    1 -> categoryManager.run()
                    2 -> categoryManager.selectCategory()
                    3 -> categoryManager.printAllCategory()
                    4 -> break
                }
            } catch (e: Exception) {
                sc.nextLine()
                println("잘못된 입력입니다.")
            }

        }
    }


    fun run() {
        getNumberInput()
    }

//1. 메모 카테고리 관리 기능 -> CategoryManager 로!
}