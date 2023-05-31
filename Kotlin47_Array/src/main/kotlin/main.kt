fun main(){
    // 배열 생성 -> 시작 시 길이 고정, 변경 불가
    // 배열이 관리할 값들을 넣어준다.
    val array1 = arrayOf(10, 20, 30, 40, 50)
    println("array1 : $array1")
    // 배열이 관리하는 값들을 출력할 수 있다.
    println("array1 : ${array1.contentToString()}")

    // 배열은 다양한 타입의 값을 담을 수 있다.
    val array2  = arrayOf(100, 11.11, "문자열", true)
    println("array2 : ${array2.contentToString()}")

    // 특정 타입의 값만 담는 배열을 생성한다.
    val array3 = intArrayOf(10, 20, 30, 40, 50)
    val array4 = doubleArrayOf(11.11, 22.22, 33.33, 44.44, 55.55)
    val array5 = arrayOf<String>("문자열1", "문자열2", "문자열3")

    println("array3 : ${array3.contentToString()}")
    println("array4 : ${array4.contentToString()}")
    println("array5 : ${array5.contentToString()}")

    // 람다식을 통한 배열 생성
    // 람다식 코드를 수행하여 제일 마지막에 작성되어 있는 값을 배열의 요소로 담아준다.
    // CUZ 람다식은 맨 마지막에 작성된 식을 return 으로 가져오기 때문!!
    // 특정 식을 통해 계산된 결과나 패턴을 가지는 배열을 만들 때 사용한다
    // 0 이 5개 들어 있는 배열 생성
    val array6 = Array(5) {
        0
    }
    println("array6 : ${array6.contentToString()}")

    // it 사용
    // it 에는 0 부터 1씩 증가되는 값이 들어온다.
    val array7 = Array(5){
        it
    }
    println("array7 : ${array7.contentToString()}")

    // 특정 패턴을 가진 값을 가지는 배열
    // 3의 배수
    val array8 = Array(10){
        (it + 1) * 3
    }
    println("array8 : ${array8.contentToString()}")

    println("-----------------------------------------")
    // 배열의 값을 처음 부터 끝까지 순회한다.
    for(item in array1){
        println("item : $item")
    }

    println("-----------------------------------------")
    // 다 차원 배열 만들기
    val array9 = arrayOf(
        arrayOf(10, 20, 30),
        arrayOf(40, 50, 60),
        arrayOf(70, 80, 90)
    )
    println("array9 : $array9")
    println("array9 : ${array9.contentToString()}")
    println("array9 : ${array9.contentDeepToString()}")

    for(item in array9){
        for(item2 in item){
            println("item2 : $item2")
        }
    }

    println("-------------------------------------------")
    // 배열 요소에 접근한다
    // 0 부터 1씩 증가되는 값을 사용한다.
    println("array1 0 : ${array1[0]}")
    println("array1 1 : ${array1[1]}")
    // get 메서드를 통해서 가져올 수도 있다.
    // [ ] 연산자를 사용하면 get 메서드를 호출해서 값을 가져오는 것이므로
    // [ ] 연산자를 사용하는 것과 동일하다.
    println("array1.get(0) : ${array1.get(0)}")
    println("array1.get(1) : ${array1.get(1)}")

    println("----------------------------------------------------")

    // 새로운 값을 저장한다.
    println("array1 : ${array1.contentToString()}")

    array1[0] = 100
    println("array1 : ${array1.contentToString()}")

    array1.set(1, 200)
    println("array1 : ${array1.contentToString()}")

    println("---------------------------------------------------")

    // 배열이 관리하는 값의 개수
    println("array1 size : ${array1.size}")

    println("---------------------------------------------------")

    // 배열에 요소 추가
    // 새로운 배열이 생성된다.
    println("array1 : ${array1.contentToString()}")

    val array10 = array1.plus(60)
    println("array1 : ${array1.contentToString()}")
    println("array10 : ${array10.contentToString()}")

    println("---------------------------------------------------")

    // 일부를 가져온다.
    // 배열에서 지정된 부분의 값을 추출해 새로운 배열로 만들어 반환한다.
    // 순서값 1 ~ 3까지 (두 번째 ~ 네 번째)
    val array11 = array1.sliceArray(1..3)
    println("array1 : ${array11.contentToString()}")

    println("-----------------------------------------------------")
    // 배열이 제공하는 다양한 메서드들
    println("첫 번째 값 : ${array1.first()}")
    println("마지막 값 : ${array1.last()}")
    println("30의 위치 : ${array1.indexOf(30)}")
    println("평균 : ${array1.average()}")
    println("합 : ${array1.sum()}")
    println("개수 : ${array1.count()}")
    println("개수 : ${array1.size}")
    println("30을 포함하는 가 : ${array1.contains(30)}")
    println("1000을 포함하는 가 : ${array1.contains(1000)}")
    println("30을 포함하는가 : ${30 in array1}")
    println("1000을 포함하는 가 : ${1000 in array1}")
    println("최대 : ${array1.maxOrNull()}")
    println("최소 : ${array1.minOrNull()}")

    println("-----------------------------------------------------")
    // 정렬
    // 값이 정렬된 새로운 배열을 생성한다.
    val array12 = arrayOf(5, 1, 3, 7, 10, 8)
    // 오름 차순 정렬
    val array13 = array12.sortedArray()
    // 내림 차순 정렬
    val array14 = array12.sortedArrayDescending()

    println("array12 : ${array12.contentToString()}")
    println("array13 : ${array13.contentToString()}")
    println("array14 : ${array14.contentToString()}")
}
