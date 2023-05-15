import com.test.pkg1.InternalClass3
import com.test.pkg1.PublicClass3
import com.test.pkg1.SuperClass2
import com.test.pkg2.PublicClass4
import com.test.pkg2.SuperClass3

/*class*/
// private : 파일이 같은 경우에만 사용 가능
// public : 패키지, 모듈이 달라도 사용 가능
// internal : 패키지, 모듈이 다르면 사용이 불가능

/*변수, 메서드*/
// private: 모든 경우에서 사용이불가능
// public : 모든 경우에서 사용 가능
// protected :  상속관계에서만 사용 가능. 패키지, 모듈이 달라도 사용 가능
//internal : 모듈이다르면 사용 불가능

//생략시 public으로 설정되고, internal과 같은 모듈이라면 public과 동일하다

//프로그램 자체가 하나의 모듈이다!!
fun main() {

    //같은 클래스에 있는 클래스들들은 아무 제약엇ㅂ이 사용 가능
    val a1 = PrivateClass1()
    val a2 = PublicClass1()
    val a3 = InternalClass1()

    println("a1 : $a1")
    println("a2 : $a2")
    println("a3 : $a3")

    // 같은 패키지 다른 파일
    // private 클래스 사용 불가
    // val b1 = PrivateClass2()
    val b2 = PublicClass2()
    val b3 = InterClass2()

    println("b2 : $b2")
    println("b3 : $b3")

    // 다른 패키지의 다른 파일
    // Private 사용 불가
    // val c1 = PrivateClass3()
    val c2 = PublicClass3()
    val c3 = InternalClass3()
    println("c2 : $c2")
    println("c3 : $c3")

    //모ㄷ듈이 다를 경우 Internal 요소는 사용 불가능
//    val d1 = PrivateClass4()
    //moduleDependencies 추가해줘야 com.test.pkg2 추가 없이 사용 가능!!
    val d2 = PublicClass4()
//    val d3 = InternalClass4()
    print("d2 : $d2")

    //같은 파일, 같은 패키지
    //private, protected 요소 사용 불가
    val super1 = SuperClass1()
//    println(super1.a1)
    println(super1.a2)
//    println(super1.a3)
    println(super1.a4)

    //같은 모듈, 다른 패키지, 객체를 생성해서 사용하는 경우
    //private, protected 접근 불가
    val super2 = SuperClass2()
//    println(super2.b1)
    println(super2.b2)
//    println(super2.b3)
    println(super2.b4)

    // 다른 모듈, 객체를 생성하는 경우
    // private, protected, internal 요소 사용 불가
    val super3 = SuperClass3()
    println(super3.c1)
    println(super3.c2)
    println(super3.c3)
    println(super3.c4)


}

private class PrivateClass1
class PublicClass1

////클래스에 지정할 수없음!!
//protected ProtedClass3
internal class InternalClass1

open class SuperClass1 {
    //kotlin에서는 기본적으로 private변수
    //kotlin에서접근제한자를 설정하면 자바로 변환될때 setter getter 생성에 대한
    //접근자 설정이 된다
    private var a1 = 100
    public var a2 = 200
    protected var a3 = 300
    internal var a4 = 400
}

// 같은 모듈, 같은 패키지, 같은 파일, 상속 하는 경우
// private 요소 접근 불가
class SubClass1 : SuperClass1(){

    fun subMethod1(){
        // print(a1)
        print(a2)
        print(a3)
        print(a4)
    }
}

// 같은 모듈, 다른 패키지, 상속하는 경우
// private 요소 사용 불가
class SubClass2 : SuperClass2(){

    fun subMethod2(){
        print(b1)
        print(b2)
        print(b3)
        print(b4)
    }
}

// 다른 모듈
// private, internal 요소 사용 불가
class SubClass3 : SuperClass3(){
    fun subMethod3(){
        println(c1)
        println(c2)
        println(c3)
        println(c4)
    }
}
