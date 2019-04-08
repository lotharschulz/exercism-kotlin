class RotationalCipher(private val input: Int) {
    fun encode(text: String): String = text.map { char ->
            when (char) {
                in 'a'..'z' -> (((char.minus('a').plus(input))%26)+'a'.toInt()).toChar()
                in 'A'..'Z' -> (((char.minus('A').plus(input))%26)+'A'.toInt()).toChar()
                else -> char
            }
        }.joinToString("")
}


/*
     // https://stackoverflow.com/questions/36707393/caesar-cipher-shifting-characters
     char base = 0;
     if(string[i] >= 'a' && string[i] <= 'z'){
         base = 'a';
     }else if(string[i] >= 'A' && string[i] <= 'Z'){
         base = 'A';
     }
     if(base){
         string[i] = ((string[i] - base) + key) % 26 + base;
     }


     // https://www.ict.social/kotlin/basics/strings-in-kotlin-working-with-single-characters
     var i = c.toInt()
     i += shift
     if (i > 'z'.toInt()) {
             i -= 26
     }
     val char = i.toChar()
     message += char

     // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/minus.html
     // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/plus.html
     // https://www.lotharschulz.info/2018/08/05/kotlin-convert-string-containing-only-numbers-to-int/

  */

/*
        for(char:Char in text) {
            val base: Char = '0'
            if (char >= 'a' && char <= 'z') {
                base = 'a'
            } else if (char >= 'A' && char <= 'Z') {
                base = 'A'
            }
            if (base) {
                char = ((char - base) + input) % 26 + base;
            }
        }
*/

// https://github.com/akb286/RotationalCipher/blob/master/rotational.js