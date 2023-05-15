fun main() {
    val s1 = SubClass1()
    println("s1.subMember1 : ${s1.subMember1}")
    s1.subMethod1()

    println("s1.superMember1 : ${s1.superMember1}")
    s1.superMethod1()
}

//코틀린 클래스는 기본 final
//부모 클래스처럼 동작하게 하려면 open으로 열어줘야 함!
open class SuperClass {
    var superMember1 = 100

    constructor() {
        println("SuperClass의 기본 생성자")
    }

    fun superMethod1() {
        println("SuperClass1의 메서드 입니다")
    }
}

//()안의 값은 부모 생성자에게 넘기는 값
class SubClass1 : SuperClass() {
    val subMember1 = 200

    fun subMethod1() {
        println("SubClass1의 메서드 입니다")
    }
}

// Kotlin은 자바 코드로 변경되어 자바 코드가 실행된다.
// 따라서 자바와 동일하게 클래스의 객체를 생성하면 부모 클래스의 기본 생성자(매개변수가 없는)
// 가 자동으로 호출된다.
// 만약 부모 클래스에 기본생성자가 없고 매개변수 생성자가 있다면 자식 클래스에서 이를 명시적으로 호출해줘야 한다.
open class SuperClass2(var a1: Int) {

}

class SubClass2 : SuperClass2 {
    //부모의 생성자를 호출
    constructor() : super(100) {

    }
}

//따로 생성자에 작성할 코드가 없고 값만 넘기면 된다면 일케 작성
//100을 넘겨서 부모 생성자를 호출해준다는 뜻!!!!
class SubClass3 : SuperClass2(100){

}