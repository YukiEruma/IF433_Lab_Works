package oop_107874_renaldi.week11


fun String.addGreeting(): String {
    return "Hello, $this"
}


fun String.repeatTimes(n: Int): String {
    return this.repeat(n)
}


fun String?.isNullOrEmptyCustom(): Boolean {
    // 'this' bisa bernilai null, jadi harus ditangani
    return this == null || this.isEmpty()
}