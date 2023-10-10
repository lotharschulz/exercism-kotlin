class Reactor<T>() {
    interface Subscription {
        fun cancel()
    }

    interface Cell<T> {
        val value: T
        fun addCallback(fn: (T) -> Unit): Subscription
    }

    inner class InputCell(private val initialValue: T) : Cell<T> {
        private val callbacks = mutableSetOf<(T) -> Unit>()

        override var value = initialValue
            set(newValue) {
                if (field != newValue) {
                    field = newValue
                    callbacks.forEach { it(newValue) }
                }
            }

        override fun addCallback(fn: (T) -> Unit): Subscription {
            callbacks.add(fn)
            return object : Subscription {
                override fun cancel() {
                    callbacks.remove(fn)
                }
            }
        }
    }

    inner class ComputeCell(private vararg val inputCells: Cell<T>, val fn: (List<T>) -> T) : Cell<T> {
        override val value
            get() = fn(inputCells.map { it.value })

        private var lastValue = value
        private val callbacks = mutableSetOf<() -> Unit>()

        init {
            inputCells.forEach { cell ->
                cell.addCallback {
                    if (value != lastValue) {
                        lastValue = value
                        callbacks.forEach { it() }
                    }
                }
            }
        }

        override fun addCallback(fn: (T) -> Unit): Subscription {
            val callback = { fn(value) }
            callbacks.add(callback)
            return object : Subscription {
                override fun cancel() {
                    callbacks.remove(callback)
                }
            }
        }
    }
}
