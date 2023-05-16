import java.util.*

/*동물원

동물사육장, 해양생물놀이터, 방목장, 밀림

동물 사육장은 모든 동물들이 있는 곳
해양생물놀이터는 돌고래와 상어가 있는 곳
방목장은 말과 기린이 있는 곳
밀림은 호랑이와 사자가 있는 곳

동물원에 있는 모든 동물들은 동물 사육장에 넣어주면 모든 동물들이 밥을 먹는다.
동물원에 있는 모든 동물들을 해양생물 놀이터에 넣어주면 돌고래와 상어가 헤엄을 친다.
동물원에 있는 모든 동물들을 방목장에 넣어주면 말과 기린과 호랑이만 뛰어 다닌다.
동물원에 있는 모든 동물들을 밀림에 넣어주면 상어와 기린과 사자가 사냥을 한다.



돌고래는 밥을 먹을 때 "냠냠냠"하고 먹는다.
상어는 밥을 먹을 때 "얌얌얌"하고 먹는다.
말은 밥을 먹을 때 "당근 당근"하고 먹는다.
기린은 밥을 먹을 때 ㅔ 하고 먹는다.
호랑이가 밥을 먹을 때 "아작 아작"하고 먹는다.
사자가 법을 먹을 때 "꿀꺽 꿀꺽" 하고 는다.

돌고래는 헤엄을 칠 때 "돌~돌~"하면서 헤엄을 친다.
상어가 헤엄을 칠 때 "슈웅 슈융" 하면서 헤엄을 친다.
말이 뛰어 다닐 때닌 "이히히히힝~" 하면서 뛰어 다니고
기린이 뛰어 다닐 때는 "영차~ 영차~" 하면서 뛰어 다닌다.
호랑이가 뛰어 다닐 때는 "헥~ 헥~" 하면서 뛰어 다닌다.
상어가 사냥을 하면 "으아아아아아!!!" 하면서 사냥을 한다.
호랑이가 사냥을 하면 "가즈아~" 하고 사냥을 한다.
사자가 사냥을 하면 "암컷아 사냥해와라~"하고 사냥을 한다.

프로그램이 시작되면 다음과 같이 입력을 받는다.
어떤 동물을 동물원에 넣어줄까요?
1. 돌고래, 2. 상어, 3. 말, 4. 기린, 5. 호랑이, 6. 사자, 0. 그만넣어 :

번호를 잘못 입력하면 잘못 입력하였습니다를 보여준다.
0을 입력하면 입력을 중단한다.

모든 동물들을 사육장에 넣어 결과를 출력한다.
모든 동물들을 해양생물 놀이터에 넣어 결과를 출력한다.
모든 동물들을 방목장에 넣어 결과를 출력한다.
모든 동물들을 밀림에 넣어 결과를 출력한다.

밥먹는 것, 헤엄치는 것, 뛰어 다는 것, 사냥하는 것은 모두 메서드로 만들어준다.

--- 출력 ---

타입 : 돌고래
크기 : 돌고래 만큼 크다
헤엄 속도 : 300노트

타입 : 상어
크기 : 상어 만큼 크다
헤엄 속도 : 500노트

타입 : 말
크기 : 말 만큼 크다
달리기 속도 : 300km/h

타입 : 기린
크기 : 기린 만큼 크다
달리기 속도 : 500km/h

타입 : 호랑이
크기 : 호랑이 만큼 크다
먹이량 : 500마리

타입 : 사자
크기 : 사자만큼 크다
먹이량 : 600마리

돌고래는 밥을 먹을 때 "냠냠냠"하고 먹는다.
상어는 밥을 먹을 때 "얌얌얌"하고 먹는다.
말은 밥을 먹을 때 "당근 당근"하고 먹는다.
기린은 밥을 먹을 때 "풀풀풀" 하고 먹는다.
호랑이가 밥을 먹을 때 "아작 아작"하고 먹는다.
사자가 법을 먹을 때 "꿀꺽 꿀꺽" 하고 는다.

돌고래는 헤엄을 칠 때 "돌~돌~"하면서 헤엄을 친다.
상어가 헤엄을 칠 때 "슈웅 슈융" 하면서 헤엄을 친다.
말이 뛰어 다닐 때닌 "이히히히힝~" 하면서 뛰어 다니고
기린이 뛰어 다닐 때는 "영차~ 영차~" 하면서 뛰어 다닌다.
호랑이가 뛰어 다닐 때는 "헥~ 헥~" 하면서 뛰어 다닌다.
상어가 사냥을 하면 "으아아아아아!!!" 하면서 사냥을 한다.
호랑이가 사냥을 하면 "가즈아~" 하고 사냥을 한다.
사자가 사냥을 하면 "암컷아 사냥해와라~"하고 사냥을 한다.

모든 출력은 항상 입력한 순서대로 출력한다.*/

