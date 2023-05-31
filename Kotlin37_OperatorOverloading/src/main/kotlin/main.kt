fun main(){

    val num1 = 100
    val num2 = 200

    // kotlin 에서 연산자를 사용하면 그 연산자에 해당하는
    // 메서드가 호출되고 그 메서드가 반환하는 값이 최종 결과가 된다.

    val a1 = num1 + num2
    println("a1 : $a1")

    val a2 = num1.plus(num2)
    println("a2 : $a2")

    val obj1 = TestClass(100, 200)
    val obj2 = TestClass(10, 20)

    val obj3 = obj1 + obj2
    println("obj3.a1 : ${obj3.a1}")
    println("obj3.a2 : ${obj3.a2}")

    val obj4 = obj1 - obj2
    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
}

class TestClass(var a1:Int, var a2:Int){

    // 더하기 연산자를 사용하면 호출되는 메서드 구현
    // 연산자를 기준으로 좌측의 객체를 통해 메서드가 호출되고
    // 우측의 객체가 매개변수로 들어온다.
    operator fun plus(target:TestClass) : TestClass{
        var r1 = this.a1 + target.a1
        var r2 = this.a2 + target.a2

        val result = TestClass(r1, r2)
        return result
    }

    operator fun minus(target: TestClass) : TestClass{
        var r1 = this.a1 - target.a1
        var r2 = this.a2 - target.a2

        val result = TestClass(r1, r2)
        return result
    }

}
