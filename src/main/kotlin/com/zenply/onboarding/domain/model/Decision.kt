package com.zenply.onboarding.domain.model

sealed class Decision(val label: String) {
    object Aprobado : Decision("aprobado")
    object RevisionManual : Decision("revision_manual")
    object Rechazado : Decision("rechazado")
}
