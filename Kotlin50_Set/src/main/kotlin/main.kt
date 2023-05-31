fun main(){

    // 수정 불가능한 set
    val set1 = setOf(10, 20, 30, 10, 20, 30)
    // 수정 가능한 set
    val set2 = mutableSetOf(10, 20, 30, 10, 20, 30)
    println("set1 : $set1")
    println("set2 : $set2")

    // 추가
    set2.add(40)
    println("set2 : $set2")

    set2.add(10)
    println("set2 : $set2")

    // set -> list
    val list1 = set2.toList()
    val list2 = set2.toMutableList()

    println("list1 : $list1")
    println("list2 : $list2")

    // list -> set
    val list3 = listOf(10, 20, 30, 10, 20, 30)

    val set3 = list3.toSet()
    val set4 = list3.toMutableSet()
    println("set3 : $set3")
    println("set4 : $set4")

}
