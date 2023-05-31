import java.io.*
import java.util.*

class CategoryManager {
    private val categoryList = mutableListOf<Category>()
    var option: Int = 0
    private val file = File("categoryList.txt")
    private val sc = Scanner(System.`in`)
    private val br = BufferedReader(InputStreamReader(System.`in`))

    init {
        if (file.exists()) {
            loadCategoryListFromFile()
        } else {
            file.createNewFile()
        }
    }

    private fun loadCategoryListFromFile() {
        try {
            val fis = FileInputStream(file)
            val ois = ObjectInputStream(fis)

            while (true) {
                try {
                    categoryList.add(ois.readObject() as Category)
                } catch (e: EOFException) {
                    break
                }
            }

        } catch (e: Exception) {
//            println("에러 : categoryList 파일 비어있음")
        }
    }

    private fun saveCategoryListToFile() {
        try {
            val fos = FileOutputStream(file)
            val oos = ObjectOutputStream(fos)

            for (i in categoryList) {
                oos.writeObject(i)
            }
        } catch (e: Exception) {
            println("에러 : categoryList 저장 에러")
        }
    }


    fun running() {
        do {
            printCategoryList()
            showCategoryMenu()
            option = selectOption()

            when (option) {
                1 -> {
                    registerCategory()
                }
                2 -> {
                    deleteCategory()
                }
                3 -> {
                    editCategory()
                }
                4 -> {
                    //이전: 비우기
                }
                else -> println("유효하지 않은 메뉴입니다. 다시 선택해주세요.")
            }

        } while (option != 4)
    }

    private fun registerCategory() {
        println()
        print("등록할 카테고리 이름을 입력해주세요 : ")
        val categoryName = br.readLine()
        categoryList.add(Category(categoryName))
        saveCategoryListToFile()
    }

    private fun deleteCategory() {
        while (true) {
            println()
            print("삭제할 카테고리 번호를 입력해주세요 : ")
            val categoryNumber = sc.nextInt()
            if (categoryNumber in 1..categoryList.size) {
                categoryList.removeAt(categoryNumber - 1)
                saveCategoryListToFile()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

    private fun editCategory() {
        while (true) {
            println()
            print("수정할 카테고리 번호를 입력해주세요 : ")
            val categoryNumber = sc.nextInt()
            if (categoryNumber in 1..categoryList.size) {
                print("${categoryList[categoryNumber - 1].name} -> ")
                categoryList[categoryNumber - 1].name = br.readLine()
                saveCategoryListToFile()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

    private fun selectOption(): Int {
        return sc.nextInt()
    }

    private fun showCategoryMenu() {
        println()
        println("1. 카테고리 등록")
        println("2. 카테고리 삭제")
        println("3. 카테고리 수정")
        println("4. 이전")
        print("카테고리 관리 메뉴 선택 : ")
    }

    private fun printCategoryList() {
        println()
        if (categoryList.isEmpty()) {
            println("등록된 카테고리가 없습니다.")
        } else {
            for (i in 0 until categoryList.size) {
                println("${i + 1} : ${categoryList[i].name}")
            }
        }
    }

    fun selectCategory() {
        while (true) {
            printCategoryList()
            print("선택할 카테고리 번호를 입력해주세요 (0. 이전) : ")
            val num = sc.nextInt()

            if (num == 0) break

            if (num in 1..categoryList.size) {
                MemoManager(categoryList[num-1]).running()
                break
            }

            println("잘못 입력했습니다.")
        }
    }

}
