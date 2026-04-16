package com.zenply.onboarding.ui.navigation

import org.junit.Assert.*
import org.junit.Test

class NavigationTest {
    @Test fun `navigation has exactly 3 routes`() { assertEquals(3, NavigationRoutes.orderedRoutes.size) }
    @Test fun `start destination is FormularioDatos`() { assertEquals(NavigationRoutes.FORMULARIO_DATOS, NavigationRoutes.startDestination) }
    @Test fun `routes are in correct sequential order`() { val r = NavigationRoutes.orderedRoutes; assertEquals(NavigationRoutes.FORMULARIO_DATOS, r[0]); assertEquals(NavigationRoutes.CAPTURAR_FOTO, r[1]); assertEquals(NavigationRoutes.REVISION, r[2]) }
    @Test fun `each route has a unique path`() { val p = NavigationRoutes.orderedRoutes.map { it.route }; assertEquals(p.size, p.toSet().size) }
}
