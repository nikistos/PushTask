package pushes
import filters.AgeFilterAdapter
import filters.GenderFilterAdapter
import system.*

class GenderAgePush(override val text: String, val gender: Gender, val age: Int) : Push {

    override fun filteredForSystem(system: System): Boolean {
        var genderFilterAdapter = GenderFilterAdapter(this)
        var ageFilterAdapter = AgeFilterAdapter(this)
        return genderFilterAdapter.filteredForSystem(system) || ageFilterAdapter.filteredForSystem(system)
    }
}