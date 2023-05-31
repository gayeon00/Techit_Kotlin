import java.io.*
import java.util.*

class CategoryManager {
    //1. 카테고리 등록, 2. 카테고리 삭제, 3. 카테고리 수정, 4. 이전페이지
//모든 동작 뒤엔 카테고리 리스트 프린트
    //카테고리 리스트
    var categoryList = arrayListOf<String>()
    val memoManagerList = arrayListOf<MemoManager>()
    val sc = Scanner(System.`in`)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val file = File("categoryList.txt")

    init {
        if (file.exists()) {
            loadCategoriesFromFile()
        } else {
            file.createNewFile()
        }

    }

    private fun loadCategoriesFromFile() {
        try {
            val fis = FileInputStream("categoryList.txt")
            val ois = ObjectInputStream(fis)

            while (true) {
                try {
                    categoryList.add(ois.readObject().toString())
                    memoManagerList.add(MemoManager())
                } catch (e: EOFException) {
                    break
                }
            }

            ois.close()
        } catch (e: Exception) {
//            e.printStackTrace()
        }
    }

    private fun saveCategoriesToFile(categoryList: List<String>) {
        try {
            val fos = FileOutputStream("categoryList.txt")
            val oos = ObjectOutputStream(fos)

            for (i in categoryList) {
                oos.writeObject(i)
            }
        } catch (e: Exception) {
//            e.printStackTrace()
        }
    }

    //번호 입력받는 기능 -> 1,2,3,4
    private fun getNumberInput() {
        while (true) {
            printCategoryList()
            println()
            println("1. 카테고리 등록")
            println("2. 카테고리 삭제")
            println("3. 카테고리 수정")
            println("4. 이전")
            print("카테고리 관리 메뉴 선택 : ")
            try {
                val input = sc.nextInt()

                if (input !in 1..4) {
                    println("잘못된 입력입니다.")
                    continue
                }

                when (input) {
                    1 -> registerCategory()
                    2 -> deleteCategory()
                    3 -> editCategory()
                    4 -> break
                }
            } catch (e: Exception) {
                sc.nextLine()
                println()
                println("잘못된 입력입니다.")
            }
        }
    }

    //1. 카테고리 등록 -> "등록할 카테고리 이름을 입력해주세요 : "
    private fun registerCategory() {
        println()
        print("등록할 카테고리 이름을 입력해주세요 : ")
        val categoryName = br.readLine()
        categoryList.add(categoryName)
        memoManagerList.add(MemoManager())
        saveCategoriesToFile(categoryList)
    }


    //2. 카테고리 삭제 -> 잘못입력하면 다시
    //삭제 됐으면 다시 카테고리 매니저 번호 입력 기능으로
    private fun deleteCategory() {
        while (true) {
            println()
            print("삭제할 카테고리 번호를 입력해주세요 : ")

            try {
                val input = sc.nextInt()

                categoryList.removeAt(input - 1)
                memoManagerList.removeAt(input - 1)
                saveCategoriesToFile(categoryList)
                break
            } catch (e: InputMismatchException) {
                sc.nextLine()
                println("잘못 입력하였습니다.")
            } catch (e: Exception) {
                println("잘못 입력하였습니다.")
            }
        }

    }

    //3. 카테고리 수정
    private fun editCategory() {
        while (true) {
            println()
            print("수정할 카테고리 번호를 입력해주세요 : ")


            try {
                val input = sc.nextInt()

                print("${categoryList[input - 1]} -> ")
                val newCategory = br.readLine()
                categoryList[input - 1] = newCategory
                saveCategoriesToFile(categoryList)
                break
            } catch (e: InputMismatchException) {
                sc.nextLine()
                println("잘못 입력하였습니다.")
            } catch (e: Exception) {
                println("잘못 입력했습니다.")
            }

        }
    }

    //카테고리 리스트 프린트하기
    private fun printCategoryList() {
        println()
        if (categoryList.isEmpty()) {
            println("등록된 카테고리가 없습니다.")
        }
        for (i in 0 until categoryList.size) {
            println("${i + 1} : ${categoryList[i]}")
        }
    }

    fun run() {
        getNumberInput()
    }

    fun selectCategory() {
        while (true) {
            printCategoryList()
            println()
            print("선택할 카테고리 번호를 입력해주세요 (0. 이전) : ")
            try {
                val input = sc.nextInt()

                if (input == 0) break

                memoManagerList[input - 1].run()
            } catch (e: InputMismatchException) {
                sc.nextLine()
                println("잘못된 입력입니다.")
            } catch (e: Exception) {
                println("잘못된 입력입니다.")
            }
        }


    }

    fun printAllCategory() {
        println()

        if (categoryList.isEmpty()) {
            println("등록된 카테고리가 없습니다")
        } else {
            for (i in 0 until categoryList.size) {
                println("---------------------------------------------")
                println(i)
                println("---------------------------------------------")
                val memoList = memoManagerList[i]

                if (memoList.memoList.isEmpty()) {
                    println()
                    println("등록된 메모가 없습니다")
                } else {
                    for (j in memoList.memoList) {
                        j.printMemo()
                    }
                }
            }
        }


    }

}