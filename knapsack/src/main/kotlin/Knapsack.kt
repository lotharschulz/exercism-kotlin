data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    val sortedItems = items.sortedWith(compareBy({ it.value }, { it.value })).reversed()

    /*
    println("sortedItems: $sortedItems")
    sortedItems.forEachIndexed { index, item ->
        val aggregatedSublistWeight = sortedItems.subList(0, index).map { it.weight }.sum()
        val aggregatedSublistValue = sortedItems.subList(0, index).map { it.value }.sum()
        println("aggregatedSublistWeight: $aggregatedSublistWeight")
        println("aggregatedSublistValue: $aggregatedSublistValue")
        if ()
    }
    */
    var aggregatedWeight = 0
    var aggregatedValue = 0
    for(item in sortedItems) {
        aggregatedWeight += item.weight
        aggregatedValue += item.value
        if (aggregatedWeight > maximumWeight) {
            return aggregatedValue - item.value
        }
    }
    return 0
}
