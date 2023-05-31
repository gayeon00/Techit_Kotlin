import java.io.*
import java.util.*

class LoginManager {
    //로그인 여부 판별, 로그인 작업 수행
    val sc = Scanner(System.`in`)
    val br = BufferedReader(InputStreamReader(System.`in`))
    var password: String = ""
    val file = File("password.txt")

    init {
        if(file.exists()){
            loadPassword()
        } else {
            file.createNewFile()
        }

    }

    fun run() {
        if (password.isEmpty()) { //비밀번호가 있을 경우
            setPassword()
        } else {
            login()
        }
    }

    private fun login() {
        while (true) {
            println()
            print("로그인 하시려면 비밀번호를 입력해주세요 : ")
            val inputPassword = br.readLine()

            //비밀번호가 맞다면
            if (inputPassword == password) {
                break
            } else {
                println("비밀번호가 틀립니다.")
            }
        }

    }

    private fun setPassword() {
        while (true) {
            println()
            print("설정할 비밀번호를 입력해주세요 : ")
            val inputPassword = br.readLine()
            print("한번 더 입력해주세요 : ")
            val inputPassword2 = br.readLine()

            if (inputPassword == inputPassword2) {
                password = inputPassword
                val fos = FileOutputStream("password.txt")
                val dos = DataOutputStream(fos)

                dos.writeUTF(password)
                dos.close()

                break
            } else {
                println("다시 입력해주세요")
            }
        }
    }

    private fun loadPassword() {
        try {
            val fis = FileInputStream("password.txt")
            val dis = DataInputStream(fis)

            password = dis.readUTF()

            dis.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}