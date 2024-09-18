package Calentador
import java.util.Scanner
import TempHabitacion.TempHabitacion

class CalentadorGas : Calentador {
    var input = Scanner(System.`in`)

    override fun ajustarTemp(tempActual: TempHabitacion) {
        var continuar = true

        while (continuar){
            println("""
                (i) Seleccione una opción:
                1. Aumentar temperatura (+2'C)
                0. Atrás
            """.trimIndent())

            var opcion: Int = input.nextInt()

            when (opcion) {
                1 -> {
                    tempActual.setTempActual(tempActual.getTempActual() + 2)
                    println("""
                        .:: Temperatura aumentada, +2'C
                        --------------------------------
                        TempActusl: ${tempActual.getTempActual()}'C
                    """.trimIndent())
                }
                0 -> {
                    println(".:: Regresando al menú principal")
                    continuar = false
                }
                else -> {
                    println("Seleccione una opción válida")
                }
            }
        }
    }
}