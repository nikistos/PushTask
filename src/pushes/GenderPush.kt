package pushes
import system.*
import filters.*

class GenderPush(override val text: String, val gender: Gender) : Push {

    override fun filteredForSystem(system: System): Boolean {
        var genderFilterAdapter = GenderFilterAdapter(this)
        return genderFilterAdapter.filteredForSystem(system)
    }
}