enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(other: List<E>):Relationship = when {
        this == other -> Relationship.EQUAL
        other.isEmpty() || this.windowed(other.size).contains(other) -> Relationship.SUPERLIST
        this.isEmpty() || other.windowed(this.size).contains(this) -> Relationship.SUBLIST
        else -> Relationship.UNEQUAL
    }


