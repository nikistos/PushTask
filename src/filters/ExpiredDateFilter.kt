package filters
import system.*
import pushes.*

class ExpiredDateFilterAdapter(override val text: String, val expiredDate: Long) : Push {

    constructor(locationPush: LocationPush): this(locationPush.text, locationPush.expiredDate)
    constructor(ageSpecificPush: AgeSpecificPush): this(ageSpecificPush.text, ageSpecificPush.expiredDate)

    override fun filteredForSystem(system: System): Boolean {
        var expiryDateFilter = ExpiryDateFilter()
        return expiryDateFilter.filtered(system, this)
    }
}

private class ExpiryDateFilter : Filter<ExpiredDateFilterAdapter> {
    override fun filtered(system: System, push: ExpiredDateFilterAdapter): Boolean {
        return push.expiredDate < system.time
    }
}