// Property 방식: 문법적으로 변수를 직접 사용하는 것처럼 보이지만
// 실제로는 setter/getter 메서드를 사용하는 방식을 의미한다
fun main() {
    val t1 = TestClass1(100, 200)

    //t1.a1이라고 해도 자바로 변환할 때 getter를 호출해서 값을 받아옴
    println("t1.a1 : ${t1.a1}")
    println("t1.a2 : ${t1.a2}")

    // a1 변수에 직접 접근하여 값을 저장하는 것이 아닌
    // setter 메서드를 호출하는 것을 사용한다.
    t1.a1 = 1000
    println("t1.a1 : ${t1.a1}")

    val t2 = TestClass2()
    t2.v1 = 100
    t2.v3 = 5
    println(t2.v1)
    println(t2.v2)
    println(t2.v3)
    println(t2.v4)

    t2.v3 = 100
    println("변경 후 : ${t2.v3}")
}

// 생성자의 매개변수로 선언된 변수들은 private 맴버로
// 정의된다.
// var 의 경우 setter와 getter가 모두 만들어지며
// val 의 경우 final 변수로 정의 되고 getter만 제공된다.
class TestClass1(var a1: Int, val a2: Int)

class TestClass2 {
    //클래스에 정의한 모든 변수는 내부적으로 private임
    //val 변수는 내부적으로 final임
    //변수만 정의하면 getter/setter(var), getter(val) 만들어짐
    var v1 = 0
    val v2 = 0

    //field : 해당 변수 자체(this랑 비슷한 개념)
    //들여쓰기는 그냥 해당 변수에 대한 getter/setter라는걸 보여주기 위해 하는거임!!
    //변수 바로 밑에 get/set을 쓰면 그 변수의 getter/setter임 -> 그냥 위치로 판단!
    //오버라이딩 개념이 아니라 우리가 정의하는 거임! -> 그럼 자바로 바꿀 때 기본적인 getter/setter가 아니라 우리가 만든걸로 만듦!
    var v3 = 0
        get() {
            println("getter호출")
            return field
        }
        set(value) {
            println("setter 호출")
            if(value in 1..10){
                field = value
            }
        }

    val v4 = 0
        get() {
            println("getter 호출 v4")
            return field
        }
}