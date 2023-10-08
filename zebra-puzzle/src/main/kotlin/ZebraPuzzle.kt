class ZebraPuzzle() {
    enum class Color {
        YELLOW, BLUE, RED, IVORY, GREEN
    }

    enum class Drink {
        WATER, TEA, MILK, ORANGE_JUICE, COFFEE
    }

    enum class Smoke {
        KOOLS, CHESTERFIELD, OLD_GOLD, LUCKY_STRIKE, PARLIAMENT
    }

    enum class Pet {
        FOX, HORSE, SNAILS, DOG, ZEBRA
    }

    enum class Nationality(val who: String) {
        NORWEGIAN("Norwegian"),
        UKRAINIAN("Ukranian"),
        ENGLISHMAN("Englishman"),
        SPANIARD("Spaniard"),
        JAPANESE("Japanese"),
    }

    fun drinksWater(): String = solution.nationalities[solution.drinks.indexOf(Drink.WATER)].who

    fun ownsZebra(): String = solution.nationalities[solution.pets.indexOf(Pet.ZEBRA)].who

    data class Solution(
        val colors: List<Color>,
        val nationalities: List<Nationality>,
        val pets: List<Pet>,
        val drinks: List<Drink>,
        val smokes: List<Smoke>,
    )

    private val solution: Solution = let {
        permutations<Color>()
            .filter { it.colorRules() }
            .flatMap { colors ->
                permutations<Nationality>()
                    .filter { it.nationalityRules(colors) }
                    .flatMap { nationalities ->
                        permutations<Pet>()
                            .filter { it.petRules(nationalities) }
                            .flatMap { pets ->
                                permutations<Drink>()
                                    .filter { it.drinkRules(colors, nationalities) }
                                    .flatMap { drinks ->
                                        permutations<Smoke>()
                                            .filter {
                                                it.smokeRules(
                                                    colors,
                                                    nationalities,
                                                    drinks,
                                                    pets,
                                                )
                                            }
                                            .map { smoke ->
                                                Solution(
                                                    colors,
                                                    nationalities,
                                                    pets,
                                                    drinks,
                                                    smoke,
                                                )
                                            }
                                    }
                            }
                    }
            }.first()
    }

    private fun List<Color>.colorRules(): Boolean =
        indexOf(Color.GREEN) == indexOf(Color.IVORY) + 1 // rule 6

    private fun List<Nationality>.nationalityRules(colors: List<Color>): Boolean =
        indexOf(Nationality.ENGLISHMAN) == colors.indexOf(Color.RED) && // rule 2
            indexOf(Nationality.NORWEGIAN) == 0 && // rule 10
            (
                indexOf(Nationality.NORWEGIAN) - 1 == colors.indexOf(Color.BLUE) ||
                    indexOf(Nationality.NORWEGIAN) + 1 == colors.indexOf(Color.BLUE)
                ) // rule 15

    private fun List<Drink>.drinkRules(colors: List<Color>, nationalities: List<Nationality>): Boolean =
        indexOf(Drink.COFFEE) == colors.indexOf(Color.GREEN) && // rule 4
            nationalities.indexOf(Nationality.UKRAINIAN) == indexOf(Drink.TEA) && // rule 5
            indexOf(Drink.MILK) == 2 // rule 9

    private fun List<Pet>.petRules(nationalities: List<Nationality>): Boolean =
        nationalities.indexOf(Nationality.SPANIARD) == indexOf(Pet.DOG) // rule 3

    private fun List<Smoke>.smokeRules(
        colors: List<Color>,
        nationalities: List<Nationality>,
        drinks: List<Drink>,
        pets: List<Pet>,
    ): Boolean {
        return indexOf(Smoke.OLD_GOLD) == pets.indexOf(Pet.SNAILS) && // rule 7
            indexOf(Smoke.KOOLS) == colors.indexOf(Color.YELLOW) && // rule 8
            (
                indexOf(Smoke.CHESTERFIELD) - 1 == pets.indexOf(Pet.FOX) ||
                    indexOf(Smoke.CHESTERFIELD) + 1 == pets.indexOf(Pet.FOX)
                ) && // rule 11
            (
                indexOf(Smoke.KOOLS) - 1 == pets.indexOf(Pet.HORSE) ||
                    indexOf(Smoke.KOOLS) + 1 == pets.indexOf(Pet.HORSE)
                ) && // rule 12
            indexOf(Smoke.LUCKY_STRIKE) == drinks.indexOf(Drink.ORANGE_JUICE) && // rule 13
            indexOf(Smoke.PARLIAMENT) == nationalities.indexOf(Nationality.JAPANESE) // rule 14
    }

    private inline fun <reified T : Enum<T>> permutations(): List<List<T>> =
        enumValues<T>().toList().permute()

    private fun <T> List<T>.permute(): List<List<T>> {
        if (isEmpty()) return listOf(this)
        return flatMap { e -> (this - e).permute().map { list -> list + e } }
    }
}
