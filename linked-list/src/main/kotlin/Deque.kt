class Deque<T> (){

    sealed class Node {
        data class Element<T>(val payload : T, var prev: Node = Terminal, var next : Node = Terminal) : Node()
        object Terminal : Node()
    }

    private var first:Node = Node.Terminal
    private var last:Node = Node.Terminal

    /** insert at back of the list **/
    fun push(v: T){
        if ( last is Node.Terminal ){ // empty list
            unshift(v)
        }else if(last is Node.Element<*>){ // not empty list
            val newLast = Node.Element(v,last, Node.Terminal)
            last = newLast
        }
    }

    /** insert at the beginning of the list **/
    fun unshift(v: T) {
        val newFirst = Node.Element(v, Node.Terminal, first)
        first = newFirst
    }

    /** Remove an element from the back of the list **/
    fun pop(): T? {
        if ( last is Node.Terminal ) { // empty list
            return null
        }else if(last is Node.Element<*>){ // not empty list
            val r = last as Node.Element<T>
            last = r.prev
            return r.payload
        }
        return null
    }

    /** Remove an element at the beginning of the list */
    fun shift(): T? {
        if ( first is Node.Terminal ) { // empty list
            return null
        }else if(first is Node.Element<*>){ // not empty list
            val r = first as Node.Element<T>
            first = r.next
            return r.payload
        }
        return null
    }
}

/*
class Deque<T> (){

    inner class Node<T>(val v: T, var prev: Node<T>?, var next: Node<T>?)

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
 */