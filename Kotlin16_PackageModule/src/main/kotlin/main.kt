import com.test.pkg1.TestClass1
import com.test.pkg1.testFunction1

fun main() {
    val t1 = TestClass1()
    t1.testMethod1()

    //코틀린에선 클래스 내부에 있지않은 함수를 자바로 변환할 때 static으로 변환하기 때문에
    //날것 그대로 사용 가능
    testFunction1()

    //모듈 : 하나의 프로그램 단위
    // 모듈단위로 배포 가능!!
    
}