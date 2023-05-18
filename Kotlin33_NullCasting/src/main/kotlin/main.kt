fun main() {
    testMethod1("안녕요")
    testMethod1(null)
}

fun testMethod1(str: String?) {
    //!!연산자는 non-null 변수로 변환하는 작업 수행
    //null이들어있다면 오류 발생
//    println(str!!.length)

    //? 연산자는 참조변수에 null이 들어가있을 경우 프로퍼티를 사용하면 null이 반환되고
    //메서드를 호출하면 메서드 호출을 무시한다.
    //권장 X
//    println(str?.length)

    //스마트 캐스팅(non-null String 타입으로...)
    //null이 아닌 경우에만 null이 아닌 변수로 바껴서 if안쪽 코드를 실행한다
    if (str is String) {
        println(str.length)
    }

    // 참조변수에 null이 들어가 있면 if문이 거짓이기 때문에 아무것도 수행하지 않는다.
    // 허나 null이 아닌 객체의 id가 들어가 있다면 null을 허용하지 않는 변수로 스마트
    // 캐스팅이 발생한다.
    if (str != null) {
        println(str.length)
    }
}