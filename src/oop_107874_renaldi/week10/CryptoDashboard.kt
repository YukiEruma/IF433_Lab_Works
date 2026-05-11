package oop_107874_renaldi.week10

fun main() {

    val coinRepo = WalletRepository<Coin>()


    coinRepo.add(Coin("BTC", 0.52))
    coinRepo.add(Coin("ETH", 3.75))
    coinRepo.add(Coin("USDT", 1500.00))
    coinRepo.add(Coin("BNB", 10.0))
    coinRepo.add(Coin("SOL", 25.3))


    val response = ApiResponse("200 OK", coinRepo.getAll())


    println("========================================")
    println("       CRYPTO WALLET DASHBOARD")
    println("========================================")
    println("Status  : ${response.status}")
    println("Aset    : ${coinRepo.count()} koin")
    println("----------------------------------------")
    response.data.forEachIndexed { index, coin ->
        println("${index + 1}. ${coin.name} | Saldo: ${coin.balance}")
    }
    println("----------------------------------------")


    val txRepo = WalletRepository<Transaction>()
    txRepo.add(Transaction("TXN-001", 0.01))
    txRepo.add(Transaction("TXN-002", 500.00))
    txRepo.add(Transaction("TXN-003", 1.5))
    txRepo.add(Transaction("TXN-004", 250.75))

    val txResponse = ApiResponse("200 OK", txRepo.getAll())

    println("\n========================================")
    println("       TRANSACTION HISTORY")
    println("========================================")
    println("Status  : ${txResponse.status}")
    txResponse.data.forEach { tx ->
        println("${tx.id} | Rp ${tx.amount}")
    }


    println("\n[OK] Semua data tampil tanpa kesalahan tipe.")
    println("[OK] Generic Architecture berhasil diuji!")
    println("========================================")
}