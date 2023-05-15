//lateinit: var 프로퍼티에만 -> 나중에 값을 넣어주는 것
//lazy: val 프로퍼티에만 -> 처리를 통해 값을 넣어주는 작업(나중에 넣는게 아님!)
fun main() {
    val t1 = TestClass1()
    t1.testMethod1()

    println("----------------------")

    //a4프로퍼티에 값 저장
    t1.a4 = "문자열임당"
    t1.testMethod1()
}

class TestClass1 {
    //프로퍼티 정의
    //Kotlin은 프로퍼티를 정의할 때 반드시 값을 넣어줘야 함
    var a1: Int = 100
    var a2 = 100
    var a3: Int

    /*lateinit*/
    // var 프로퍼티에서만 사용가능하며, 프로퍼티를 정의할 때 값을 저장하지 않아도 된다
    // 기본 자료형(Int, Double 등)에서는 사용할 수 없다. -> 자바로 바꿀 때, int, Integer 둘 중 뭐일지 모름
    // ==> 자바에서 기본 자료형(int, double)엔 null을 넣을 수 없기 때문!!
    lateinit var a4: String

    /*lazy*/
    // val 프로퍼티에서 사용하는 키워드
    // val 프로퍼티에 저장할 값을 어떠한 처리를 통해 구해야 한다면 lazy를 사용
    // 나중에 저장한다는 뜻이 아님!!
    // lazy 코드 블록의 제일 마지막에 작성한 값이나 프로퍼티의 값, 수식의 값을 저장함
    val a5: Int by lazy {
        val temp = 1 + 2 + 3 + 4 + 5
        temp
    }

    //만약 init 블럭에서 프로퍼티에 값을 저장한다면 프로퍼티를 정의할 때
    //값을 저장하지 않아도 된다
    init {
        a3 = 300
    }

    fun testMethod1() {
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        //lateinit 프로퍼티는 사용 전 반드시 값을 저장했는지 확인해야 함
        //:: -> reflection. 객체의 성격을 가져오는 놈
        if (::a4.isInitialized) {
            println("a4 : $a4")
        }
        println("a5 : $a5")


    }
}