class Year constructor(year: Int){
    val isLeap: Boolean = when{
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }
}