// 1. 어떠한 클래스들이 필요한지를 정리한다(한국어 주석)
// 2. 각 클래스들의 이름을 정의한다(class 클래스명)
// 3. 각 클래스가 가져야할 모든 변수와 모든 메서드들을 클래스 내부에 정의한다(한국어 주석)
// 4. 한국어 주석으로 작성한 모든 변수와 모든 메서드들을 작성한다(멤버변수, 메서드는 { } 까지만)
// 5. 각 클래스 별로 중복되는 요소들을 정리한다.
// 6. 중복되는 요소들을 가지는 부모 클래스들을 정의한다.
// 7. 정의된 부모 클래스들 중에 메서드로만 구성되는 것은 인터페이스로 변경한다.
// 8. 부모 클래스들이 상속받거나 구현해야하는 인터페이스들을 설정해준다.
// 8-1. 만약 자식클래스가 반드시 구현해야 하는 메서드가 있다면 추상 메서드로 정의하고 클래스는 추상 클래스로 정의한다.
// 9. 최종 자식 클래스에 상속과 인터페이스를 설정해준다.
// 10. 최종 자식 클래스의 메서드들을 구현해준다

fun main() {
    val zoo = Zoo()
    zoo.inputAnimalNum()
    zoo.animalAction()
}

//메서드만 있다 -> 인터페이스
//멤버변수도 있다 -> 클래스 -> 구현할 메서드가 조금이라도 있다 -> 오픈 클래스
//                       -> 구현할 메서드가 없다 -> 추상 클래스


// 동물원
class Zoo {
    val sc = Scanner(System.`in`)
    val animalList = arrayListOf<Animal>()

    //동물 타입 입력 받는 메서드
    fun inputAnimalNum() {
        var inputNumber = 0
        while (true) {
            //동물 타입 입력
            println("어떤 동물을 동물원에 넣어줄까요?")
            println("1. 돌고래, 2. 상어, 3. 말, 4. 기린, 5. 호랑이, 6. 사자, 0. 그만넣어 : ")
            inputNumber = sc.nextInt()

            if (inputNumber !in 0..6) {
                println("잘못 입력했습니다")
                continue
            }

            if (inputNumber == 0) break

            //동물객체 생성
            val animal = createAnimal(inputNumber)
            animalList.add(animal)
        }
    }

    //각 동물들의 기능을 동작시키는 메서드
    fun createAnimal(inputNumber: Int) = when (inputNumber) {
        1 -> Dolphin("돌고래", "돌고래 만큼 크다", 300)
        2 -> Shark("상어", "상어 만큼 크다", 500)
        3 -> Horse("말", "말 만큼 크다", 300)
        4 -> Giraffe("기린", "기린만큼 크다", 500)
        5 -> Tiger("호랑이", "호랑이 만큼 크다", 300)
        6 -> Lion("사자", "사자 만큼 크다", 500)
        else -> Dolphin("", "", 0)
    }

    fun animalAction() {
        val vivarium = Vivarium()
        val marine = Marine()
        val pasture = Pasture()
        val jungle = Jungle()

        for(animal in animalList){
            animal.printAnimalInfo()
        }

        vivarium.eat(animalList)
        marine.swim(animalList)
        pasture.run(animalList)
        jungle.hunt(animalList)
    }



}

// 동물 사육장
class Vivarium {
    // - 동물들이 밥을 먹는 기능
    fun eat(animalList: ArrayList<Animal>) {
        for (animal in animalList) {
            animal.eat()
        }
    }
}


