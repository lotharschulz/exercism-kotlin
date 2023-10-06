fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val result = this.toMutableList()
    list.forEach { result.add(it) }
    return result.toList()
}

fun List<*>.customConcat(): List<*> =
    customFoldLeft(emptyList<Any?>()) { acc, entity ->
        when (entity) {
            is List<*> -> acc.customAppend(entity.customConcat())
            else -> acc + entity
        }
    }

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> =
    customFoldLeft(emptyList()) { acc, entity ->
        when {
            predicate(entity) -> acc + entity
            else -> acc
        }
    }

val List<Any>.customSize: Int get() = this.size

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    val result = mutableListOf<U>()
    this.forEach { result.add(transform(it)) }
    return result.toList()
}

tailrec fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U =
    when (this) {
        emptyList<T>() -> initial
        else -> this.drop(1).customFoldLeft(f(initial, this.first()), f)
    }

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    var res = initial
    this.reversed().forEach { item ->
        res = f(item, res)
    }
    return res
}

fun <T> List<T>.customReverse(): List<T> =
    customFoldRight(mutableListOf()) { item, acc ->
        acc.add(item)
        acc
    }
