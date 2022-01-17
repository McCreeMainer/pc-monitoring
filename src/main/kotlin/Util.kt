// Args
const val EXIT = "exit"
const val CURRENT = "current-status"

// Msg
const val WELCOME = "Type one of the following command:"
const val INCORRECT_INPUT = "Incorrect input"
const val ON_EXIT = "Shut down service"

val commandHelp = mapOf(
    "current-status" to "Get current CPU load",
    "exit" to "Shut down service"
)

fun printHelp() {
    println(commandHelp.entries.joinToString("\n") { "\t" + it.key + " – " + it.value })
}
