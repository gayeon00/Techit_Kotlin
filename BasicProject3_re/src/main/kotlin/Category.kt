import java.io.Serializable

data class Category(var name: String, val memoList: MutableList<Memo> = mutableListOf()) : Serializable {

    //카테고리 안에 여러개의 메모가 있는데 어카지?
    data class Memo(var title: String, var contents: String) : Serializable {
        fun printMemo() {
            println("제목 : $title")
            println("내용 : $contents")
        }
    }


}