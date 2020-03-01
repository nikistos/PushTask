package filters
import system.*
import pushes.*
import kotlin.math.sqrt

class LocationFilterAdapter(override var text: String, val x_coord: Float, val y_coord: Float, val radius: Int): Push {

    constructor(locationPush: LocationPush): this(locationPush.text, locationPush.x_coord, locationPush.y_coord, locationPush.radius)
    constructor(locationAgePush: LocationAgePush): this(locationAgePush.text, locationAgePush.x_coord, locationAgePush.y_coord, locationAgePush.radius)

    override fun filteredForSystem(system: System): Boolean {
        var locationFilter = LocationFilter()
        return locationFilter.filtered(system, this)
    }
}

private class LocationFilter(): Filter<LocationFilterAdapter> {
    override fun filtered(system: System, push: LocationFilterAdapter): Boolean {
        var x1 = system.x_coord
        var x2 = push.x_coord
        var y1 = system.y_coord
        var y2 = push.y_coord
        return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) > push.radius
    }
}