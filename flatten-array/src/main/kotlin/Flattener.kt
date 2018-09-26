object Flattener {
    fun flatten(nestedList: List<Any?>):List<Any?> {
        return nestedList.filterNotNull().flatMap{
            when(it){
                is List<*> -> flatten(it)
                else -> listOf(it)
            }
        }
    }
}