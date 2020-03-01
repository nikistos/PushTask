package filters
import system.*
import pushes.*

class OsVersionFilterAdapter(override var text: String, val os_version: Int) : Push {

    constructor(techPush: TechPush): this(techPush.text, techPush.os_version)

    override fun filteredForSystem(system: System): Boolean {
        var osVersionFilter = OsVersionFilter()
        return osVersionFilter.filtered(system,this)
    }
}

private class OsVersionFilter: Filter<OsVersionFilterAdapter> {
    override fun filtered(system: System, push: OsVersionFilterAdapter): Boolean {
        return system.os_version > push.os_version
    }
}