// 해양 생물 놀이터
class Marine {
    // - 동물들이 헤엄을 치는 기능
    fun swim(animalList: ArrayList<Animal>) {
        for (animal in animalList) {
            if (animal is MarineAnimal) {
                animal.swim()
            }
        }
    }
}

// 방목장
class Pasture {
    // - 동물들이 뛰어다니는 기능
    fun run(animalList: ArrayList<Animal>) {
        for (animal in animalList) {
            if (animal is RunAnimal2) {
                animal.run()
            }
        }
    }
}

// 밀림
class Jungle {
    // - 동물들이 사냥하는 기능
    fun hunt(animalList: ArrayList<Animal>) {
        for (animal in animalList) {
            if (animal is HuntAnimal) {
                animal.hunt()
            }
        }
    }
}


// 돌고래
// - 타입, 크기, 헤엄속도
/*class Dolphin(var type: String, var size: String, var swimSpeed: Int) {

    // - 밥을 먹는 기능
    fun eat() {

    }

    // - 헤엄치는 기능
    fun swimming() {

    }

    // - 정보를 출력하는 기능
    fun printInfo() {

    }
}*/
class Dolphin(type: String, size: String, swimSpeed: Int) : MarineAnimal(swimSpeed, type, size) {

    // - 밥을 먹는 기능
    override fun eat() {
        println("${type}은 냠냠냠하고 먹습니다.")
    }

    // - 헤엄치는 기능
    override fun swim() {
        println("${type}은 돌~돌~하면서 헤엄칩니다.")
    }

    // - 정보를 출력하는 기능
    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("헤엄속도 : ${swimSpeed}노트")
    }
}

// 상어
// - 타입, 크기, 헤엄속도
/*class Shark(var type: String, var size: String, var swimSpeed: Int) {
    // - 밥을 먹는 기능
    fun eat() {
    }

    // - 헤엄치는 기능
    fun swim() {
    }

    // - 사냥하는 기능
    fun hunt() {
    }

    // - 정보를 출력하는 기능
    fun printAnimalInfo() {
    }
}*/
class Shark(type: String, size: String, swimSpeed: Int) : MarineAnimal(swimSpeed, type, size), HuntAnimal {
    // - 밥을 먹는 기능
    override fun eat() {
        println("${type}은 얌얌얌하고 먹습니다.")
    }

    // - 헤엄치는 기능
    override fun swim() {
        println("${type}은 슈웅슈웅하면서 헤엄칩니다.")
    }

    // - 사냥하는 기능
    override fun hunt() {
        println("${type}은 으아아아아아!!! 하면서 사냥을 합니다.")
    }

    // - 정보를 출력하는 기능
    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("헤엄속도 : ${swimSpeed}노트")
    }
}

// 말
// - 타입, 크기, 달리기 속도
/*class Horse(var type: String, var size: String, var runSpeed: Int) {
    // - 밥을 먹는 기능
    fun eat() {
    }

    // - 뛰어 다니는 기능
    fun run() {
    }

    // - 정보를 출력하는 기능
    fun printInfo() {
    }
}*/
class Horse(type: String, size: String, runSpeed: Int) : RunAnimal1(runSpeed, type, size), RunAnimal2 {
    // - 밥을 먹는 기능
    override fun eat() {
        println("${type}은 당근 당근하고 먹습니다.")
    }

    // - 뛰어 다니는 기능
    override fun run() {
        println("${type}은 이히히히힝~ 하면서 뛰어다닙니다.")
    }

    // - 정보를 출력하는 기능
    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("달리기속도 : ${runSpeed}km/h")
    }
}

// 기린
// - 타입, 크기, 달리기 속도
/*class Giraffe(var type: String, var size: String, var runSpeed: Int) {
    // - 밥을 먹는 기능
    fun eat() {
    }

    // - 뛰어 다니는 기능
    fun run() {
    }

    // - 사냥하는 기능
    fun hunt() {
    }

    // - 정보를 출력하는 기능
    fun printInfo() {
    }
}*/
class Giraffe(type: String, size: String, runSpeed: Int) : RunAnimal1(runSpeed, type, size), RunAnimal2, HuntAnimal {
    // - 밥을 먹는 기능
    override fun eat() {
        println("${type}은 우물우물하고 먹습니다.")
    }

