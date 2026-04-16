package com.zenply.onboarding.domain.service

import com.zenply.onboarding.domain.model.Decision
import com.zenply.onboarding.domain.model.OnboardingData
import org.junit.Assert.*
import org.junit.Test

class FacialAnalysisServiceTest {
    @Test
    fun `caso aprobado returns score gte 80 and decision aprobado`() {
        val data = OnboardingData(nombre = "Juan Aprobado", rut = "12.345.678-5", email = "juan@test.com")
        val result = FacialAnalysisService.analyze(data)
        assertTrue("Score should be >= 80 but was ${result.score}", result.score >= 80)
        assertEquals(Decision.Aprobado, result.decision)
        assertEquals("aprobado", result.decision.label)
    }
    @Test
    fun `caso revision returns score 40-79 and decision revision_manual`() {
        val data = OnboardingData(nombre = "Maria Revision", rut = "11.111.111-1", email = "maria@test.com")
        val result = FacialAnalysisService.analyze(data)
        assertTrue("Score should be >= 40 but was ${result.score}", result.score >= 40)
        assertTrue("Score should be < 80 but was ${result.score}", result.score < 80)
        assertEquals(Decision.RevisionManual, result.decision)
        assertEquals("revision_manual", result.decision.label)
    }
    @Test
    fun `caso rechazado returns score lt 40 and decision rechazado`() {
        val data = OnboardingData(nombre = "Pedro Rechazado", rut = "15.776.862-K", email = "pedro@test.com")
        val result = FacialAnalysisService.analyze(data)
        assertTrue("Score should be < 40 but was ${result.score}", result.score < 40)
        assertEquals(Decision.Rechazado, result.decision)
        assertEquals("rechazado", result.decision.label)
    }
}
