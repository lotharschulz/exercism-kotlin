class School {
    private val students:MutableList<Pair<String, Int>> = mutableListOf()

    fun add(student: String, grade: Int) = students.add(Pair(student, grade))

    fun grade(grade: Int): List<String> =
        pairsToStudentList(students.filter { pair -> pair.second == grade })

    fun roster(): List<String> =
        pairsToStudentList(students)

    private fun pairsToStudentList(pairs: List<Pair<String, Int>>): List<String> =
        pairs.sortedWith(compareBy({ it.second }, { it.first })).map { pair -> pair.first }
}
