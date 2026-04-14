package com.machbank.onboarding.domain.validation

import org.junit.Assert.*
import org.junit.Test

class RutValidatorTest {
    @Test fun `valid RUT 12345678-5 returns true`() { assertTrue(RutValidator.validate("12.345.678-5")) }
    @Test fun `valid RUT 11111111-1 returns true`() { assertTrue(RutValidator.validate("11.111.111-1")) }
    @Test fun `valid RUT with K digit returns true`() { assertTrue(RutValidator.validate("15.776.862-K")) }
    @Test fun `valid RUT without dots returns true`() { assertTrue(RutValidator.validate("12345678-5")) }
    @Test fun `valid RUT with lowercase k returns true`() { assertTrue(RutValidator.validate("15.776.862-k")) }
    @Test fun `invalid RUT wrong check digit returns false`() { assertFalse(RutValidator.validate("12.345.678-0")) }
    @Test fun `invalid RUT garbage format returns false`() { assertFalse(RutValidator.validate("abc")) }
    @Test fun `empty string returns false`() { assertFalse(RutValidator.validate("")) }
}
