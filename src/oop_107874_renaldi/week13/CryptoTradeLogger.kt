package oop_107874_renaldi.week13

import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

fun TradeRecord.toCsv(): String = "$id,$symbol,$type,$margin,$pnl"
fun fromCsvTrade(line: String): TradeRecord? {
    return try {
        val parts = line.split(",")
        TradeRecord(
            id = parts[0].toInt(),
            symbol = parts[1],
            type = parts[2],
            margin = parts[3].toDouble(),
            pnl = parts[4].toDouble()
        )
    } catch (e: Exception) {
        println("(Log) Data korup diabaikan: $line")
        null
    }
}

fun saveTrades(trades: List<TradeRecord>, path: String) {
    File(path).printWriter().use { writer ->
        trades.forEach { trade ->
            writer.println(trade.toCsv())
        }
    }
}

fun loadTrades(path: String): List<TradeRecord> {
    return try {
        File(path).readLines().mapNotNull { fromCsvTrade(it) }
    } catch (e: FileNotFoundException) {
        println("Error: File trades tidak ditemukan!")
        emptyList()
    }
}

fun main() {
    val trades = listOf(
        TradeRecord(id = 1, symbol = "BTCUSDT", type = "Long", margin = 500.0, pnl = 120.5),
        TradeRecord(id = 2, symbol = "ETHUSDT", type = "Short", margin = 300.0, pnl = -45.0),
        TradeRecord(id = 3, symbol = "SOLUSDT", type = "Long", margin = 200.0, pnl = 87.3)
    )

    saveTrades(trades, path = "crypto_trades.csv")
    println("Trade records berhasil disimpan ke crypto_trades.csv")
    File("crypto_trades.csv").appendText("CORRUPT_ID,DOGEUSDT,Hold,XX,YY\n")
    println("Baris korup berhasil di-inject.")
    val loadedData = loadTrades(path = "crypto_trades.csv")
    val totalPnl = loadedData.sumOf { it.pnl }
}