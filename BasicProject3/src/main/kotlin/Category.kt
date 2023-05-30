import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Serializable
import java.util.*

class Category(
    var name: String,
    var memoList: ArrayList<Memo>
): Serializable {
    val sc = Scanner(System.`in`)
    val br = BufferedReader(InputStreamReader(System.`in`))

    fun run() {
        printMemoList()
        getInputNumber()
    }

    override fun toString(): String {
        return "Category(name = $name, memoList = $memoList)"
    }

    fun getInputNumber() {
        while (true) {
            println()
            println("1. 메모보기")
            println("2. 메모등록")
            println("3. 메모수정")
            println("4. 메모삭제")
            print("5. 이전 : ")
            try {
                val input = sc.nextInt()

                if (input !in 1..5) {
                    println("잘못된 입력입니다.")
                }

                when (input) {
                    1 -> getMemo()
                    2 -> addMemo()
                    3 -> editMemo()
                    4 -> deleteMemo()
                    5 -> break
                }
            } catch (e: Exception) {
                sc.nextLine()
                println()
                println("잘못된 입력입니다.")
            }
        }
    }

    private fun deleteMemo() {
        while (true) {
            println()
            print("삭제할 메모의 번호를 입력해주세요 (0. 이전) : ")
            try {
                val input = sc.nextInt()

                if (input == 0) break

                memoList.removeAt(input - 1)
                break
            } catch (e: InputMismatchException) {
                sc.nextLine()
                println("잘못 입력했습니다.")
            } catch (e: Exception) {
                println("잘못 입력했습니다.")
            }
        }
    }

    private fun editMemo() {
        while (true) {
            println()
            print("수정할 메모의 번호를 입력해주세요 (0. 이전) : ")
            try {
                val input = sc.nextInt()


                if (input == 0) break


                val memo = memoList[input - 1]

                println()
                println("현제 제목 : ${memo.title}")
                print("메모의 새로운 제목을 입력해주세요 (0 입력 시 무시) : ")
                val temp = br.readLine()
                val new_title = if (temp == "0") memo.title else temp

                println("현재 내용 : ${memo.contents}")
                print("메모의 새로운 내용을 입력해주세요 (0 입력 시 무시) : ")
                val temp2 = br.readLine()
                val new_content = if (temp2 == "0") memo.contents else temp2

                memoList[input - 1] = Memo(new_title, new_content)
                break
            } catch (e: InputMismatchException) {
                sc.nextLine()
                println("잘못 입력했습니다.")
            } catch (e: Exception) {
                println("잘못 입력했습니다.")
            }
        }
    }

    private fun addMemo() {
        println()
        print("메모 제목 : ")
        val title = br.readLine()
        print("메모 내용 : ")
        val content = br.readLine()

        memoList.add(Memo(title, content))
    }

    private fun getMemo() {
        if(memoList.isEmpty()){
            println()
            println("등록된 메모가 없습니다.")
        }
        else {
            while (true) {
                println()
                print("확인할 메모의 번호를 입력해주세요 (0. 이전) : ")
                try {
                    val number = sc.nextInt()

                    if (number == 0) break

                    val memo = memoList[number - 1]
                    memo.printMemo()
                    print("이전으로 돌아가려면 0을 입력하세요 : ")
                    val temp = sc.nextInt()
                    sc.nextLine()

                    if (temp == 0) break
                } catch (e: InputMismatchException) {
                    sc.nextLine()
                    println("잘못된 입력입니다.")
                } catch (e: Exception) {
                    println("잘못된 입력입니다.")
                }

            }
        }

    }

    private fun printMemoList() {
        if (memoList.isEmpty()) {
            println("등록된 메모가 없습니다.")
        }
        for (i in memoList) {
            i.printMemo()
        }
    }
}

