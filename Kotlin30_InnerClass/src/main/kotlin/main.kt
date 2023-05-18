fun main() {
    // 외부 클래스의 객체를 생성한다.
    val obj1 = Outer1()
    //이를 통해 내부 클래스의 객체를 생성한다.
    val obj2 = obj1.Inner1()

    obj2.innerMethod()

    val t1 = TestClass1()
    t1.interMethod1()
    t1.interMethod2()

    // 만약 인터페이스를 구현하거나 클래스를 상속받은 클래스를 통해 객체를 하나만 생성한다면
    // 익명 중첩클래스를 사용해도 된다.
    val t2 = object : Inter1 {
        override fun interMethod1() {
            println("익명 중첩 클래스의 interMethod1")
        }

        override fun interMethod2() {
            println("익명 중첩 클래스의 interMethod2")
        }
    }
    t2.interMethod1()
    t2.interMethod2()

}

// 일반 중첩 클래스
// 내부에 있는 클래스의 객체 생성은 외부 클래스로 부터생성한 객체를 통해 생성 가능
// 내부에 클래스를 가지고 만든 객체는 외부 클래스를 통해 만든 객체가 있다는 것을 무조건 보장하기 때문에
// 내부 클래스가 외부 클래스에 접근하기 자유롭다.
class Outer1 {

    var outerV1 = 100

    fun outerMethod() {
        println("Outer1의 outerMethod 입니다")
    }

    inner class Inner1 {
        fun innerMethod() {
            println("outerV1 : $outerV1")
            outerMethod()
        }
    }
}

interface Inter1 {

    fun interMethod1()
    fun interMethod2()
}

class TestClass1 : Inter1 {
    override fun interMethod1() {
        println("TestClass1의 interMethod1")
    }

    override fun interMethod2() {
        println("TestClass1의 interMethod2")
    }

}