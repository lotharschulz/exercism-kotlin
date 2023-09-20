data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    if (maximumWeight == 0) {
        return 0
    }
    var maxValue = 0
    items.filter { it.weight <= maximumWeight }.forEach { item ->
        val subList = items.toList().filter { it != item }
        val attempt = item.value + knapsack(maximumWeight - item.weight, subList)
        maxValue = maxOf(maxValue, attempt)
    }
    return maxValue
}
