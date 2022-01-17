
import com.sun.management.OperatingSystemMXBean
import java.lang.management.ManagementFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun main() {
    var command: String? = null
    println(WELCOME)
    printHelp()

    while (command != EXIT) {
        val args = readLine()
            ?.trim()
            ?.replace(Regex("""\s+"""), " ")
            ?.lowercase()
            ?.split(" ")
            ?: emptyList()

        if (args.isEmpty()) {
            println(INCORRECT_INPUT)
            continue
        }

        when (args[0]) {
            EXIT -> {
                command = EXIT
                println(ON_EXIT)
            }
            CURRENT -> {
                printCpuLoad()
            }
            else -> {
                println(INCORRECT_INPUT)
            }
        }
    }
}

fun printCpuLoad() {
    val platform = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean::class.java)
    val dateTime = LocalDateTime.now()
    val formattedDateTime = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))

    println("[${formattedDateTime}] Current CPU usage: ${platform.cpuLoad}")
}