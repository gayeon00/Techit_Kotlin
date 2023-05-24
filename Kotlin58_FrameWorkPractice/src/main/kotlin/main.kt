import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val mainClass = MainClass()
    mainClass.running()
}

// 프로그램 상태를 나타내는 enum
enum class ProgramState {
    // 학생 정보 입력받는 상태
    PROGRAM_STATE_INPUT_ANIMAL_INFO,
    PROGRAM_STATE_PRINT_ANIMAL_INFO,
    PROGRAM_STATE_ANIMAL_ACTION
}

class MainClass {
    var programState = ProgramState.PROGRAM_STATE_INPUT_ANIMAL_INFO
    val zoo = Zoo()

    fun running() {
        while (true){
            println()
            when(programState) {
                ProgramState.PROGRAM_STATE_INPUT_ANIMAL_INFO -> {
                    zoo.getAnimal()
                    programState = ProgramState.PROGRAM_STATE_PRINT_ANIMAL_INFO

                }
                ProgramState.PROGRAM_STATE_PRINT_ANIMAL_INFO -> {
                    zoo.printAnimalInfo()
                    programState = ProgramState.PROGRAM_STATE_ANIMAL_ACTION

                }
                ProgramState.PROGRAM_STATE_ANIMAL_ACTION -> {
                    zoo.printAnimalAction()
                    break
                }
            }
        }
    }
}
//동물원 클래스
class Zoo {

    val sc = Scanner(System.`in`)
    val animalList = arrayListOf<Animal>()

    //사용자 입력 받기
    fun getAnimal() {
        var input = 0
        while (true) {
            println("어떤 동물을 동물원에 넣어줄까요?")
            print("1. 돌고래, 2. 상어, 3. 말, 4. 기린, 5. 호랑이, 6. 사자, 0. 그만넣어 : ")

            input = sc.nextInt()

            if (input !in 0..6) {
                println("다시 입력해주세요")
                continue
            }

            if (input == 0) break

            val animal = createAnimal(input)
            animalList.add(animal)
        }
    }

    //출력하기
    fun printAnimalInfo() {
        for (animal in animalList) {
            animal.printAnimalInfo()
        }
    }

    val breedingArea = BreedingArea(animalList)
    val marinePlayground = MarinePlayground(animalList)
    val pasture = Pasture(animalList)
    val jungle = Jungle(animalList)

    //각 장소에 넣기
    fun printAnimalAction() {
        breedingArea.eat()
        marinePlayground.swim()
        pasture.run()
        jungle.hunt()
    }

    private fun createAnimal(input: Int) = when (input) {
        1 -> Dolphin(300, "돌고래", "돌고래 만큼 크다")
        2 -> Shark(500, "상어", "상어 만큼 크다")
        3 -> Horse(300, "말", "말 만큼 크다")
        4 -> Giraffe(500, "기린", "기린 만큼 크다")
        5 -> Tiger(500, "호랑이", "호랑이 만큼 크다")
        6 -> Lion(600, "사자", "사자 만큼 크다")
        else -> Dolphin(0, "", "")
    }

}

//동물 사육장 클래스
class BreedingArea(val animalList: ArrayList<Animal>) {
    //모든 동물들이 밥을 먹는 메서드
    fun eat() {
        for (animal in animalList) {
            animal.eat()
        }
    }
}

//해양생물 놀이터 클래스
class MarinePlayground(val animalList: ArrayList<Animal>) {
    //돌고래와 상어가 헤엄을 치는 메서드
    fun swim() {
        for (animal in animalList) {
            if (animal is SwimmingAnimal) {
                animal.swim()
            }
        }
    }

}

//방목장 클래스
class Pasture(val animalList: ArrayList<Animal>) {
    //말, 기린, 호랑이가 뛰어다니는 메서드
    fun run() {
        for (animal in animalList) {
            if (animal is RunningAnimal) {
                animal.run()
            }
        }
    }

}

