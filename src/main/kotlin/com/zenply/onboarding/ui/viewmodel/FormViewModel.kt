package com.zenply.onboarding.ui.viewmodel

import com.zenply.onboarding.domain.validation.RutValidator

data class FormState(
    val nombre: String = "",
    val rut: String = "",
    val email: String = "",
    val isNextEnabled: Boolean = false
)

class FormViewModel {
    var state: FormState = FormState()
        private set
    fun updateNombre(value: String) { state = state.copy(nombre = value); validateForm() }
    fun updateRut(value: String) { state = state.copy(rut = value); validateForm() }
    fun updateEmail(value: String) { state = state.copy(email = value); validateForm() }
    private fun validateForm() {
        val valid = state.nombre.isNotBlank() &&
            RutValidator.validate(state.rut) &&
            state.email.isNotBlank() &&
            state.email.contains("@")
        state = state.copy(isNextEnabled = valid)
    }
}
