fun main(){

    // 리스트 생성
    // 불변형 리스트
    // 리스트 생성 이후 값의 추가, 수정, 삽입, 삭제가 불가능하다.
    val list1 = listOf(10, 20, 30, 40, 50)
    println("list1 : $list1")

    val list2 = listOf("문자열1", "문자열2", "문자열3")
    println("list2 : $list2")

    val list3 = listOf(100, 11.11, "문자열", true)
    println("list3 : $list3")

    // 수정 가능한 리스트
    // ArrayList로 생성된다.
    val list4 = mutableListOf<Int>()
    val list5 = mutableListOf("문자열1", "문자열2", "문자열3")
    println("list4 : $list4")
    println("list5 : $list5")

    // 비어있는 수정 불가능한 리스트 -> 빈 리스트를 리턴해야하는 경우 요긴하게 사용
    val list6 = emptyList<Int>()
    println("list6 : $list6")

    // listOfNotNull : null값을 제외하고 생성한다.
    val list7 = listOf(10, 20, null, 40, null, 60, 70)
    val list8 = listOfNotNull(10, 20, null, 40, null, 60, 70)

    println("list7 : $list7")
    println("list8 : $list8")

    println("---------------------------------------------")

    // for 문 사용
    for(item in list1){
        println("item : $item")
    }

    // 개수
    println("list1 size : ${list1.size}")

    // 관리할 객체들(값들)이 있고 나중에 추가, 삭제 등을 하지 않을 경우 : arrayOf
    // 관리할 객체들(값들)이 없으며 나중에 추가, 삭제 등을 하는 경우 : ArrayList, mutableListOf
    // 관리할 객체들(값들)이 있고 나중에 추가, 삭제 등을 하는 경우 : mutableListOf
    // 관리할 객체들(값들)이 있고 나중에 추가, 삭제 등을 하지 않고 관리하는 값을 변경하지 못하게 강제하고자 할 때 : listOf

    println("-------------------------------------------------------")
    // 관리하는 객체(값)에 접근
    // [ ] 연산자를 통해 순서값(0부터 1씩 증가)를 지정하여 접근한다.
    println("list1 0 : ${list1[0]}")
    println("list1 1 : ${list1[1]}")

    println("---------------------------------------------------------")
    // 일부를 발췌하여 새로운 리스트로 생성한다.
    val list9 = listOf(10, 20, 30, 10, 20, 30)

    // 지정된 값이 앞에서 부터 몇 번째에 있는가
    val index1 = list9.indexOf(20)
    println("index1 : $index1")

    // 지정된 값이 뒤에서 부터 찾아서 앞에서 부터 몇 번째에 있는가
    val index2 = list9.lastIndexOf(20)
    println("index2 : $index2")

    // 일부를 발췌해 새로운 리스트로 만들어준다.
    // 순서 값 1 ~ 3 - 1 까지
    val list10 = list9.subList(1, 3)
    println("list10 : $list10")

    println("------------------------------------------------------")

    val list20 = listOf(10, 20, 30)
    val list21 = mutableListOf(10, 20, 30)

    // 수정 불가능한 리스트에 값 추가
    // 수정 불가능한 리스트에는 추가, 삭제, 수정, 삽입 등의 메서드가 없다.
    // list20.add(100)
    // list20[1] = 200

    // 수정이 가능한 리스트에 대한 추가, 수정, 삭제, 삽입
    // 추가
    list21.add(40)
    list21.add(50)
    list21.addAll(listOf(60, 70, 80, 90, 100))
    println("list21 : $list21")

    // 삽입
    // 순서값 1(두 번째)에 1000을 삽입하고 그 이후의 값들을 뒤로 밀린다.
    list21.add(1, 1000)
    println("list21 : $list21")

    // 순서값 3(네 번째)에 지정된 요소가 관리하는 값들을 모두 추가하고 그 이후의 값들은 뒤로 밀린다.
    list21.addAll(3, listOf(2000, 3000, 4000, 5000))
    println("list21 : $list21")

    // 제거
    // 지정된 값을 제거한다.
    list21.remove(1000)
    println("list21 : $list21")

    // 제거 하고자 하는 값이 같은 것이 여러개가 있다면 제일 앞쪽에는 값 하나만 제거한다.
    list21.add(1000)
    list21.add(1000)
    list21.add(1000)
    println("list21 : $list21")
    list21.remove(1000)
    println("list21 : $list21")

    // 없는 값을 제거
    // 아무 작업도 하지 않는다.
    list21.remove(10000)
    println("list21 : $list21")

    // 제거 하기 위해 지정한 것들을 모두 제거한다.
    list21.removeAll(listOf(2000, 3000, 4000, 5000))
    println("list21 : $list21")

    // removeAll을 통해 같은 값이 다수 저장되어 있는 것을 제거
    list21.removeAll(listOf(1000))
    println("list21 : $list21")

    // 위치를 지정하여 제거한다.
    // 두 번째 값을 제거한다.
    list21.removeAt(1)
    println("list21 : $list21")


    // 값을 수정한다.
    // 두 번째 값을 200으로 덮어 씌운다.
    list21.set(1, 200)
    println("list21 : $list21")

    list21[2] = 300
    println("list21 : $list21")

    println("--------------------------------------------")
    val list100 = listOf(10, 20, 30, 40, 50)

    // list 안에 저장되어 있는 객체(값)을 추출하여 mutableList로 생성하여 반환한다.
    val list200 = list100.toMutableList()
    list200.add(60)

    println("list100 : $list100")
    println("list200 : $list200")

    // mutableList 안에 저장되어 있는 객체(값)을 추출하여 list로 생성하여 반환한다.
    val list300 = list200.toList()
    // list300.add(70)



}