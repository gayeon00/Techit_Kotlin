fun main() {
    // 추상 클래스
    // 추상 메서드를 가지고 있는 클래스
    // 추상 메서드
    // 구현되지 않은 메서드
    // 추상 클래스는 완벽한 클래스가 아니기 때문에 객체를 생성할 수 없다.
    // 추상 클래스를 상속받은 클래스를 만들고 추상 메서드를 오버라이딩하여
    // 사용한다.
    // 추상 클래스와 메서드는 abstract 키워드를 사용하며 상속이 가능해야 하기 때문에
    // 클래스에는 open 키워드를 사용하고 오버라이딩이 가능해야 하기 때문에
    // 추상 메서드에는 open 키워드를 사용해야 한다. => 안해도 되는디?
    // 메서드 오버라이딩에 대한 강제성을 주기 위해 사용

    val t2 = TestClass2()
    t2.testMethod()

    val t3:TestClass1 = TestClass2()
    t3.testMethod()
}

//추상 클래스
abstract class TestClass1{
    //추상 메소ㅓ드
    abstract fun testMethod()
}

//추상 클래스를 상속 받은 클래스
class TestClass2 : TestClass1() {
    override fun testMethod() {
        println("TestClass2의 testmethod")
    }
}