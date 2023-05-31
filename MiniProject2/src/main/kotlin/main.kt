fun main(){
    val mainClass = MainClass()
    mainClass.running()
}


// 프로그램 상태를 나타내는 enum
enum class ProgramState{
    // 상태를 나타내는 값들을 정의한다.
    PROGRAM_STATE_TEST1,
    PROGRAM_STATE_TEST2
}

// 메인 클래스
class MainClass{

    // 프로그램 상태를 담는 변수에 초기 상태를 설정한다.
    var programState = ProgramState.PROGRAM_STATE_TEST1 //특정한 상태 -> 무언가로 설정될거임

    // 프로그램 상태 전체를 관리하며 운영하는 메서드
    fun running(){
        while(true){        //프로그램 상태에 따른 분기
            when (programState) {
                ProgramState.PROGRAM_STATE_TEST1 -> {
                    //state1에서의 코드 작성
                    break
                }
                ProgramState.PROGRAM_STATE_TEST2 -> {
                    //state2에서의 코드 작성
                    break
                }
            }
        }
    }
}