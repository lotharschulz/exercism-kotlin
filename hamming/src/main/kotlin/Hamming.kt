object Hamming {
    fun compute(dna1: String, dna2: String): Int{
        require(dna1.length == dna2.length){
            "left and right strands must be of equal length."
        }
        return dna1.zip(dna2).sumBy { if(it.first == it.second) 0 else 1 }
    }

}
