import java.util.*

fun main() {
    //자판기 객체 생성
    val vendingMachine = VendingMachine()

    //자판기.사용자입력받기
    val inputNumber = vendingMachine.getCustomerInput()
    //자판기.돈받기
    val item = vendingMachine.getItem(inputNumber)
    //자판기.음료뱉기
    val coinCount =vendingMachine.getMoney(item)
    //자판기.잔액출력
    vendingMachine.exitItem(item, coinCount)
}

class Drink(var name: String, var price: Int, var volume: Int, var company: String) {
    fun printDrinkInfo() {
        println("${name}은 ${price}원이고")
        println("양은 ${volume}ml입니다.")
        println("회사는 ${company}입니다.")
    }
}

class VendingMachine {
    //속성
    val sc = Scanner(System.`in`)
    var receivedMoney: Int = 0
    var moneyToBeReceived: Int = 0
    val drinks = arrayOf(
        Drink("콜라", 1000, 300, "코카콜라"),
        Drink("사이다", 1000, 300, "칠성"),
        Drink("커피", 1500, 500, "별다방"),
        Drink("복숭아아이스티", 2000, 700, "빽다방"),
    )

    //메서드
//    사용자 입력받기
    fun getCustomerInput(): Int {
        var customerInput = 0
        while (true) {
            println()
            println("음료수를 고르세요")
            print("1. 콜라(1000원), 2. 사이다(1000원), 3.커피(1500원), 4.복숭아아이스티(2000원) : ")
            customerInput = sc.nextInt()
            if (customerInput in 1..4) {
                break
            } else {
                println("다시 입력해주세요")
            }
        }

        return customerInput
    }

    // 번호에 따라 음료수 객체를 생성하여 반환하는 함수
    fun getItem(itemNumber:Int) = when(itemNumber){
        1 -> Drink("콜라", 1000, 300, "코카콜라")
        2 -> Drink("사이다", 1000, 300, "칠성")
        3 -> Drink("커피", 1500, 500, "별다방")
        4 -> Drink("복숭아아이스티", 2000, 700, "빽다방")
        else -> Drink("아무거나", 3000, 100, "아무거나")
    }

    //    돈받기
    fun getMoney(item: Drink): Int {
        var coin = 0
        while(coin < item.price){
            println("현재 : ${coin}원 / 부족 : ${item.price - coin}")
            print("동전을 넣어주세요 : ")
            val inputCoin = sc.nextInt()
            coin += inputCoin
        }
        println("현재 : ${coin}원 / 부족 : ${item.price - coin}")
        return coin
    }

    // 음료수가 나오는 기능
    fun exitItem(item: Drink, coinCount:Int){
        // 입력한 동전에서 상품가격을 빼준다.
        val overCoinCount = coinCount - item.price

        println("${item.name}이(가) 나왔습니다")
        println("잔액은 ${overCoinCount}원 입니다")

        item.printDrinkInfo()
    }
}