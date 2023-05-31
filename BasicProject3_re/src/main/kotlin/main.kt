fun main() {
    val loginManager = LoginManager()
    val categoryManager = CategoryManager()
    val menu = Menu()
    var option: Int

    //로그인
    loginManager.running()

    do {
        menu.display()
        option = menu.selectOption()

        when (option) {
            1 -> {
                categoryManager.running()
            }
            2 -> {
                categoryManager.selectCategory()
            }
            3 -> {

            }
            4 -> {
                //종료 : 비우기
            }
            else -> println("유효하지 않은 메뉴입니다. 다시 선택해주세요.")
        }
    } while (option != 4)

}