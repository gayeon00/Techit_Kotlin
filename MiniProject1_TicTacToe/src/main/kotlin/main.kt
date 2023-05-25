import java.util.Scanner

fun main(){
    val gameBoard = GameBoard()
    while(true) {
        // 턴이 바뀔 때의 처리 메서드를 호출한다.
        gameBoard.nextTurn()
        // 게임판 출력
        gameBoard.printBoard()
        // 사용자로 하여금 수를 두게 한다.
        gameBoard.playerInput()
        // 현재 게임판을 검사한다.
        val chk = gameBoard.checkWinner()
        // 게임이 종료되었다면 중단한다.
        if(chk == true){
            gameBoard.printBoard()
            break
        }
        // 현재 수를 두는 사용자를 바꿔준다.
        gameBoard.changePlayer()
    }
}

class GameBoard{

    val scanner = Scanner(System.`in`)

    // 턴 번호
    var turnNumber = 0

    // 게임판 정보를 담을 배열
    val gameBoardData = arrayOf(
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " "),
        arrayOf(" ", " ", " ")
    )

    // 사용자 객체 생성
    val player1 = Player("Player 1", "O")
    val player2 = Player("Player 2", "X")

    // 첫번째 사용자를 설정한다.
    var currentPlayer = player1

    // 턴이 바뀔 때 필요한 처리
    fun nextTurn(){
        turnNumber++
    }

    // 보드를 출력한다.
    fun printBoard(){
//        println()
//        println("${turnNumber}번째 턴")
//        println("  0 1 2")
//        println("0 ${gameBoardData[0][0]}|${gameBoardData[0][1]}|${gameBoardData[0][2]}")
//        println("  -+-+-")
//        println("1 ${gameBoardData[1][0]}|${gameBoardData[1][1]}|${gameBoardData[1][2]}")
//        println("  -+-+-")
//        println("2 ${gameBoardData[2][0]}|${gameBoardData[2][1]}|${gameBoardData[2][2]}")

        println()
        println("${turnNumber}번째 턴")
        println("  0 1 2")
        for(rowIdx in 0 until gameBoardData.size){
            print("$rowIdx ")
            for(colIdx in 0 until gameBoardData[rowIdx].size){
                print("${gameBoardData[rowIdx][colIdx]}")
                if(colIdx < gameBoardData[rowIdx].size - 1){
                    print("|")
                }
            }
            println()
            if(rowIdx < gameBoardData.size - 1){
                println("  -+-+-")
            }
        }
    }

    // 사용자가 보드에 자기 표시를 놓는다
    fun playerInput(){
        while(true) {
            println()
            print("${currentPlayer.playName} turn (행,열) : ")
            // 현재 사용자로 하여금 수를 두도록 한다.
            val newMarkPosition = currentPlayer.setPlayerMark()
            // 현재 수가 놓을 수 있는 수인지 검사한다.
            val check = isMarkPositionAvailabe(newMarkPosition)

            // 사용자가 놓은 수가 놓을 수 있는 수라면 반복을 중단한다.
            if(check == true){
                // 사용자가 선택한 위치에 수를 놓는다.
                val temp = newMarkPosition.split(",")
                val row = temp[0].toInt()
                val col = temp[1].toInt()
                gameBoardData[row][col] = currentPlayer.playMark
                break
            } else {
                println("다시 놓아 주세요")
            }
        }


    }

    // 사용자 교채
    fun changePlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2
        } else {
            currentPlayer = player1
        }
    }

    // 사용자가 놓은 수가 놓을 수 있는 수인지 검사
    fun isMarkPositionAvailabe(newMarkPostion:String):Boolean{
        // 행과 열로 나눈다.
        val temp1 = newMarkPostion.split(",")
        val row = temp1[0].toInt()
        val col = temp1[1].toInt()

        // 게임판 범위를 벗어 나는가...
        if(row < 0 || row > 2){
            return false
        }
        if(col < 0 || col > 2){
            return false
        }

        // 현재 위치에 다른 수가 놓여 있는가
        if(gameBoardData[row][col] != " "){
            return false
        }

        return true
    }

    // 승패 확인 처리
    fun checkWinner():Boolean{
        // 행 검사
        for(row in gameBoardData){
            // 가로줄에 같은 것이 있다면...
            if(row[0] != " " && row[0] == row[1] && row[1] == row[2]){
                // 마크가 무엇인지 확인한다
                if(row[0] == player1.playMark){
                    println("Player1 승리!!")
                    return true
                } else {
                    println("Player2 승리!!")
                    return true
                }
            }
        }

        // 열 검사
        for(colIdx in 0 until gameBoardData[0].size){
            if(gameBoardData[0][colIdx] != " " && gameBoardData[0][colIdx] == gameBoardData[1][colIdx]
                && gameBoardData[1][colIdx] == gameBoardData[2][colIdx]){
                if(gameBoardData[0][colIdx] == player1.playName){
                    println("Player1 승리!!")
                    return true
                } else {
                    println("Player2 승리!!")
                    return true
                }
            }
        }

        // 대각선 검사
        if(gameBoardData[0][0] != " " && gameBoardData[0][0] == gameBoardData[1][1] &&
            gameBoardData[1][1] == gameBoardData[2][2]){
            if(gameBoardData[0][0] == player1.playMark){
                println("Player1 승리!!")
                return true
            } else {
                println("Player2 승리!!")
                return true
            }
        }

        if(gameBoardData[0][2] != " " && gameBoardData[0][2] == gameBoardData[1][1] &&
            gameBoardData[1][1] == gameBoardData[2][0]){
            if(gameBoardData[0][2] == player1.playMark){
                println("Player1 승리!!")
                return true
            } else {
                println("PLayer2 승리!!")
                return true
            }
        }

        return false
    }
}

data class Player(var playName:String, var playMark:String){

    val scanner = Scanner(System.`in`)

    // 사용자가 자기 수를 두는 메서드
    fun setPlayerMark() : String{
        try {
            val newMarkPosition = scanner.next()
            val temp = newMarkPosition.split(",")
            val x = temp[0].toInt()
            val y = temp[1].toInt()
            return newMarkPosition
        }catch(e:Exception){
            println("잘못 입력하였습니다")
            return "0"
        }
    }
}
