package tests

fun main() {
    var ret = try {
        20 / 5
    } catch (e: ArithmeticException) {
        null
    }
    print(ret)

    print(" -- ")

    ret = try {
        20 / 0
    } catch (e: ArithmeticException) {
        null
    }
    print(ret)
}