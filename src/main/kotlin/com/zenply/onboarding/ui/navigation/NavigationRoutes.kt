package com.zenply.onboarding.ui.navigation

enum class NavigationRoutes(val route: String) {
    FORMULARIO_DATOS("formulario_datos"),
    CAPTURAR_FOTO("capturar_foto"),
    REVISION("revision");
    companion object {
        val orderedRoutes = listOf(FORMULARIO_DATOS, CAPTURAR_FOTO, REVISION)
        val startDestination = FORMULARIO_DATOS
    }
}
