import java.util.*

fun main() {
    val restaurant = Restaurant()

    var foodType = 0

    while (true) {
        foodType = restaurant.selectFoodType()
        if (foodType == 4) {
            println("종료합니다")
            break
        }

        restaurant.addFood(foodType)
    }

    restaurant.printStatus()
    restaurant.printFoodList()

}

open class Food(var name: String, var price: Int) {
    fun printFoodInfo() {
        println("음식 : $name")
        println("가격 : ${price}원")
    }
}

class Jjajang(var isDouble: String) : Food("짜장면", 6000) {

    fun printJjajangInfo() {
        printFoodInfo()
        println("곱배기여부 : $isDouble")
    }
}

class Jjambbong(var hasMussel: String) : Food("짬뽕", 8000) {

    fun printJjambbongInfo() {
        printFoodInfo()
        println("홍합여부 : $hasMussel")
    }

}

class Fried(var soup: String) : Food("볶음밥", 10000) {
    fun printFriedInfo() {
        printFoodInfo()
        println("국물종류 : $soup")
    }
}

class Restaurant {
    val sc = Scanner(System.`in`)
    val jjajangList = arrayListOf<Jjajang>()
    val jjambbongList = arrayListOf<Jjambbong>()
    val friedList = arrayListOf<Fried>()

    fun selectFoodType(): Int {
        println("메뉴를 선택해주세요")
        print("1. 짜장면, 2. 짬뽕, 3. 볶음밥, 4. 종료 : ")
        return sc.nextInt()
    }

    fun addFood(food: Int) {
        when (food) {
            1 -> {
                print("곱배기 여부를 선택해주세요 : ")
                jjajangList.add(Jjajang(sc.next()))
            }
            2 -> {
                print("홍합 여부를 선택해주세요 : ")
                jjambbongList.add(Jjambbong(sc.next()))
            }
            3 -> {
                print("국물 종류를 선택해주세요 : ")
                friedList.add((Fried(sc.next())))
            }
        }
    }

    fun calculateTotalPrice(): Int {
        return jjajangList.size * 6000 + jjambbongList.size * 8000 + friedList.size * 10000
    }

    fun printStatus() {
        println("주문 총 금액 : ${calculateTotalPrice()}")
        println("짜장면 : ${jjajangList.size}")
        println("짬뽕 : ${jjambbongList.size}")
        println("볶음밥 : ${friedList.size}")
    }

    fun printFoodList() {
        for (jjajang in jjajangList) {
            jjajang.printJjajangInfo()
        }

        for (jjambbong in jjambbongList) {
            jjambbong.printJjambbongInfo()
        }

        for (fried in friedList) {
            fried.printFriedInfo()
        }
    }

}