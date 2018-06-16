class Year constructor(private val year: Int){

    var isLeap: Boolean = false
    init {
/*
        when (year.rem(400)){
            0 -> isLeap = true
        }
*/
        if (year % 400 == 0) isLeap = true
        else if (year % 100 == 0) isLeap = false
        else if (year % 4 == 0) isLeap = true
/*
        if (year % 4 == 0){
            isLeap = true
            if (year % 100 == 0){
                isLeap = false
                if (year % 400 == 0){
                    isLeap = true
                }
            }
        }
*/
    }
}