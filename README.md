# Food Delivery (MvRx)


Problem Solving

```kotlin
fun String.ofStepFromAtoZ(step: Int): String {
    val min: Int = 'a'.toInt()
    val max: Int = 'z'.toInt()
    //range from a to z (26)
    val distance: Int = (max - min) + 1
    val result = StringBuilder()
    for (element: Char in this) {
        //position of current element + step
        val el: Int = (element.toInt() + step) - min
        //result of position after re index
        val vl: Int = (el % distance) + min
        result.append(vl.toChar())
    }
    return result.toString()
}

```
