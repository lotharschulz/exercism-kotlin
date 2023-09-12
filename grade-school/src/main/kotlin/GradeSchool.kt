class School {
    private val studentsAndGrades:MutableList<Pair<String, Int>> = mutableListOf()

    fun add(student: String, grade: Int) = studentsAndGrades.add(Pair(student, grade))

    fun grade(grade: Int): List<String> =
        pairsToSortedStudents(studentsAndGrades.filter { pair -> pair.second == grade })

    fun roster(): List<String> =
        pairsToSortedStudents(studentsAndGrades)

    private fun pairsToSortedStudents(pairs: List<Pair<String, Int>>): List<String> =
        pairs.sortedWith(compareBy({ it.second }, { it.first })).map { pair -> pair.first }
}
