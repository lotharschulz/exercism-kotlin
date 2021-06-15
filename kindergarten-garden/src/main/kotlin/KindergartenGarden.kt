class KindergartenGarden(private val diagram: String) {

    val cupToPlants = mapOf(
        "V" to "violets",
        "R" to "radishes",
        "C" to "clover",
        "G" to "grass"
    )

    val studentsInClass = listOf<String>("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")

    fun getPlantsOfStudent(student: String): List<String> {
        require(studentsInClass.contains(student))
        val index = studentsInClass.indexOf(student)
        val plantsList = mutableListOf<String>();
        diagram.split("\n").forEach {
            cupToPlants[it.get(index*2).toString()]?.let { cupLabel -> plantsList.add(cupLabel) }
            cupToPlants[it.get(index*2+1).toString()]?.let { cupLabel -> plantsList.add(cupLabel) }
        }
        return plantsList
    }
}
