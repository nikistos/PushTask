package system
import pushes.*

class System (var time: Long = 0,
              var age: Int = 0,
              var gender: Gender = Gender.m,
              var os_version: Int = 0,
              var x_coord: Float = 0F,
              var y_coord: Float = 0F,
              var pushesToShow: MutableList<Push> = emptyList<Push>().toMutableList()) {

    fun addPush(push: Push) {
        if (!push.filteredForSystem(this)) {
            pushesToShow.add(push)
        }
    }

    fun showPushes() {
        if (pushesToShow.count() == 0) {
            println(-1)
        }
        for(push in pushesToShow) {
            push.show()
        }
    }
}

enum class Gender
{
    f,
    m
}