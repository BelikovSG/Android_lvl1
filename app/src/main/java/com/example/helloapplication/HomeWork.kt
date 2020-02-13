package com.example.helloapplication


var map = LinkedHashMap<String, Int>()

fun main(){


    println("Введите чило")
    val quantity : Int? = readLine()?.toIntOrNull()
    quantity?.let { println("Введите числа в колличестве $it") }
    val list = quantity?.let { makeList(it) }


    println("Положительные чила:")
    list?.forEach { if (it >= 0) println("$it")}

    println("Четные числа:")
    list?.filter { it%2 == 0 }.let { it?.forEach { println("$it") } }

    println("Количество не повроторядющихся чисела:")
    list?.toSet().let {  println("${it?.size}") }

    println("Сумма всех чисел:")
    println(list?.sum())

    println("Поиск НОД без рекурсии:")
    list?.forEach { println("Наибольший общий делитель для ${list.sum()} и $it - ${greatestСommonFactor(list.sum(), it)}")}

    println("Поиск НОД с рекурсией:")
    list?.forEach { println("Наибольший общий делитель для ${list.sum()} и $it - ${recursedGreatestСommonFactor(list.sum(), it, it)}")}


}

fun makeList(n : Int) : ArrayList<Int>{
    val arrayList = ArrayList<Int>()
    var temp : Int?
    for (i in 1 .. n){
        temp = readLine()?.toIntOrNull()
        temp?.let { arrayList.add(it) }
    }
    return arrayList
}

fun greatestСommonFactor(a : Int, b : Int) : Int{
     val small = if (a > b) b else a
     val big = if (a > b) a else b
    for (n in small downTo 1){
        if (big % n == 0 && small % n == 0) {
            println("Печать чисел с НОД в формате: Число <>, сумма <>, НОД <>")
            map.put("Число", small)
            map.put("Сумма", big)
            map.put("НОД", n)
            println(map)
            return n
        }
    }
    return 1
}

tailrec fun recursedGreatestСommonFactor(sum : Int, num : Int, smallestNumber : Int) : Int{
    if (sum % smallestNumber == 0 && num % smallestNumber == 0) {
        return smallestNumber
    }
    return recursedGreatestСommonFactor(sum, num, smallestNumber - 1)
    }
