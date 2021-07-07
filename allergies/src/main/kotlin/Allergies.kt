class Allergies(private val totalScore: Int) {
    fun getList(): List<Allergen> = Allergen.values().filter{ isAllergicTo(it) }
    fun isAllergicTo(allergen: Allergen):Boolean = totalScore and allergen.score != 0
}
