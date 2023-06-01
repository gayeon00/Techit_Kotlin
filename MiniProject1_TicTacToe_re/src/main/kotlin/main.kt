import java.util.*

fun main() {
    val gameBoard = GameBoard()

    while (true) {
        gameBoard.nextTurn()
        gameBoard.printBoard()
        gameBoard.selectPosition()
        if (gameBoard.check()) {
            println("게임이 끝났습니다.")
            gameBoard.printBoard()
            break
        }
        gameBoard.changePlayer()
    }
}

class GameBoard {


    val player1 = Player()
    val player2 = Player()

    val board = arrayOf(
        arrayOf("_", "_", "_"),
        arrayOf("_", "_", "_"),
        arrayOf("_", "_", "_")
    )

    var turnNumber = 0
    var currentPlayer = player1

    fun nextTurn() {
        turnNumber++
    }

    fun selectPosition() {
        while (true) {
            val position = currentPlayer.selectPosition()

            if (isPositionAvailable(position)) {
                if (currentPlayer == player1) {
                    board[position.first][position.second] = "O"
                    break
                } else {
                    board[position.first][position.second] = "X"
                    break
                }
            } else {
                println("놓을 수 없는 자리입니다.")
            }
        }
    }

    private fun isPositionAvailable(newPosition: Pair<Int, Int>): Boolean {
        return board[newPosition.first][newPosition.second] == "_"
    }

    fun check(): Boolean {
        //가로 체크
        for (row in board) {
            if (row[0] != "_" && row[0] == row[1] && row[1] == row[2]) {
                return if (row[0] == "O") {
                    println("Player1 승리")
                    true
                } else {
                    println("Player2 승리")
                    true
                }
            }
        }


        //세로 체크
        for (i in 0..2) {
            if (board[0][i] != "_" && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return if (board[0][i] == "O") {
                    println("Player1 승리")
                    true
                } else {
                    println("Player2 승리")
                    true
                }
            }
        }

        //대각선 체크
        if (board[0][0] != "_" && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return if (board[0][0] == "O") {
                println("Player1 승리")
                true
            } else {
                println("Player2 승리")
                true
            }
        }

        //대각선 체크
        if (board[0][2] != "_" && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return if (board[0][0] == "O") {
                println("Player1 승리")
                true
            } else {
                println("Player2 승리")
                true
            }
        }

        return false
    }

    fun printBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                print("${board[i][j]}  ")
            }
            println()
        }
    }

    fun changePlayer() {
        currentPlayer = if (currentPlayer == player1) {
            player2
        } else {
            player1
        }
    }
}

class Player {
    private val sc = Scanner(System.`in`)

    fun selectPosition(): Pair<Int, Int> {
        print("위치를 선택하세요 (1~9) : ")

        return when (sc.nextInt()) {
            1 -> Pair(0, 0)
            2 -> Pair(0, 1)
            3 -> Pair(0, 2)
            4 -> Pair(1, 0)
            5 -> Pair(1, 1)
            6 -> Pair(1, 2)
            7 -> Pair(2, 0)
            8 -> Pair(2, 1)
            9 -> Pair(2, 2)
            else -> {
                println("잘못된 위치입니다.")
                Pair(-1, -1)
            }
        }
    }
}