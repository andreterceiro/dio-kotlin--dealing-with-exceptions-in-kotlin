package tests

fun main(){
    try {
        print(10/2)
        print(10/0)        
    } catch(e: ArithmeticException) { // you can comment this and the next line ...
        print(e.message)              // ... to see the exception be caugth by the catch block
    } catch(e: Throwable) {
        e.printStackTrace()
    } finally {
        print(" -- finally executado")
    }
    print(" -- depois do try/catch")
}