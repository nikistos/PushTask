package pushes
import system.*

interface Push {
    val text: String

    fun show() {
        println(text)
    }

    fun filteredForSystem(system: System): Boolean
}
