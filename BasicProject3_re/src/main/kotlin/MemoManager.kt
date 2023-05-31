import java.io.*
import java.util.*

class MemoManager(private val category: Category) {
    private var option = 0
    private val file = File("categoryList.txt")
    private val sc = Scanner(System.`in`)
    private val br = BufferedReader(InputStreamReader(System.`in`))


    private fun saveMemoToFile() {
        try {
            val fos = FileOutputStream(file)
            val oos = ObjectOutputStream(fos)

            oos.writeObject(category)
        } catch (e: Exception) {
            println("에러 : categoryList 저장 에러")
        }
    }

    fun running() {
        do {
            printMemoList()
            showMemoMenu()
            option = selectOption()

            when (option) {
                1 -> {
                    accessMemo()
                }
                2 -> {
                    addMemo()
                }
                3 -> {
                    editMemo()
                }
                4 -> {
                    deleteMemo()
                }
                5 -> {
                    //이전: 비우기
                }
                else -> println("유효하지 않은 메뉴입니다. 다시 선택해주세요.")
            }

        } while (option != 5)
    }

    private fun accessMemo() {
        while (true) {
            printMemoList()
            print("확인할 메모의 번호를 입력해주세요 (0. 이전) : ")
            val num = sc.nextInt()

            if (num == 0) break

            if (num in 1..category.memoList.size) {
                println()
                category.memoList[num - 1].printMemo()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

    private fun printMemoList() {
        println()
        if (category.memoList.isEmpty()) {
            println("등록된 메모가 없습니다.")
        } else {
            for (i in 0 until category.memoList.size) {
                println("${i + 1} : ${category.memoList[i].title}")
            }
        }
    }

    private fun showMemoMenu() {
        println()
        print("1. 메모보기, 2. 메모등록, 3. 메모수정, 4. 메모삭제, 5. 이전 : ")
    }

    private fun selectOption(): Int {
        return sc.nextInt()
    }

    private fun addMemo() {
        println()
        print("메모 제목 : ")
        val title = br.readLine()
        print("메모 내용 : ")
        val content = br.readLine()
        category.memoList.add(Category.Memo(title, content))
        saveMemoToFile()
    }

    private fun deleteMemo() {
        while (true) {
            println()
            print("삭제할 메모의 번호를 입력해주세요 (0. 이전) : ")
            val num = sc.nextInt()

            if (num == 0) break

            if (num in 1..category.memoList.size) {
                category.memoList.removeAt(num - 1)
                saveMemoToFile()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

    private fun editMemo() {
        while (true) {
            println()
            print("수정할 메모의 번호를 입력해주세요 (0. 이전) : ")
            val num = sc.nextInt()

            if (num == 0) break

            if (num in 1..category.memoList.size) {
                println("제목 : ${category.memoList[num - 1].title}")
                print("메모의 새로운 제목을 입력해주세요 (0 입력 시 무시) : ")
                val tmp = br.readLine()
                val newTitle = if (tmp == "0") category.memoList[num - 1].title else tmp

                println("내용 : ${category.memoList[num - 1].contents}")
                print("메모의 새로운 내용을 입력해주세요 (0 입력 시 무시) : ")
                val tmp2 = br.readLine()
                val newContent = if (tmp2 == "0") category.memoList[num - 1].contents else tmp2


                category.memoList[num - 1] = Category.Memo(newTitle, newContent)
                saveMemoToFile()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

}
