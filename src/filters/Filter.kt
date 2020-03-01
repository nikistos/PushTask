package filters
import system.*
import pushes.*

interface Filter<T:Push> {
    fun filtered(system: System, push: T): Boolean
}
