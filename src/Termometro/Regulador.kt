package Termometro

import Calentador.Calentador
import TempHabitacion.TempHabitacion

class Regulador private constructor() {
    private var maxTemp: Double = 0.0
    private var minTemp: Double = 0.0

    companion object{
        private var instance: Regulador? = null

        fun getInstance(): Regulador{
            if(instance == null){
                instance = Regulador()
            }
            return instance!!
        }
    }

    fun setMax(maxTemp: Double){
        this.maxTemp = maxTemp
    }
    fun getMaxTemp(): Double {
        return maxTemp
    }

    fun setMin(minTemp: Double){
        this.minTemp = minTemp
    }

    fun getMinTemp(): Double {
        return minTemp
    }

    fun calibrarTemp(termometro : Termometro,  tempActual: TempHabitacion){
        if (termometro.leerTemp(tempActual) > maxTemp || termometro.leerTemp(tempActual) < minTemp){
            println("""
                (!) TEMPERATURA FUERA DEL RANGO (!)
                Calibrando...
                Temperatura reestablecida a: ${tempPromedio(maxTemp, minTemp)}
            """.trimIndent())
            tempActual.setTempActual(tempPromedio(maxTemp, minTemp))
        } else {
            println("""
                Temperatura dentro del rango permitido, no hay nada que hacer.
            """.trimIndent())
        }
    }

    fun tempPromedio(maxTemp: Double, minTemp: Double):Double{
        return (maxTemp + minTemp) / 2
    }
}