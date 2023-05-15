fun main() {
    /*리터럴*/

    println(100)
    //4 byte넘기면 코틀린이 알아서 L로 처리함
    println(100000000000000)
    //_넣은거는 빠진거랑 똑같은 숫자로 처리
    println(765_234_574_858)
    //코틀린도 기본 실수는 double -> float하고 싶으면 f붙여야함
    println(11.11)
    println(11.11f)
    //문자 리터럴
    println('A')
    //문자열
    println("문자열")

    //논리 타입
    println(true)

    //RawString
    //여러줄의 문자열을 표현할 때 사용
    println("""동해물과
        |백두산이
        |마르고 닳도록
        |하느님이 보우하사
        |우리나라 만세
    """.trimMargin())

    //변수
    //var/val 변수명: 클래스타임
    //변수 선언 시 값을 지정해야 함!!
    var a1: Int = 1
    //println("a1: $a1")
    //${}안에 변수가 들어오면 {}생략 가능!
    println("a1: $a1")

    //변수를 선언할 때 초기화해주면 타입 생략
    var a2 = 200
    var a3 = 11.11
    println("a2: $a2")
    println("a3: $a3")

    //var: 변경할 수 있는 변수
    //val: 변경할 수 없는 변수
    var a4 = 100
    val a5 = 300
    println("a4: $a4")
    println("a5: $a5")

    //참조 변수에 객체의 id가 있다면 그 객체에 접근할 수 있지만
    //null이있다면 id가 없으므로 접근할 수 없음 -> NullPointerException
    //?변수: nullable
    //일반변수: non-null
    var a6: Int? = null
//    var a7: Int = null
    println("a6: $a6")

    //null을 허용하지 않는 변수에 null을 허용하는 변수의 값을 저장
    //nullable인 변수는 사용 시 사용자가 null이 아님을 !!로 보장해줘야함
    //=> 권장 X
    var a7:Int = a6!!

    //null이 아닐때만 저장하도록 이렇게 해라! 왜? 코틀린 자체가 null안정성을 도모하기 위해
    //nullable을 지원해주는 거니까!
    //라이브러리 함수가 nullable을 return 한다면, 받아서 if(null이 아닐때만) 수행하도록 만들자!!
    // => 권장
    if(a6!=null){
        var a8: Int = a6
        println("a8: $a8")
    }
}