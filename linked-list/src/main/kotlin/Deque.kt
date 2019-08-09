class Deque<T> (){

    inner class Node<T>(val v: T, var prev: Node<T>?, var next: Node<T>?)

    // private lateinit var first:Node<T>
    // private lateinit var last:Node<T>
    private var first:Node<T>? = null
    private var last:Node<T>? = null

    fun push(v: T){
        if ( last != null ){
            val currentLast = last
            last = Node(v, currentLast, currentLast?.next)
            currentLast?.next = last;
        }else{
            addToEmpty(v)
        }
    }

    fun pop(): T? {
        val currentLast = last
        last = last?.prev
        return currentLast?.v
    }

    fun shift(): T? {
        val currentFirst = first
        first = first?.next
        return currentFirst?.v
    }

    fun unshift(v: T) {
        if (first == null) {
            addToEmpty(v)
        }
        else {
            val currentFirst = first
            first = Node(v, currentFirst?.prev, currentFirst)
            currentFirst?.prev = first;
        }
    }

    private fun addToEmpty(v: T){
        val newNode = Node(v, null, null)
        first = newNode
        last = newNode
    }
}