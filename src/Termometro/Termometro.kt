package Termometro
import TempHabitacion.TempHabitacion

interface Termometro {
    fun leerTemp(tempActual: TempHabitacion): Double
    fun mostrarTemp(tempActual: TempHabitacion)
}