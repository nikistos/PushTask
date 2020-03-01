package pushes

import system.*
import filters.*

class TechPush(override val text: String, val os_version: Int) : Push {
    override fun filteredForSystem(system: System): Boolean {
        var osVersionFilterAdapter = OsVersionFilterAdapter(this)
        return osVersionFilterAdapter.filteredForSystem(system)
    }
}