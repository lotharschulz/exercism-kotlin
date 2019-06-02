import java.util.concurrent.atomic.AtomicInteger

class BankAccount {
    private val internalBalance = AtomicInteger(0)
    private var open: Boolean = true
    val balance : Int
        get() {
            if (!open) throw IllegalStateException()
            return internalBalance.get()
        }

    fun adjustBalance(amount: Int) {
        if (!open) throw IllegalStateException()
        internalBalance.addAndGet(amount)
    }

    fun close(){
        open = false
    }
}