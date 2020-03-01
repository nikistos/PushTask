package filters
import system.*
import pushes.*

class AgeFilterAdapter(override val text: String, val age: Int): Push {

    constructor(ageSpecificPush: AgeSpecificPush): this(ageSpecificPush.text, ageSpecificPush.age)
    constructor(genderAgePush: GenderAgePush): this(genderAgePush.text, genderAgePush.age)
    constructor(locationAgePush: LocationAgePush): this(locationAgePush.text, locationAgePush.age)

    override fun filteredForSystem(system: System): Boolean {
        var ageFilter = AgeFilter()
        return ageFilter.filtered(system, this)
    }
}

private class AgeFilter: Filter<AgeFilterAdapter> {
    override fun filtered(system: System, push: AgeFilterAdapter): Boolean {
        return push.age > system.age
    }
}
