package pushes
import filters.*
import system.*

class LocationAgePush(override val text: String, val x_coord: Float, val y_coord: Float, val radius: Int, val age: Int) : Push {

    override fun filteredForSystem(system: System): Boolean {
        var locationFilterAdapter = LocationFilterAdapter(this)
        var ageFilterAdapter = AgeFilterAdapter(this)
        return locationFilterAdapter.filteredForSystem(system) || ageFilterAdapter.filteredForSystem(system)
    }
}