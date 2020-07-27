// Mein erster Taschenrechner in Kotlin xD

private var wantUsing: Boolean = true

fun main() {
    val calculator = Calculator()
    loop@ while (wantUsing){
        try {
            println("Gebe deine erste Zahl ein: ")
            calculator.number1 = checkNumberInput(readLine())
            when {
                calculator.number1.isNaN() -> {
                    println("Keine Zahl!")
                    break@loop
                }
            }
            println("Gebe deine zweite Zahl ein")
            calculator.number2 = checkNumberInput(readLine())
            when {
                calculator.number2.isNaN() -> {
                    println("Keine Zahl!")
                    break@loop
                }
            }

            println("Welche Operation möchtest du durchführen? Du kannst folgendes eintippen:")
            println("\t + \t - \t * \t /")
            calculator.operationType = checkOperationInput(readLine())
            if (calculator.operationType == "Error"){
                println("Keine unterstütze Operation")
                break@loop
            }

            when (calculator.operationType) {
                "+" -> {
                    calculator.addition()
                }
                "-" -> {
                    calculator.subtraction()
                }
                "*" -> {
                    calculator.multiple()
                }
                "/" -> {
                    calculator.divide()
                }
                else -> {
                    println("Keine Operation!")
                }
            }

            checkStatus()
        }
        catch (e: RuntimeException){
            println("Fehler!")
        }
    }
}


private fun checkNumberInput(input: String?): Double{
    if (input != null) {
        return input.toDouble()
    }
    return Double.NaN
}

private fun checkOperationInput(input: String?) : String{
    if (input != null){
        return input
    }
    return " "
}

private fun checkStatus(){
    println("Taschenrechner benutzen? y/n")
    val choice: String? = readLine()
    if (choice != null) {
        if (choice.contains('y')){
            wantUsing = true
        }
        if (choice.contains('n')){
            wantUsing = false
        }
    }
    else{
        println("Nochmal:")
        checkStatus()
    }
}


class Calculator {
    var operationType: String = ""
    var number1: Double = 0.0
    var number2: Double = 0.0
    private var result: Double = 0.0

    fun addition(){
        result = number1.plus(this.number2)
        println("Das Ergebnis ist: $result")
    }

    fun subtraction(){
        result = number1.minus(this.number2)
        println("Das Ergebnis ist: $result")
    }

    fun multiple(){
        result = number1 * number2
        println("Das Ergebnis ist: $result")
    }

    fun divide(){
        result = number1 / number2
        println("Das Ergebnis ist: $result")
    }
}