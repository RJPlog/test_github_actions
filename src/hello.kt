fun main(args: Array<String>) {
    var x: String = "42"
    var y: String = "empty"
    if (!args.isEmpty()) {
        x = args[0]
        if (args.size > 1) {
            y = args[1]
        }
    }
    println("Hello, World! Build worked, let's see if it is running :-) or not.")
    println("Yeah, finally it is running")
    println("and what about if a bug is there?")
    println("wow, now also unit test are running!")
    println("and it is connected to a branch rule")
    println("+++++++++++")
    println("Eingabe: $x")
    println("y: $y")
    println("+++++++++++")
    println("ups, bug fixed")
}
