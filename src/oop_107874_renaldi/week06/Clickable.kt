package oop_107874_renaldi.week06

interface Clickable {
    // ERROR: Property in an interface cannot have a backing field
    val name: String // Abstract property, tidak ada nilai default
    fun click()
}