import java.io.*
import java.util.*

class LoginManager {
    private var password = 0
    private val sc = Scanner(System.`in`)
    private val file = File("password.txt")

    init {
        if (file.exists()) {
            loadPasswordFromFile()
        } else {
            file.createNewFile()
        }

    }

    fun running() {
        if (password == 0) {
            setPassword()
        } else {
            login()
        }
    }

    private fun savePasswordToFile() {
        try {
            val fos = FileOutputStream(file)
            val dos = DataOutputStream(fos)

            dos.writeInt(password)
        } catch (e: Exception) {
            println("에러 : 패스워드 저장 에러")
        }
    }

    private fun loadPasswordFromFile() {
        try {
            val fis = FileInputStream(file)
            val dis = DataInputStream(fis)

            password = dis.readInt()
        } catch (e: Exception) {
            println("에러 : password 파일 비어있음")
        }
    }

    fun setPassword() {
        while (true) {
            println()
            print("설정할 비밀번호를 입력하세요 : ")
            val tmp = sc.nextInt()
            print("한번 더 입력해주세요 : ")
            val tmp2 = sc.nextInt()

            if (tmp == tmp2) {
                password = tmp
                savePasswordToFile()
                break
            }

            println("다시 입력해주세요")
        }
    }

    fun login() {
        while (true) {
            println()
            print("로그인 하시려면 비밀번호를 입력하세요 : ")
            val tmp = sc.nextInt()

            if (password == tmp) {
                break
            }

            println("비밀번호가 맞지 않습니다.")
        }
    }
}