class Pangram {
    companion object {
        fun isPangram(x: String): Boolean {
            if (x.length < 26) return false
            return ('a' .. 'z').all { x.contains(it, true)}
/*
            val t = x.toLowerCase()
            for (c in 'a' .. 'z')
                if (c !in t) return false
            return true
*/
        }
    }
}