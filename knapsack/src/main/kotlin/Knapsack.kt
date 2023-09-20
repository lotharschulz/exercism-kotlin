data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    if (maximumWeight == 0) {
        return 0
    }
    var maxValue = 0
    items.filter { it.weight <= maximumWeight }.forEachIndexed { index, item ->
        val subList = items.subList(0, index) + items.subList(index + 1, items.size)
        val attempt = item.value + knapsack(maximumWeight - item.weight, subList)
        maxValue = maxOf(maxValue, attempt)
    }
    return maxValue
}
