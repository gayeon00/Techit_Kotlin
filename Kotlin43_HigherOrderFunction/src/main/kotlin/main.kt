fun main() {
    // 고차 함수
    // 함수를 매개변수로 받거나 반환 타입이 함수인 함수

    // 함수를 호출할 때 전달할 익명 함수
    val t1 = fun(x1: Int, x2: Int): Int {
        return x1 + x2
    }

    val t100 = { w1: Int, w2: Int -> w1 + w2 }
    // 고차함수 호출
    testFunc1(100, 200, t1)

    // 익명함수를 직접 작성해 준다.
    testFunc1(100, 200, fun(x1: Int, x2: Int): Int {
        return x1 - x2
    })

    // 고차함수에 람다 함수를 전달하는 것도 가능하다.
    // 람다함수는 익명함수의 일종!
    val lambda1 = { x1: Int, x2: Int -> x1 * x2 }
    testFunc1(100, 200, lambda1)

    // 람다식을 직접 작성해 준다.
    //둘다 똑같은 거!
    testFunc1(100, 200, { x1: Int, x2: Int -> x1 / x2 })
    testFunc1(100, 200) { x1: Int, x2: Int -> x1 / x2 }

    // 함수를 반환하는 함수 사용
    val t2 = testFunc2(100)
    val r2 = t2(200)
    println("r2 : $r2")

    // 람다식을 반환하는 함수 사용
    val t3 = testFun3(100)
    val r3 = t3(200)
    println("r3 : $r3")

    // 함수를 받는 매개변수가 마지막에 있지 않은 함수 호출
    // 1. 익명함수를 변수에 담아 전달한다.
    val f4 = fun(x1: Int, x2: Int): Int {
        println("x1 : $x1")
        println("x2 : $x2")
        return x1 + x2
    }
    testFunc4(100, f4, 200)

    // 2. 익명함수를 직접 작성한다.
    testFunc4(100, fun(x1: Int, x2: Int): Int {
        println("x1 : $x1")
        println("x2 : $x2")
        return x1 + x2
    }, 200)

    // 3. 람다를 전달한다.
    val lambda4 = { x1: Int, x2: Int ->
        println("x1 : $x1")
        println("x2 : $x2")
        x1 + x2
    }
    testFunc4(100, lambda4, 200)

    // 4. 람다를 직접 작성한다.
    testFunc4(100, { x1: Int, x2: Int ->
        println("x1 : $x1")
        println("x2 : $x2")
        x1 + x2
    }, 200)

    // 익명함수나 람다식을 받는 매개변수가 마지막에 있는 함수 호출
    // 위의 1 ~ 4 모두 사용가능하다.
    // { } 로 작성한 람다식이 제일 마지막 매개변수로 들어간다.
    testFunc5(100, 200) { x1: Int, x2: Int ->
        println("x1 : $x1")
        println("x2 : $x2")
        x1 + x2
    }

    val ic1 = InterClass1()
    testFunc6(ic1)

    val ic2 = InterClass2()
    testFunc6(ic2)

    //즉석으로 익명 클래스(익명 객체)를 넣어줌
    //이름은 필수로 object로 해야함!
    testFunc6(object : Inter1 {
        override fun interMethod() {
            TODO("Not yet implemented")
        }

    })

    // 고차함수를 이용해 다른곳에서 호출하는 메서드를 오버라이딩하는
    // 작업을 대신할 수 있다.
    // 아래의 코드는 testFunc7을 호출하면서 람다식을 전달하는 코드이다
    testFunc7 {
        println("testFun7 1번")
    }

    testFunc7 {
        println("testFun7 2번")
    }


    testFunc8 { a1: Int ->
        println(a1)
    }
    // 매개변수 하나인 함수나 람다식을 받는 고차함수를 사용할 때
    // 전달할 함수나 람다식에 매개변수를 정의하지 않고 it 을 사용하면
    // 매개변수로 전달되는 값을 사용할 수 있다.
    testFunc8 {
        println(it)
    }
}

// 매개변수로 함수를 받는 함수
fun testFunc1(a1: Int, a2: Int, m1: (Int, Int) -> Int) {
    val r1 = m1(a1, a2)
    println("testFun1 r1 : $r1")
}

// 함수를 반환하는 함수
fun testFunc2(a1: Int): (Int) -> Int {

    // 반환하는 함수 내부에서 지역변수나 매개변수를 사용할 수 있다.
    return fun(x2: Int): Int {
        return a1 + x2
    }
}

// 람다식을 반환하는 함수
fun testFun3(a1: Int): (Int) -> Int {
    return { x2: Int -> a1 - x2 }
}

// 함수나 람다식을 받는 매개변수를 제일 마지막에 작성하지 않은 함수
fun testFunc4(a1: Int, m1: (Int, Int) -> Int, a2: Int) {
    val r4 = m1(a1, a2)
    println("r4 : $r4")
}

// 함수나 람다식을 받는 매개변수를 제일 마지막에 작성한 함수
fun testFunc5(a1: Int, a2: Int, m1: (Int, Int) -> Int) {
    val r5 = m1(a1, a2)
    println("r5 : $r5")
}

interface Inter1 {
    fun interMethod()
}

fun testFunc6(inter1: Inter1) {
    inter1.interMethod()
}

class InterClass1 : Inter1 {
    override fun interMethod() {
        println("InterClass1의 interMethod")
    }
}

class InterClass2 : Inter1 {
    override fun interMethod() {
        println("InterClass2의 interMethod")
    }
}

fun testFunc7(m1: () -> Unit) {
    m1()
}

// 매개변수 하나를 가지고 있는 함수나 람다식을 받는 함수
fun testFunc8(m1: (Int) -> Unit) {
    m1(100)
}




