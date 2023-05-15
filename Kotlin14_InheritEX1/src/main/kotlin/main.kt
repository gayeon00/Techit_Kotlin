import java.util.*

fun main() {
    val restaurant = Restaurant()

    restaurant.selectMenu()

    restaurant.printStatus()
    restaurant.printFoodList()

}

open class Food(var name: String, var price: Int) {
    fun printFoodInfo() {
        println("음식 : $name")
        println("가격 : ${price}원")
    }
}

class Jjajang(var isDouble: Boolean) : Food("짜장면", 6000) {

    fun printJjajangInfo() {
        printFoodInfo()
        if (isDouble) {
            println("곱배기여부 : 곱배기 입니다")
        } else {
            println("곱배기여부 : 곱배기 아입니다")
        }
    }
}

class Jjambbong(var hasMussel: Boolean) : Food("짬뽕", 8000) {

    fun printJjambbongInfo() {
        printFoodInfo()
        if (hasMussel) {
            println("홍합여부 : 홍합이 있습니다")
        } else {
            println("홍합여부 : 홍합이 없습니다")
        }
    }

}

class Fried(var soup: Boolean) : Food("볶음밥", 10000) {

    fun printFriedInfo() {
        printFoodInfo()
        if (soup) {
            println("국물종류 : 계란국물")
        } else {
            println("국물종류 : 짬뽕국물")
        }
    }
}

class Restaurant {
    val sc = Scanner(System.`in`)
    val jjajangList = arrayListOf<Jjajang>()
    val jjambbongList = arrayListOf<Jjambbong>()
    val friedList = arrayListOf<Fried>()

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
                    jjajangList.add(Jjajang(sc.nextBoolean()))
                }
                2 -> {
                    print("홍합 여부를 선택해주세요 : ")
                    jjambbongList.add(Jjambbong(sc.nextBoolean()))
                }
                3 -> {
                    print("국물 종류를 선택해주세요 : ")
                    friedList.add((Fried(sc.nextBoolean())))
                }
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