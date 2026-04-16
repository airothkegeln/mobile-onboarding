package com.zenply.onboarding.domain.validation

object RutValidator {
    fun validate(rut: String): Boolean {
        val cleaned = rut.replace(".", "").replace("-", "").uppercase()
        if (cleaned.length < 2) return false
        val body = cleaned.dropLast(1)
        val checkDigit = cleaned.last()
        if (!body.all { it.isDigit() }) return false
        if (checkDigit != 'K' && !checkDigit.isDigit()) return false
        val multipliers = intArrayOf(2, 3, 4, 5, 6, 7)
        var sum = 0
        var idx = 0
        for (i in body.length - 1 downTo 0) {
            sum += (body[i] - '0') * multipliers[idx % 6]
            idx++
        }
        val remainder = sum % 11
        val expected = when (val diff = 11 - remainder) {
            11 -> '0'
            10 -> 'K'
            else -> ('0' + diff)
        }
        return checkDigit == expected
    }
}
