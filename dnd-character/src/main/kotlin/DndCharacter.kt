import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = constitution()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = getHitpoints(constitution)

    companion object {
        fun constitution(): Int = Random.nextInt(3, 18)
        fun ability(): Int = Random.nextInt(3, 18)
        fun modifier(score: Int): Int = Math.floorDiv(score - 10, 2)
        fun getHitpoints(constitution: Int): Int = 10 + modifier(constitution)
    }
}
