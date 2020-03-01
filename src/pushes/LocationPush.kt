package pushes
import filters.*
import system.*

class LocationPush(override val text: String, val x_coord: Float, val y_coord: Float, val radius: Int, val expiredDate: Long) : Push {

    override fun filteredForSystem(system: System): Boolean {
        var locationFilterAdapter = LocationFilterAdapter(this)
        var expiredDateFilterAdapter = ExpiredDateFilterAdapter(this)
        return locationFilterAdapter.filteredForSystem(system) || expiredDateFilterAdapter.filteredForSystem(system)
    }
}