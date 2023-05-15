fun main() {
    // 1 ~ 10까지 총 10번 반복을 하고
    // 반복할 때 마다 반복 회차에 해당하는 값을 in 좌측 변수에 담아준다.
    // 이때, 변수는 타입을 정하지 않아도 된다.
    for(item1 in 1..10){
        println("item1 : $item1")
    }

    println("-----------------------------------")

    // 2씩 증가 시키는 경우
    for(item2 in 1..10 step 2){
        println("item2 : $item2")
    }

    println("-----------------------------------")

    // 10부터 감소...
    for(item3 in 10 downTo 1){
        println("item3 : $item3")
    }
    println("-----------------------------------")

    // 10부터 2씩 감소
    for(item4 in 10 downTo 1 step 2){
        println("item4 : $item4")
    }
    println("-----------------------------------")

    // while
    // 자바랑 동일하다
    var a5 = 0

    while(a5 < 10){
        println("while : $a5")
        a5++
    }
    println("-----------------------------------")

    // do while
    // 자바랑 동일하다
    var a6 = 0

    do{
        println("do while : $a6")
        a6++
    } while(a6 < 10)
}