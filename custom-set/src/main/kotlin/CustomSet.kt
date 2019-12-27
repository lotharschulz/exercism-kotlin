import java.util.HashMap

class CustomSet (vararg xs: Int){

    private val container = hashMapOf<Int, Int>()
    //private val Object PRESENT = new Object();

    init {
        for (x in xs){
            container[x] = x
        }
    }

    fun isEmpty(): Boolean {
        return container.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        for (x in container){
            if (!other.contains(x.value)){
                return false
            }
        }
        return true
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return this.isEmpty() || this.intersection(other).isEmpty()
    }

    fun contains(other: Int): Boolean {
        return container.containsValue(other)
    }

    private fun keys():Set<*>{
        return container.keys
    }

    fun intersection(other: CustomSet): CustomSet {
        if (this.container.isEmpty()) return CustomSet()
        val intersectionContainer = mutableMapOf<Int, Int> ()
        for (k in other.keys()){
            if (k is Int && this.contains(k)){
                intersectionContainer[k] = k
            }
        }
        return CustomSet(*(intersectionContainer.keys.toIntArray()))
    }

    fun add(other: Int) {
        container[other] = other
    }

    override fun equals(other: Any?): Boolean {
        val o = other as CustomSet
        if (o.keys().size != this.keys().size) return false
        for (x in container.keys){
            if (!o.container.contains(x)) return false
        }
        return true
}

operator fun plus(other: CustomSet): CustomSet {
val addContainer = container.toMutableMap<Int, Int> ()
for (x in other.keys()){
    if (x is Int) {
        if (!addContainer.contains(x)) {
            addContainer[x] = x
        }
    }
}
return CustomSet(*(addContainer.keys.toIntArray()))
}

operator fun minus(other: CustomSet): CustomSet {
val minContainer = container.toMutableMap<Int, Int> ()
for (x in other.keys()){
    if (x is Int && minContainer.contains(x)) {
        minContainer.remove(x)
    }
}
return CustomSet(*(minContainer.keys.toIntArray()))
}
}
