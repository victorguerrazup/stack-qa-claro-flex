package utils

import net.datafaker.Faker
import java.util.*
import kotlin.math.floor
import kotlin.math.roundToInt

class Mass {

    private var faker = Faker()

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    fun randomCPF() : String {
        return faker.cpf().valid(false)
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

    fun randomName(): String {
        return faker.name().fullName()
    }

    fun randomCreditCard(): CreditCard {
        var creditCard = CreditCard()
        creditCard.number = faker.business().creditCardNumber().replace("-", "")
        var expiry = faker.business().creditCardExpiry().split("-")
        creditCard.expiryMonth = expiry[1]
        creditCard.expiryYear = expiry[0]
        creditCard.securityCode = faker.business().securityCode()
        return creditCard
    }

}

class CreditCard {
    var number: String? = null
    var expiryMonth: String? = null
    var expiryYear: String? = null
    var securityCode: String? = null
}