fun main() {

    //제네릭이 정의된 클래스를 가지고 객체 생성
    //구조가 같은데 타입만 다를 경우 제네릭 적극 활용!!
    val t1 = TestClass1<Int>()
    t1.testMethod1(100)

    val t2 = TestClass1<String>()
    t2.testMethod1("안녕")

    val t3 = TestClass2<Int>(100)
    t3.testMethod2(200)

    val t4 = TestClass2<String>("하염")
    t4.testMethod2("안뇽")

    val t5 = TestClass3<Int, Double, Boolean, String>(100, 11.11)
    t5.testMethod3(true, "문자열5")

    val t6 = TestClass3<Double, String, Boolean, Int>(22.22, "문자열6")
    t6.testMethod3(false, 200)

    /*불변성 : 객체를 생성할 때 설정한 제네릭과 같은 변수를 담을 수 있다*/
    //클래스 간의 관계에 상관없이 제네릭이 설정한 클래스 타입이 다르면 오류가 발생
    val t7: TestClass5<SubClass1> = TestClass5<SubClass1>()
//    val t8: TestClass5<SuperClass1> = TestClass5<SubClass1>()
//    val t9: TestClass5<SubClass2> = TestClass5<SubClass1>()

    /* 공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭의 부모 클래스인 경우
     에도 변수에 담을 수 있다.*/
    val t10: TestClass6<SubClass1> = TestClass6<SubClass1>()
    //자식을 부모에 담는 꼴이라고 생각하자!
    val t11: TestClass6<SuperClass1> = TestClass6<SubClass1>()
    //부모를 자식에 담는 꼴
//    val t12 :TestClass6<SubClass2> = TestClass6<SubClass1>()

    /*반공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭의 자식 클래스인 경우에도 변수에 담을 수 있음*/
    //딱 공변성의 반대!!
    val t13: TestClass7<SubClass1> = TestClass7<SubClass1>()
    //얘는 안됨
//    val t14: TestClass7<SuperClass1> = TestClass7<SubClass1>()
    //얘는 되고
    val t15: TestClass7<SubClass2> = TestClass7<SubClass1>()
}

//<제네릭> : 보통 대문자 하나
// 이 알파벳을 아직 결정되지 않은 "타입"을 의미
// 어떠한 타입인지 결정되지 않았지만 이 타입의 변수들을 정의하여 클래스를 작성하고
// 향후, 객체를 생성할 때 타입을 결정할 수 있다.
class TestClass1<T> {
    fun testMethod1(a1: T) {
        println("a1 : $a1")
    }
}

class TestClass2<T>(var a1: T) {
    fun testMethod2(a2: T) {
        println("a1 : $a1")
        println("a2 : $a2")
    }
}

class TestClass3<A, B, C, D>(var a1: A, var a2: B) {

    fun testMethod3(a3: C, a4: D) {
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        println("a4 : $a4")
    }
}

open class SuperClass1
open class SubClass1 : SuperClass1()
class SubClass2 : SubClass1()

// 불변성 (제네릭에 키워드를 붙히지 않는다)
class TestClass5<A>()

// 공변성
class TestClass6<out A>()

//반공변성
class TestClass7<in A>()