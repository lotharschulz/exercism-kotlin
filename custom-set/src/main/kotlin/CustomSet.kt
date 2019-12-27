class CustomSet (vararg ds: Int){
    private val d = mutableListOf<Int>()
    init { d.addAll(ds.distinct()) }

    fun isEmpty(): Boolean = d.isEmpty()
    fun isSubset(other: CustomSet): Boolean = d.all { other.contains(it) }
    fun isDisjoint(other: CustomSet): Boolean = this.isEmpty() || this.intersection(other).isEmpty()
    fun contains(other: Int): Boolean = d.contains(other)
    fun intersection(other: CustomSet): CustomSet = CustomSet(*(this.d.filter { other.sData().contains(it) }.toIntArray()))
    fun add(other: Int) { if (!d.contains(other)) d.add(other) }
    override fun equals(other: Any?): Boolean = if (other !is CustomSet) false else this.sData().toIntArray() contentEquals other.sData().toIntArray()
    operator fun plus(other: CustomSet): CustomSet = CustomSet(*((sData() + other.sData()).distinct().toIntArray()))
    operator fun minus(other: CustomSet): CustomSet = CustomSet(*((sData() - other.sData()).toIntArray()))

    private fun sData(): List<Int> = d.toList().sorted()
}
