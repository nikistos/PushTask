package pushes
import filters.*
import system.*

class AgeSpecificPush(override var text: String, var age: Int, var expiredDate: Long) : Push {

    override fun filteredForSystem(system: System): Boolean {
        var ageFilterAdapter = AgeFilterAdapter(this)
        var expiredDateFilterAdapter = ExpiredDateFilterAdapter(this)
        return ageFilterAdapter.filteredForSystem(system) || expiredDateFilterAdapter.filteredForSystem(system)
    }
}