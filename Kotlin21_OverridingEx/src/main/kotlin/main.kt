import java.util.*

fun main() {
    val restaurant = Restaurant()

    restaurant.selectMenu()

    restaurant.printStatus()
    restaurant.printFoodList()

}

open class Food(var name: String, var price: Int) {
    open fun printFoodInfo() {
        println("음식 : $name")
        println("가격 : ${price}원")
    }
}

class Jjajang(var isDouble: Boolean) : Food("짜장면", 6000) {

    override fun printFoodInfo() {
        super.printFoodInfo()
        if (isDouble) {
            println("곱배기여부 : 곱배기 입니다")
        } else {
            println("곱배기여부 : 곱배기 아입니다")
        }
    }
}

class Jjambbong(var hasMussel: Boolean) : Food("짬뽕", 8000) {

    override fun printFoodInfo() {
        super.printFoodInfo()
        if (hasMussel) {
            println("홍합여부 : 홍합이 있습니다")
        } else {
            println("홍합여부 : 홍합이 없습니다")
        }
    }

}

class Fried(var soup: Boolean) : Food("볶음밥", 10000) {

    override fun printFoodInfo() {
        super.printFoodInfo()
        if (soup) {
            println("국물종류 : 계란국물")
        } else {
            println("국물종류 : 짬뽕국물")
        }
    }
}

class Restaurant {
    val sc = Scanner(System.`in`)
    val foodList = arrayListOf<Food>()

    var countJjajang = 0
    var countJjambbong = 0
    var countFried = 0

    fun selectMenu() {
        var type = 0

        while (true) {

            println("메뉴를 선택해주세요")
            print("1. 짜장면, 2. 짬뽕, 3. 볶음밥, 4. 종료 : ")
            type = sc.nextInt()

            if (type !in 1..4) continue

            if (type == 4) {
                println("종료합니다")
                break
            }

            when (type) {
                1 -> {
                    print("곱배기 여부를 선택해주세요 : ")
                    foodList.add(Jjajang(sc.nextBoolean()))
                    countJjajang++
                }
                2 -> {
                    print("홍합 여부를 선택해주세요 : ")
                    foodList.add(Jjambbong(sc.nextBoolean()))
                    countJjambbong++
                }
                3 -> {
                    print("국물 종류를 선택해주세요 : ")
                    foodList.add((Fried(sc.nextBoolean())))
                    countFried++
                }
            }
        }


    }

    fun calculateTotalPrice(): Int {
        return countJjajang * 6000 + countJjambbong * 8000 + countFried * 10000
    }

    fun printStatus() {
        println("주문 총 금액 : ${calculateTotalPrice()}")
        println("짜장면 : ${countJjajang}")
        println("짬뽕 : ${countJjambbong}")
        println("볶음밥 : ${countFried}")
    }

    fun printFoodList() {
        for (food in foodList) {
            food.printFoodInfo()
        }
    }

}