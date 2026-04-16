package com.zenply.onboarding.domain.model

data class OnboardingData(
    val nombre: String,
    val rut: String,
    val email: String,
    val photoUri: String? = null
)
