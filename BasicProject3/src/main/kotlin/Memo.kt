import java.io.Serializable

data class Memo(var title: String, var contents: String): Serializable {
    override fun toString(): String {
        return "Memo(title = $title, contents = $contents)"
    }

    fun printMemo() {
        println()
        println("제목 : $title")
        println("내용 : $contents")
    }
}