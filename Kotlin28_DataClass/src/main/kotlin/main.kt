fun main() {
    //Data Class
    //객체의 멤버를 보다 쉽게 관리할 수 있는 기능이 추가됨
    //abstract, open, sealed, inner클래스로 정의할 수 없다
    //순수하게 데이터만 관리하는 클래스

    // 일반 클래스로 객체를 생성한다.
    val obj1 = TestClass1(100, 200)
    val obj2 = TestClass2(100, 200)

    // 멤버 사용
    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    obj1.testMethod1()
    obj2.testMethod2()

    //부생성자를 이용한 객체 생성
    var obj3 = TestClass1(100, 200, 300)
    var obj4 = TestClass2(100, 200, 300)

    println("obj3.a1 : ${obj3.a1}")
    println("obj3.a2 : ${obj3.a2}")
    println("obj3.a3 : ${obj3.a3}")

    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
    println("obj4.a3 : ${obj4.a3}")

    val obj5 = TestClass1(100, 200, 300)
    val obj6 = TestClass1(100, 200, 300)

    //일반 클래스는 다른 객체로 인식
    if (obj5 == obj6) {
        println("obj5와 obj6은 같은 객체 입니다")
    } else {
        println("obj5와 obj6은 다른 객체 입니다")
    }

    val obj7 = TestClass2(100, 200, 300)
    val obj8 = TestClass2(100, 200, 300)

    //데이터 클래스는 내용물이 같으면 같은 객체로 인식
    //내부적으로 equals메서드가 주 생성자를 통해 정의된 멤버 변수 값을 비교하도록 구현돼있음
    if (obj7 == obj8) {
        println("obj7와 obj8은 같은 객체 입니다")
    } else {
        println("obj7와 obj8은 다른 객체 입니다")
    }

    //copy : 객체를 복제하여 새로운 객체를 만든다. (data class에 있는 메서드)
    val obj9 = obj7.copy()
    println("obj7.a1 : ${obj7.a1}")
    println("obj9.a1 : ${obj9.a1}")

    //obj9.a1의 값을 변경한다.
    obj9.a1 = 1000
    println("obj7.a1 : ${obj7.a1}")
    println("obj9.a1 : ${obj9.a1}")
    //출력
    //    obj7.a1 : 100
    //    obj9.a1 : 1000
    //=> copy를 안하면 obj9, obj7 둘 다 같은 객체를 가르킴
    //=> copy를 하면 내용을 복제한 새로운 객체가 만들어짐
    //=> 그래서 하나를 조작하더라도 나머지 하나 안바뀜
    //=> 독립적!!

    println("-------------------------------------------")

    // data class를 통해 만든 객체는 주 생성자에 정의한 멤버 변수를
    // componentN 메서드로 값을 받아올 수 있다.
    val num1 = obj7.component1()
    val num2 = obj7.component2()

    println("num1 : $num1")
    println("num2 : $num2")

    println("-------------------------------------------")

    //객체 분해 : 주 생성자를 통해 정의된 멤버 변수의 값을 하나씩 추출하여
    // 좌측에 작성한 변수들에 순서대로 담아준다.
    // 이 때, 내부적으로 componentN 메서드들을 호출하여 값을 전달한다.
    val (num10, num11) = obj7
    println("num10 : $num10")
    println("num11 : $num11")

}

//일반 클래스
//주 생성자(클래스 이름 옆에 작성하는 생성자)
class TestClass1(var a1: Int, var a2: Int) {
    var a3: Int = 0

    init {
        println("TestClass1의 init")
    }

    //부생성자 (주 생성자 없이 부 생성자만 있을 수 있음)
    constructor(a1: Int, a2: Int, a3: Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod1() {
        println("TestClass1의 testMethod1입니다")
    }
}

//DataClass
//반드시 주 생성자(클래스 이름 옆에 작성하는 생성자)를 작성해줘야 한다.
//주생성자에 있는 변수들이 멤버변수 -> 데이터 개체의 멤버들이 꼭 있도록 강제하는 것
//data class TestClass2 {}
data class TestClass2(var a1: Int, var a2: Int) {
    var a3: Int = 0

    init {
        println("TestClass2의 init")
    }

    //부생성자는 잘 안만듦 -> 주 생성자에 관리할 변수를 다 넣음
    constructor(a1: Int, a2: Int, a3: Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod2() {
        println("TestClass2의 testMethod2입니다")
    }
}
