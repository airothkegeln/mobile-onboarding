# Zenply - Onboarding App

App Android (Kotlin) para onboarding de clientes nuevos.

## Flujo
1. Formulario de Datos (nombre, RUT modulo 11, email)
2. Captura de Foto
3. Revision y Resultado (analisis facial simulado)

## Tests
```bash
./gradlew test
```

## Casos de prueba
| Caso | Nombre | RUT | Score | Decision |
|------|--------|-----|-------|----------|
| Aprobado | Juan Aprobado | 12.345.678-5 | 92 | aprobado |
| Revision | Maria Revision | 11.111.111-1 | 55 | revision_manual |
| Rechazado | Pedro Rechazado | 15.776.862-K | 25 | rechazado |

## Requisitos
- JDK 17+
