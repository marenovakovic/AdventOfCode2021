package day1

fun scan(measurements: List<Int>): Int =
    measurements
        .windowed(3)
        .zipWithNext { a, b -> if (b.sum() > a.sum()) 1 else 0 }
        .sum()

//fun scan(measurements: List<Int>): Int =
//    measurements
//        .windowed(4)
//        .count { it[0] < it[3] }