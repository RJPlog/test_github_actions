fun main(args: Array<String>) {
    var x: String = "42"
    if (!args.isEmpty()) {
        x = args[0]
    }
    println("Hello, World! Build worked, let's see if it is running :-) or not.")
    println("Yeah, finally it is running")
    println("and what about if a bug is there?")
    println("wow, now also unit test are running!")
    println("and it is connected to a branch rule")
    println("+++++++++++")
    println("Eingabe: $x")
    println("+++++++++++")
    printn("ups, bug fixed")
}
