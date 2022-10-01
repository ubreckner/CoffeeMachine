package machine

class MachineState() {
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550
}

class CoffeeMachine(private val state: MachineState) {
    fun run(input: String) {
        when (input) {
            "buy" -> {
                buy(state)
            }

            "fill" -> {
                fill(state)
            }

            "take" -> {
                take(state)
            }

            "remaining" -> {
                printStatus(state)
            }
        }
    }

    private fun printStatus(state: MachineState) {
        println("The coffee machine has:")
        println("${state.water} ml of water")
        println("${state.milk} ml of milk")
        println("${state.coffee} g of coffee beans")
        println("${state.cups} disposable cups")
        println("$${state.money} of money")
    }

    private fun fill(state: MachineState) {
        println("Write how many ml of water you want to add:")
        state.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        state.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        state.coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        state.cups += readln().toInt()

    }

    private fun take(state: MachineState) {
        println("I gave you $${state.money}")
        state.money = 0
    }

    private fun buy(state: MachineState) {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        val input = readln()
        if (input != "back") {
            val selection = input.toInt()
            when (selection) {
                1 -> {
                    println(
                        if (state.water - 250 < 0) {
                            "Sorry, not enough water!"
                        } else if (state.coffee - 16 < 0) {
                            "Sorry, not enough coffee beans!"
                        } else if (state.cups - 1 < 0) {
                            "Sorry, not enough cups!"
                        } else {
                            state.water -= 250
                            state.coffee -= 16
                            state.money += 4
                            state.cups -= 1
                            "I have enough resources, making you a coffee!"
                        }
                    )
                }

                2 -> {
                    println(
                        if (state.water - 350 < 0) {
                            "Sorry, not enough water!"
                        } else if (state.milk - 75 < 0) {
                            "Sorry, not enough milk!"
                        } else if (state.coffee - 20 < 0) {
                            "Sorry, not enough coffee beans!"
                        } else if (state.cups - 1 < 0) {
                            "Sorry, not enough cups!"
                        } else {
                            state.water -= 350
                            state.milk -= 75
                            state.coffee -= 20
                            state.money += 7
                            state.cups -= 1
                            "I have enough resources, making you a coffee!"
                        }
                    )
                }

                3 -> {
                    println(
                        if (state.water - 200 < 0) {
                            "Sorry, not enough water!"
                        } else if (state.milk - 100 < 0) {
                            "Sorry, not enough milk!"
                        } else if (state.coffee - 12 < 0) {
                            "Sorry, not enough coffee beans!"
                        } else if (state.cups - 1 < 0) {
                            "Sorry, not enough cups!"
                        } else {
                            state.water -= 200
                            state.milk -= 100
                            state.coffee -= 12
                            state.money += 6
                            state.cups -= 1
                            "I have enough resources, making you a coffee!"
                        }
                    )
                }
            }
        }

    }
}

fun main() {
    val state = MachineState()

    val coffeeMachine = CoffeeMachine(state)
    var command = ""

    while (command != "exit") {

        println("\nWrite action (buy, fill, take, remaining, exit):")
        command = readln()
        coffeeMachine.run(command)
    }
}
