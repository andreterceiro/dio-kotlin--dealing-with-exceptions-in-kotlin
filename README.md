# Introduction

This way you can throw an exception. **Remember:** you **don't** have to use the **new** keyword:

```kotlin
package tests

fun main() {
    throw Exception("This is an exception")
}
```


# Catching an exception

This is how to catch an exception:

```kotlin
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
```


# Try as an expression

You can return a value from a try/catch block. Details:
- You can't use the **return** keyword. The result of the last line is returned;
- A finnaly block is allowed, but do not return a value,

Example:

```kotlin
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
```

An observation: you can have more than one catch block. The first one that matches the exception is executed and if the try/catch block is used as an expression, only the first match is returned.



# Checked exceptions

Teacher showed us this three of Java exceptions. He explained to us that he can do it because Kotlin is based on Java:

![exception hieararchy](images/exception-hierarchy.png)

Teacher explained us:

- That all exceptions and errors in hierarchy inherits from **Throwable**;
- Kotlin does **not** have the concept of checked exceptions. In Java, blocks that maybe throws a checked exception must deal with the exception (maybe rethrow the exception);
- You see in hierarchy that we have an exception and an error. Error is a most serious problem.


# @throws and creating your own exception

Please see this next code and its comments. Easy to understand, I will not make more comments:

```kotlin
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
```