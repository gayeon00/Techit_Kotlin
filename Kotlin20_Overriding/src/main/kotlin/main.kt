fun main() {
    // 객체를 생성하여 자기 타입 변수에 담아준다
    val obj1 = SubClass1()
    // 자식 클래스 타입이므로 자기 것과 부모 것 모두 사용 가능하다.
    println("obj1.subA1 : ${obj1.subA1}")
    println("obj1.superA1 : ${obj1.superA1}")
    obj1.subMethod1()
    obj1.superMethod1()

    println("---------------------------")
    //객체를생성해서 부모클래스 타입에 넣어줌
    val obj2: SuperClass1 = SubClass1()
    //부모것만 사용 가능!!
//    println("obj1.subA1 : ${obj2.subA1}")
    println("obj1.superA1 : ${obj2.superA1}")
//    obj2.subMethod1()
    obj2.superMethod1()

    println("------------------------------")
    val obj3 = SubClass2()
    obj3.superMethod2()

    // 부모 클래스 타입 변수를 통해 Overriding한 메서드를 호출할 경우
    // 부모 클래스 타입에 담아도 부모의 것이 아닌 자식의 것이 호출된다.
    val obj4:SuperClass2 = SubClass2()
    obj4.superMethod2()

}

open class SuperClass1 {
    var superA1 = 100

    fun superMethod1() {
        println("SuperClass1의 superMethod1입니당")
    }
}

class SubClass1 : SuperClass1() {
    var subA1 = 200

    fun subMethod1() {
        println("SubClass1의 subMethod1입니당")
    }
}

open class SuperClass2 {
    var superA2 = 300

    //메서드도 클래스랑 마찬가지로 기본은 final임! -> 오버라이딩 가능하게 하려면 open키워드 필요
    open fun superMethod2() {
        println("SuperClass2의 superMethod2입니당")
    }
}

class SubClass2: SuperClass2() {
    //override하려면 별도의 override키워드 필요
    override fun superMethod2() {
        //부모의 메서드 호출
        super.superMethod2()
        println("SubClass2의 superMethod2입니당 오버라이딩 했슴당")
    }
}