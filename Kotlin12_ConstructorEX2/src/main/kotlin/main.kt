import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val toyFactory = ToyFactory()

    var inputNumber = 0
    while (true) {
        inputNumber = toyFactory.getCommand()
        if (inputNumber == 0) {
            println("생산을 종료합니다")
            break
        }

        val toy = toyFactory.createToy(inputNumber)
        toyFactory.addToy(toy)
    }

    toyFactory.printToyCount()
    toyFactory.printToyInfo()
    toyFactory.printToyPrice()

}

class Toy(
    var name: String,
    var price: Int,
    var size: String
) {
    fun printToyInfo() {
        println(name)
        println("가격 : $price")
        println("크기 : ${size} 만큼 크다")
    }
}

class ToyFactory {
    val sc = Scanner(System.`in`)
    val toys = arrayListOf<Toy>()


    fun getCommand(): Int {
        var command = 0
        while (true) {
            println("생산할 장난감의 종류를 선택해주세요")
            print("1. 로보트 장난감, 2. 레고, 3. BB탄 총, 4. 잠만보인형, 0. 생산끝 : ")
            command = sc.nextInt()
            if (command in 0..4) {
                break
            } else {
                println("잘못 입력하였습니다")
            }
        }

        return command
    }

    // 생산된 장난감을 저장한다.
    fun addToy(toy:Toy){
        toys.add(toy)
    }

    // 장난감을 생산하여 반환하는 메서드
    fun createToy(toyType:Int) = when(toyType){
        1 -> Toy("로보트 장난감", 5000, "로보트")
        2 -> Toy("레고", 50000, "레고")
        3 -> Toy("BB탄 총", 10000, "BB탄 총")
        4 -> Toy("잠만보인형", 20000, "잠만보")
        else -> Toy("아무장난감", 0, "아무장난감")
    }



    fun printToyCount(){
        var robotCount = 0
        var legoCount = 0
        var bbCount = 0
        var jamCount = 0

        println()
        println("총 : ${toys.size}개")

        for(toy in toys){
            when(toy.name){
                "로보트 장난감" -> robotCount++
                "레고" -> legoCount++
                "BB탄 총" -> bbCount++
                "잠만보인형" -> jamCount++
            }
        }

        println("로보트 장난감 : ${robotCount}개")
        println("레고 : ${legoCount}개")
        println("BB탄 총 : ${bbCount}개")
        println("잠만보인형 : ${jamCount}개")
    }

    fun printToyInfo() {
        for (toy in toys) {
            println()
            toy.printToyInfo()
        }
    }

    fun printToyPrice(){
        var totalPrice = 0

        for(toy in toys){
            totalPrice+=toy.price
        }

        println()
        println("생산된 장난감 총 가격 : $totalPrice")

        val avgPrice = if(toys.size==0) 0 else (totalPrice / toys.size)
        println("생산된 장난감 평균 가격 : $avgPrice")
    }
}