//밀림 클래스
class Jungle(val animalList: ArrayList<Animal>) {
    //상어, 기린, 사자가 사냥을 하는 메서드
    fun hunt() {
        for (animal in animalList) {
            if (animal is HunterAnimal) {
                animal.hunt()
            }
        }
    }

}

//돌고래 클래스
class Dolphin(swimSpeed: Int, type: String, size: String) : SwimmingAnimal(swimSpeed, type, size) {
    override fun swim() {
        println("${type}는 돌~돌~ 하면서 헤엄을 친다.")
    }

    override fun eat() {
        println("${type}은 냠냠냠 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("헤엄 속도 : ${swimSpeed}노트")
    }

}

//상어 클래스
class Shark(swimSpeed: Int, type: String, size: String) : SwimmingAnimal(swimSpeed, type, size), HunterAnimal {
    override fun swim() {
        println("${type}는 슈웅 슈웅 하면서 헤엄을 친다.")
    }

    override fun eat() {
        println("${type}은 얌얌얌 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("헤엄 속도 : ${swimSpeed}노트")
    }

    override fun hunt() {
        println("${type}은 으아아아아아!!! 하면서 사냥한다.")
    }
}

//말 클래스
class Horse(runningSpeed: Int, type: String, size: String) : RunningAnimal(runningSpeed, type, size) {
    override fun eat() {
        println("${type}은 당근 당근 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("달리기 속도 : ${runningSpeed}km/h")
    }

    override fun run() {
        println("${type}은 이히히히힝~ 하면서 뛰어다닌다.")
    }

}

//기린 클래스
class Giraffe(runningSpeed: Int, type: String, size: String) : RunningAnimal(runningSpeed, type, size), HunterAnimal {
    override fun eat() {
        println("${type}은 풀 풀 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("달리기 속도 : ${runningSpeed}km/h")
    }

    override fun run() {
        println("${type}은 영차~ 영차~ 하면서 뛰어다닌다.")
    }

    override fun hunt() {
        println("${type}은 가즈아~하고 사냥을 한다.")
    }

}

//호랑이 클래스
class Tiger(numEat: Int, type: String, size: String) : PredatorAnimal(numEat, type, size), RunningAnimal2 {
    override fun eat() {
        println("${type}은 아작 아작 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("먹이양 : ${numEat}마리")
    }

    override fun run() {
        println("${type}은 헥~ 헥~하면서 뛰어다닌다.")
    }

}

//사자 클래스
class Lion(numEat: Int, type: String, size: String) : PredatorAnimal(numEat, type, size), HunterAnimal {
    override fun eat() {
        println("${type}은 꿀꺽 꿀꺽 하고 밥을 먹는다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("먹이양 : ${numEat}마리")
    }

    override fun hunt() {
        println("${type}은 암컷아 사냥해와라~하고 사냥을 한다.")
    }

}

//모든 동물 -> 밥 먹는다, 출력한다
// 타입, 크기
abstract class Animal(var type: String, var size: String) {
    abstract fun eat()

    abstract fun printAnimalInfo()
}

//돌고래, 상어 -> 헤엄친다(), 헤엄 속도
abstract class SwimmingAnimal(var swimSpeed: Int, type: String, size: String) : Animal(type, size) {
    abstract fun swim()
}

// 말, 기린, 호랑이 -> 뛰어다닌다(Runner1)
// 말, 기린 -> 달리기 속도(Runner2(Runner1을 상속받음)
interface RunningAnimal2 {
    fun run()
}

abstract class RunningAnimal(var runningSpeed: Int, type: String, size: String) : Animal(type, size), RunningAnimal2

//호랑이, 사자 -> 먹이양
abstract class PredatorAnimal(var numEat: Int, type: String, size: String) : Animal(type, size)

// 상어, 기린, 사자 -> 사냥한다()
interface HunterAnimal {
    fun hunt()
}