fun main() {
    val t1 = TestClass1()
    println("t1 : $t1")

    val t2 = TestClass2()
    val t3 = TestClass2(100, 200)

    println("t2.v1 : ${t2.v1}, t2.v2 : ${t2.v2}")
    println("t3.v1 : ${t3.v1}, v3.v2 : ${t3.v2}")

    val t4 = TestClass3(100, 200)
    println("t4.a1 : ${t4.a1}")
    println("t4.a2 : ${t4.a2}")

    var t5 = TestClass4(1, 1)
    t5.testMethod4()

    var t6 = TestClass4()
    t6.testMethod4()

    var t7 = TestClass4(1)
    t7.testMethod4()
}

class TestClass1 {
    // init 코드 블럭
    // 클래스를 통해 객체가 생성되면 자동으로 동작하는 코드를 작성할 수 있다.
    // 매개 변수를 정의할 수 없기 때문에 생성자는 아니다.
    init {
        println("TestClass1의 init 코드 블럭")
        println("객체가 생성되는 자동으로 동작하는 부분입니다")
    }
}

//헷갈리면 그냥 이대로 만들자!!
class TestClass2 {
    var v1 = 0
    var v2 = 0

    // 매개변수가 없는 생성자
    constructor() {
        println("매개 변수가 없는 생성자")
    }

    constructor(v1: Int, v2: Int) {
        print("매개 변수가 두 개인 생성자")
        this.v1 = v1
        this.v2 = v2
    }

    // init 블럭의 코드는 Java파일로 변환될 때
    // 모든 생성자의 가장 위에 코드가 삽입된다.
    // 따라서 init 블럭의 코드가 먼저 수행되고
    // 선택된 생성자가 수행된다. -> 생성자는 아님!!
    init {
        println("init 코드 블럭 입니다")
    }
}


// 만약 생성자의 역할이 매개변수로 들어오는 값을 맴버 변수에 담는 것만 한다면....
//class TestClass3{
//
//    var a1 = 0
//    var a2 = 0
//
//    constructor(a1:Int, a2:Int){
//        this.a1 = a1
//        this.a2 = a2
//    }
//}


// 아래의 생성자 표기 문법의 위의 생성자 작성과 동일하게 된다.
// class TestClass3 constructor(var a1:Int, var a2:Int)
// constructor 생략 가능하다
//얘가 제일 중요한 생성자
class TestClass3(var a1: Int, var a2: Int)

//멤버도 같이 있다면
//생성자에 있는 변수도 멤버변수! but 생성자에는 이 둘만 쓰인단 말!
class TestClass4(var a1: Int, var a2: Int) {
    var a3 = 0

    init {
        println("init 블럭 코드 입니다.")
    }

    //추가적인 생성자 정의할 때는
    //클래스 이름 옆에 정의한 생성자를 반드시!! 호출해야한다
    constructor() : this(100, 200)

    constructor(a1: Int) : this(a1, 200) {
        println("매개변수가 있는 생성자 호출")
    }

    fun testMethod4() {
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
    }
}