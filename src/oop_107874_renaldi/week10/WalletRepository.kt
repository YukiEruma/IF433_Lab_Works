package oop_107874_renaldi.week10


class WalletRepository<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    fun count(): Int = items.size

    // CHECKPOINT 14 - Search/filter dengan predicate
    fun search(predicate: (T) -> Boolean): List<T> {
        return items.filter(predicate)
    }
}