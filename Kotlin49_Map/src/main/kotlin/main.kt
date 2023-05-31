fun main(){

    // 수정 불가능한 map
    // 이름 to 값(객체)
    // 이름은 꼭 문자열이 아니어도 된다
    val map1 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    println("map1 : $map1")

    val map2 = mapOf(10 to "str1", 20 to "str2", 30 to "str3")
    println("map2 : $map2")

    // 수정 가능한 map
    val map3 = mutableMapOf("key1" to 10, "key2" to 20, "key3" to 30)
    println("map3 : $map3")

    // mapOf 혹은 mutableMapOf를 사용할 때 제네릭을 설정하는 것을 권장하고 있다.
    // 이름과 값의 타입이 모두 같을 경우
    val map4 = mapOf<String, Int>("key1" to 10, "key2" to 20, "key3" to 30)
    println("map4 : $map4")

    // 만약 이름이나 값의 타입이 다양하게 저장되다면 Any로 설정해준다.
    val map5 = mapOf<String, Any>("key1" to 10, "key2" to 11.11)
    println("map5 : $map5")

    // 제네릭은 어떠한 경우라도 생략이 가능하기 때문에 그냥 생략하고 쓰세요...
    val map6 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    val map7 = mapOf("key1" to 10, "key2" to 11.11)
    println("map6 : $map6")
    println("map7 : $map7")

    // 비어있는 map
    // 비어있는 map을 만들 때는 값이 없기 때문에 제네릭을 자동으로 설정할 수 없다.
    // 따라서 제네릭을 무조건 작성해 줘야 한다.
    val map8 = mapOf<String, Int>()
    val map9 = mutableMapOf<String, Int>()

    println("---------------------------------------")
    // 관리하는 객체(값)을 가지고 온다.
    val map10 = mapOf("key1" to 10, "key2" to 20, "key3" to 30)
    val map11 = mutableMapOf("key1" to 10, "key2" to 20, "key3" to 30)

    println("map10 key1 : ${map10.get("key1")}")
    println("map11 key1 : ${map11.get("key1")}")

    println("map10 key2 : ${map10["key2"]}")
    println("map11 key2 : ${map11["key2"]}")

    println("----------------------------------------")

    // 관리하는 값(객체)의 개수
    println("map1 size : ${map1.size}")
    // 이름들을 가져온다.
    println("map1 keys : ${map1.keys}")
    // 값들을 가져온다.
    println("map1 values : ${map1.values}")

    // 이 이름의 값이 있는지...
    println("map1 contains key - key1 : ${map1.containsKey("key1")}")
    println("map1 contains key - key100 : ${map1.containsKey("key100")}")

    // 이 값이 저장되어 있는지...
    println("map1 contains value - 10 : ${map1.containsValue(10)}")
    println("map1 contains value - 100 : ${map1.containsValue(100)}")

    println("-------------------------------------")

    val map12 = mutableMapOf("a1" to 10, "a2" to 20)
    println("map12 : $map12")

    // 추가
    map12.put("a3", 30)
    println("map12 : $map12")

    map12["a4"] = 40
    println("map12 : $map12")

    // 수정 : 없는 이름으로 값을 넣어주면 추가가 되고 있는 이름으로 값을 넣어주면
    // 수정된다.
    map12["a1"] = 100
    println("map12 : $map12")

    // 삭제
    map12.remove("a1")
    println("map12 : $map12")

    println("--------------------------------------------")

    // mapOf -> mutableMapOf
    val map13 = mapOf("a1"  to 10, "a2" to 20, "a3" to 30)

    val map14 = map13.toMutableMap()
    map14["a4"] = 40
    println("map14 : $map14")

    // mutableMapOf -> mapOf
    val map15 = map14.toMap()
    // map15["a5"] = 50
}







