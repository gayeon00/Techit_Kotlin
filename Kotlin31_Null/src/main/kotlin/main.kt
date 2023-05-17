
//null처리 -> if로 거르는 것 을 추천!
fun main() {

    //null을 허용하는 변수 선언
    var a1: String? = null
    //null을 허용하지 않는 변수 선언
//    var a2: String = null

    testFun1("안녕하세용")
//    testFun1(null)

    testFun2(null) //기본문자열 들어감
    testFun2("안녕안녕용")

    testFun3(null) //기본문자열 들어감
    testFun3("안녕3")

    val t100 = TestClass1(100,"문자열1")
    testFunction1(t100)
//    testFunction1(null)

    testFunction200(t100)

    println("---------------------------------------")

    testFunction200(null)

    testFuntion300(t100)

    println("--------------------------------")

    testFuntion300(null)
}

fun testFun1(str: String?) {
    //!!연산자
    //null을 허용하는 타입의 변수값을 null을 허용하지 않는 타입으로 변환하여 담음
    //해당변수가 null이 아니라는 것을 보장해주겠다는 연산자라
    //null이라면 NullPointerException 발생
    val value1: String = str!!
    println("value1 : $value1")
}

fun testFun2(str1: String?) {
    //str1이 null이면 "기본문자열" 이 들어감
    val value2: String = str1 ?: "기본문자열"
    println("value2 : $value2")
}

fun testFun3(str1: String?) {
    //만약 변수의 값이 null인 경우 코드가 동작하지 않도록 처리해주면
    //null safe를 확보할 수 있음
    //이때, null을 허용하는 변수를 null을 허용하지 않는 변수처럼 자유롭게처리할 수 잇음
    if (str1 != null) {
        val value3: String = str1
        println("value3 : $value3")
    }
}

class TestClass1(var str1: Int, var str2: String) {
    //lateinit은 non-null에만 사용 가능
    //lateinit var str1: String?

    fun testMethod1() {
        println("TestClass1의 testMethod1")
    }
}

fun testFunction1(t1: TestClass1?) {
    // ? 변수를 통해 객체의 멤버에 접근한다.
    //null 안정성을 확보하지 않고 멤버에 접근하겠다면 !!를 붙여준다.
    //권장X

    // !! 연산자는 null을 허용하는 변수에 담긴 값을 추출하여 null을 허용하지 않는
    // 타입으로 변환하는 연산자이다. 이에 null 값이 들어있으면 오류가 발생한다.
    println("t1.str1 : ${t1!!.str1}")
    println("t1.str2 : ${t1!!.str2}")
    t1!!.testMethod1()
}

fun testFunction200(t1:TestClass1?){
    // ? 연산자
    // 참조변수?.멤버변수 : 참조변수에 null값 들어 있다면 null이 반환된다.
    // 참조변수?.멤버 메서드 : 참조변수에 null값 들어 있다면 메서드를 호출하지 않는다.
    println("t1.str1 : ${t1?.str1}")
    println("t1.str2 : ${t1?.str2}")
    t1?.testMethod1()
}

fun testFuntion300(t1:TestClass1?){
    // null이 저장되어 있는지 여부를 확인한다.
    // if 문 내부에서는 null을 아무런 연산자도 붙히지 않고 멤버 접근이 가능하다.
    if(t1 != null){
        println("t1.str1 : ${t1.str1}")
        println("t1.str2 : ${t1.str2}")
        t1.testMethod1()
    }
}