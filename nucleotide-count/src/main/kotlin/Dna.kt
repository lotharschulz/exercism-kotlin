class Dna(private val input: String){
    private val dnaAcids = "ACGT"
    private val initialDNA = dnaAcids.map { it to 0 }.toMap()
    val nucleotideCounts :Map<Char, Int> = initialDNA + input.toList().groupingBy { it }.eachCount()
    init { require(input.all { it in dnaAcids }) }
}