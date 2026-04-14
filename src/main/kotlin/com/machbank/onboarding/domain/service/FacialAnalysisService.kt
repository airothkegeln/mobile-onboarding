package com.machbank.onboarding.domain.service

import com.machbank.onboarding.domain.model.Decision
import com.machbank.onboarding.domain.model.FacialResult
import com.machbank.onboarding.domain.model.OnboardingData

object FacialAnalysisService {
    private data class TestCase(val nombre: String, val rut: String, val score: Int)
    private val testCases = listOf(
        TestCase("Juan Aprobado", "123456785", 92),
        TestCase("Maria Revision", "111111111", 55),
        TestCase("Pedro Rechazado", "15776862K", 25)
    )
    fun analyze(data: OnboardingData): FacialResult {
        val normalizedRut = data.rut.replace(".", "").replace("-", "").uppercase()
        val matched = testCases.find { it.nombre == data.nombre && it.rut == normalizedRut }
        val score = matched?.score ?: ((data.nombre.hashCode() and 0x7FFFFFFF) % 100)
        val decision = when {
            score >= 80 -> Decision.Aprobado
            score >= 40 -> Decision.RevisionManual
            else -> Decision.Rechazado
        }
        return FacialResult(score = score, decision = decision)
    }
}
