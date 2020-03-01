package filters
import system.*
import pushes.*

class GenderFilterAdapter(override val text: String, val gender: Gender): Push {

    constructor(genderPush: GenderPush): this(genderPush.text, genderPush.gender)
    constructor(genderAgePush: GenderAgePush): this(genderAgePush.text, genderAgePush.gender)

    override fun filteredForSystem(system: System): Boolean {
        var genderFilter = GenderFilter()
        return genderFilter.filtered(system, this)
    }
}

private class GenderFilter(): Filter<GenderFilterAdapter>{
    override fun filtered(system: System, push: GenderFilterAdapter): Boolean {
        return system.gender != push.gender
    }
}