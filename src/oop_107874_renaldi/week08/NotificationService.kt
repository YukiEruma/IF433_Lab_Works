package oop_107874_renaldi.week08

class NotificationService {
    fun sendEmail(emailAddress: String) {
        println("Mengirim email ke: $emailAddress")
    }

    fun processUser(user: UserProfile) {
        if (user.email != null) {
            sendEmail(emailAddress = user.email)
        } else {
            println("User ${user.name} tidak memiliki email.")
        }
    }
}