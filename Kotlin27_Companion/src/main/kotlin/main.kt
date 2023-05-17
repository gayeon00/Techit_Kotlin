fun main() {
    // companion
    // Java 에서 static과 동일하다.
    // 클래스내에 companion 멤버로 정의된 요소들은 객체 생성 없이 사용이 가능하며
    // 클래스 이름을 통해 접근한다.
    // companion 변수의 경우 딱 하나만 생성되어 사용할 수 있다.

    // 일반 멤버 변수나 메서드를 반드시 객체를 생성해야 사용할 수 있다.
    val t1 = TestClass1()
    println("t1.a1 : ${t1.a1}")
    t1.testFun1()

    //companion 멤버는 객체 생성 없이 클래스 이름으로 바로 접근 가능
    //변수의 경우 프로그램 전체에서 딱 하나만 사용하는 값을 저장할 때 사용한다.
    println("TestClass1.a2 : ${TestClass1.a2}")
    TestClass1.testFun2()

    //자바 파일에 정의된 static 멤버 사용
    println("JavaMain.javaA1 : ${JavaMain.JavaA1}")
    JavaMain.javaMethod1()
}

class TestClass1 {

    // companion 멤버
    //companion object {
    //아래 적어야 함
    //변수, 메서드 다 올 수 있음
    //클래스가 메모리에 올라갈 때 기억장소가 마련됨
    companion object{
        var a2 = 200
        // @JvmStatic : companion 멤버를 자바에서 사용할 수 있게 해주는 어노테이션 -> 클래스의 일종
        // 붙는 변수를 해당 클래스로 바꿔서 처리해줌!
        // 주석이랑은 다름! 주석은 그냥 건너뛰는 부분
        @JvmStatic var kotlinA3 = 300

        @JvmStatic fun kotlinMethod3() {
            println("kotlinMethod3")
        }

        fun testFun2(){
            println("testFun2")
            println("a2 : $a2")
            // companion object 입장에서 봤을 때
            // 클래스를 가지고 객체를 생성했다는 것을 100% 보장받을 수 없기 때문에
            // 일반 멤버의 접근이 불가능하다.
            // testFun1()
            // println("a1 : $a1")

        }
    }

    // 일반 멤버 변수
    var a1 = 100

    // 일반 메서드
    fun testFun1() {
        println("testfun1")
        println("a1 : $a1")
        // 객체 입장에서는 companion 맴버가 메모리에 올라가 있다는 것을
        // 보장받을 수 있으므로 사용이 가능하다.
        testFun2()
        println("a2 : $a2")
    }



}