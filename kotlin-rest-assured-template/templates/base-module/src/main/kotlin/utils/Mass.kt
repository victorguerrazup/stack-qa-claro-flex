package utils

import java.util.*
import kotlin.math.floor
import kotlin.math.roundToInt

class Mass {

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    private fun mod(dividend:Int, divider:Int) : Int {
        return ((dividend - (floor((dividend / divider).toDouble()) * divider)).roundToInt())
    }

    fun randomCPF() : String {
        val n1 = (0..9).random()
        val n2 = (0..9).random()
        val n3 = (0..9).random()
        val n4 = (0..9).random()
        val n5 = (0..9).random()
        val n6 = (0..9).random()
        val n7 = (0..9).random()
        val n8 = (0..9).random()
        val n9 = (0..9).random()
        var d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10

        d1 = 11 - (mod(d1, 11))
        if (d1 >= 10){
            d1 = 0
        }

        var d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11
        d2 = 11 - (mod(d2, 11))
        if (d2 >= 10){
            d2 = 0
        }

        return "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2
    }

    fun randomNumber(length:Int): String {
        var count = length
        var res = ""
        while (count > 0) {
            res+= (0..9).random()
            --count
        }
        return res
    }

    fun randomString(length:Int): String {
        var count = length
        var res = ""
        while (count > 0) {
            res+= ('a'..'z').random()
            --count
        }
        return res
    }

}