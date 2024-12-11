package tests

// Pay attention! You must not specify the type of the second (related to Throwable) message
class MyException(message: String): Throwable(message)

// Pay attention to deails like:
//  - Uppercase 'T'
//  - The use of parentesis
//  - You do not need to open a comment block with "/**" and end with "*/"
@Throws(MyException::class)
fun vote(name: String, age: Int) {
    if (age < 16) {
        throw MyException("Vote is only allowed to a person who have 16 years or more")
    }
    print("Registering a vote to $name -- ")
}

fun main() {
    var total_votes = 0

    total_votes += try {
        vote("André", 42)
        1
    } catch (e: MyException) {
        0
    }

    total_votes += try {
        vote("Enzo", 12)       
        1
    } catch (e: MyException) {
        0
    }

    total_votes += try {
        vote("Julio", 73)
        1
    } catch (e: MyException) {
        0
    }

    print("Total votes: $total_votes")
}