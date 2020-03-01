import system.*
import pushes.*


fun main(args: Array<String>) {
    val systemReader = SystemReader()
    val system = systemReader.getSystemFromConsole()
    val pushCount = readLine()?.toInt() ?: 0
    for (i in 0 until pushCount) {
        val pushReader = PushReader()
        system.addPush(pushReader.getPushFromConsole())
    }
    system.showPushes()
}

class SystemReader() : ConsoleObjectReader()
{
    fun getSystemFromConsole(): System {
        getParamsDictionary(paramsCount)
        return builtSystemFromDictionary()
    }

    private fun builtSystemFromDictionary(): System {
        val system = System()
        system.time = paramsDictionary["time"]?.toLong() ?: 0
        system.age = paramsDictionary["age"]?.toInt() ?: 0
        system.gender = Gender.valueOf(paramsDictionary["gender"] ?: "m")
        system.os_version = paramsDictionary["os_version"]?.toInt() ?: 0
        system.x_coord = paramsDictionary["x_coord"]?.toFloat() ?: 0F
        system.y_coord = paramsDictionary["y_coord"]?.toFloat() ?: 0F
        return system
    }

    companion object {
        const val paramsCount = 6
    }
}

class PushReader() : ConsoleObjectReader() {

    fun getPushFromConsole(): Push {
        val paramsCount = readLine()?.toInt() ?: 0
        getParamsDictionary(paramsCount)
        return builtPushFromDictionary()
    }

    private fun builtPushFromDictionary(): Push {
        return when(paramsDictionary["type"]) {
            "AgeSpecificPush" -> {
                AgeSpecificPush(paramsDictionary["text"]!!, paramsDictionary["age"]!!.toInt(), paramsDictionary["expiry_date"]!!.toLong())
            }
            "GenderAgePush" -> {
                GenderAgePush(paramsDictionary["text"]!!, Gender.valueOf(paramsDictionary["gender"]!!), paramsDictionary["age"]!!.toInt())
            }
            "GenderPush" -> {
                GenderPush(paramsDictionary["text"]!!, Gender.valueOf(paramsDictionary["gender"]!!))
            }
            "LocationAgePush" -> {
                LocationAgePush(paramsDictionary["text"]!!, paramsDictionary["x_coord"]!!.toFloat(), paramsDictionary["y_coord"]!!.toFloat(), paramsDictionary["radius"]!!.toInt(), paramsDictionary["age"]!!.toInt())
            }
            "LocationPush" -> {
                LocationPush(paramsDictionary["text"]!!, paramsDictionary["x_coord"]!!.toFloat(), paramsDictionary["y_coord"]!!.toFloat(), paramsDictionary["radius"]!!.toInt(), paramsDictionary["expiry_date"]!!.toLong())
            }
            "TechPush" -> {
                TechPush(paramsDictionary["text"]!!, paramsDictionary["os_version"]!!.toInt())
            }
            else -> throw Exception("Unknown push type: [${paramsDictionary["type"]}]")
        }
    }
}

open class ConsoleObjectReader() {

    internal val paramsDictionary = mutableMapOf<String, String>()

    internal fun getParamsDictionary(paramCount: Int) {
        for (i in 0 until paramCount) {
            val input = readLine()?.split(' ') ?: arrayListOf("invalidParam", "invalidValue")
            val paramName = input[0]
            val paramValue = input[1]
            paramsDictionary[paramName] = paramValue
        }
    }
}