    // - 뛰어 다니는 기능
    override fun run() {
        println("${type}은 영차~영차~ 하면서 뛰어다닙니다.")
    }

    // - 정보를 출력하는 기능
    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("달리기속도 : ${runSpeed}km/h")
    }

    // - 사냥하는 기능
    override fun hunt() {
        println("${type}은 가즈아~하고 사냥을 합니다.")
    }
}

// 호랑이
// - 타입, 크기, 먹이량
/*class Tiger(var type: String, var size: String, var eatVolume: Int) {
    // - 밥을 먹는 기능
    fun eat() {
    }

    // - 뛰어 다니는 기능
    fun run() {
    }

    // - 정보를 출력하는 기능
    fun printInfo() {
    }
}*/
class Tiger(type: String, size: String, eatVolume: Int) : EatAnimal(eatVolume, type, size), RunAnimal2 {
    override fun eat() {
        println("${type}은 아작아작하고 먹습니다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("먹이양 : ${eatVolume}마리")
    }

    override fun run() {
        println("${type}은 헥~헥~하면서 뛰어다닙니다.")
    }

}

// 사자
// - 타입, 크기, 먹이량
/*class Lion(var type: String, var size: String, var eatVolume: Int) {
    // - 밥을 먹는 기능
    fun eat() {
    }

    // - 사냥하는 기능
    fun hunt() {

    }

    // - 정보를 출력하는 기능
    fun printInfo() {
    }
}*/
class Lion(type: String, size: String, eatVolume: Int) : EatAnimal(eatVolume, type, size), HuntAnimal {
    override fun eat() {
        println("${type}은 꿀꺽꿀꺽하고 먹습니다.")
    }

    override fun printAnimalInfo() {
        println("타입 : $type")
        println("크기 : $size")
        println("먹이양 : ${eatVolume}마리")
    }

    override fun hunt() {
        println("${type}은 암컷아 사냥해와라~하고 사냥합니다")
    }

}

//모든 동물들
/*open class Animal(var type: String, var size: String) {
    open fun eat() {

    }

    open fun printAnimalInfo() {

    }
}*/
//자식 클래스들이 반드시 구현해야하는 메서드들이기 때문에 추상으로 정의
abstract class Animal(var type: String, var size: String) {
    abstract fun eat()

    abstract fun printAnimalInfo()
}

// 해양 생물들
/*open class MarineAnimal(var swimSpeed: Int){
    open fun swim(){

    }
}*/
//Animal을 부모클래스로 둬야함
//얘도 swim이 자식 클래스들이 반드시 구현해야하는 메서드라 추상으로 정의
abstract class MarineAnimal(
    var swimSpeed: Int, type: String, size: String
) : Animal(type, size) {
    abstract fun swim()
}

//run -> 말, 기린, 호랑이 -> RunAnimal2
//runSpeed -> 말, 기린 -> RunAnimal1
// => RunAnimal1이 RunAnimal2를 상속받도록!!
//달리는 동물2
/*open class RunAnimal2{
    open fun run(){

    }
}*/
//메서드 밖에 없어서 인터페이스로 변경
interface RunAnimal2 {
    fun run()
}

//달리는 동물1
//추상 클래스 Animal을 상속받았는데 Animal의 추상 메서드를 오버라이딩 하지 않았으니
//다시 추상 클래스로 만들어줘야함
/*open class RunAnimal1(var runSpeed: Int)*/
abstract class RunAnimal1(
    var runSpeed: Int,
    type: String,
    size: String
) : Animal(type, size), RunAnimal2 {

}

//먹는 동물
/*open class EatAnimal(var eatVolume: Int)*/
abstract class EatAnimal(
    var eatVolume: Int,
    type: String,
    size: String
) : Animal(type, size) {

}


//사냥하는 동물
/*open class HuntAnimal(){
    open fun hunt(){

    }
}*/
//마찬가지로 메서드 밖에 없어서 인터페이스로 변경
interface HuntAnimal {
    fun hunt()
}