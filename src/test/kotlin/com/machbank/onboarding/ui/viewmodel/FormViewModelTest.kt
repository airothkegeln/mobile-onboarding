package com.machbank.onboarding.ui.viewmodel

import org.junit.Assert.*
import org.junit.Test

class FormViewModelTest {
    @Test fun `next button is disabled with empty fields`() { assertFalse(FormViewModel().state.isNextEnabled) }
    @Test fun `next button is disabled with partial fields`() { val vm = FormViewModel(); vm.updateNombre("Juan"); assertFalse(vm.state.isNextEnabled) }
    @Test fun `next button is disabled with invalid RUT`() { val vm = FormViewModel(); vm.updateNombre("Juan"); vm.updateRut("12.345.678-0"); vm.updateEmail("j@t.com"); assertFalse(vm.state.isNextEnabled) }
    @Test fun `next button is enabled with all valid fields`() { val vm = FormViewModel(); vm.updateNombre("Juan"); vm.updateRut("12.345.678-5"); vm.updateEmail("j@t.com"); assertTrue(vm.state.isNextEnabled) }
    @Test fun `next button is disabled with invalid email`() { val vm = FormViewModel(); vm.updateNombre("Juan"); vm.updateRut("12.345.678-5"); vm.updateEmail("nope"); assertFalse(vm.state.isNextEnabled) }
    @Test fun `next button becomes disabled when valid field is cleared`() { val vm = FormViewModel(); vm.updateNombre("Juan"); vm.updateRut("12.345.678-5"); vm.updateEmail("j@t.com"); assertTrue(vm.state.isNextEnabled); vm.updateNombre(""); assertFalse(vm.state.isNextEnabled) }
}
