import java.util.*

fun main() {
    val carFactory = CarFactory()

    var inputNumber = 0

    while (true) {
        inputNumber = carFactory.getCommand()
        if(inputNumber==0){
            println("생산을 종료합니다")
            break
        }

        val car = carFactory.createCar(inputNumber)
        carFactory.addCar(car)
    }

    carFactory.printCarCount()
    carFactory.printCarListInfo()
    carFactory.printAvgSpeed()
    carFactory.printTotalCapacity()
    carFactory.printCarCountByFuel()
}

class Car(
    var name: String,
    //최대속도
    var maxSpeed: Int,
    var fuel: String,
    var capacity: Int
){

    fun printCarInfo(){
        println("종류 : $name")
        println("최대속도 : ${maxSpeed}km/h")
        println("연료 : $fuel")
        println("탑승인원수 : ${capacity}명")
    }
}

class CarFactory {
    val sc = Scanner(System.`in`)
    val carList = arrayListOf<Car>()


    init {
        println("자동차 공장 가동 시작합니다\n")
    }

    fun getCommand(): Int {
        var command = 0
        while (true) {
            println("생산할 자동차를 선택해주세요")
            print("1. 붕붕, 2. 승용차, 3. 버스, 4. 트럭, 0. 생산종료 : ")
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
    fun addCar(car:Car){
        carList.add(car)
    }

    // 장난감을 생산하여 반환하는 메서드
    fun createCar(carType:Int) = when(carType){
        1 -> Car("붕붕",300,"꽃향기",1)
        2 -> Car("승용차",200,"휘발유",4)
        3 -> Car("버스",150,"가스",50)
        4 -> Car("트럭",100,"가스",3)
        else -> Car("",0,"",0)
    }

    fun printAvgSpeed() {
        var totalSpeed = 0

        for(car in carList){
            totalSpeed+=car.maxSpeed
        }

        val avgSpeed = if(carList.size > 0) totalSpeed/carList.size else 0
        println("\n생산된 자동차들의 평균 속도 : ${avgSpeed}km/h")
    }

    fun printTotalCapacity(){
        var totalCapacity = 0
        for(car in carList) {
            totalCapacity+=car.capacity
        }

        println("\n생산된 자동차들의 총 탑승인원수 : ${totalCapacity}명")

    }

    fun printCarListInfo(){
        for(car in carList) {
            car.printCarInfo()
        }
    }

    fun printCarCountByFuel() {
        var flowerCount = 0
        var gasolineCount = 0
        var gasCount = 0

        for(car in carList) {
            when(car.name){
                "붕붕" -> flowerCount++
                "승용차" -> gasolineCount++
                "버스","트럭" -> gasCount++
            }
        }

        println("\n연료가 꽃향기인 자동차의 수 : ${flowerCount}대")
        println("연료가 휘발유인 자동차의 수 : ${gasolineCount}대")
        println("연료가 가스인 자동차의 수 : ${gasCount}대")
    }

    fun printCarCount() {
        var boongCount = 0
        var normalCount = 0
        var busCount = 0
        var truckCount = 0

        for(car in carList){
            when(car.name){
                "붕붕" -> boongCount++
                "승용차" -> normalCount++
                "버스"-> busCount++
                "트럭" -> truckCount++
            }
        }

        val totalCarCount = boongCount+normalCount+busCount+truckCount

        println("\n총 생산 자동차 수 : ${totalCarCount}대")
        println("붕붕 : ${boongCount}대")
        println("승용차 : ${normalCount}대")
        println("버스 : ${busCount}대")
        println("트럭 : ${truckCount}대")

    }
}