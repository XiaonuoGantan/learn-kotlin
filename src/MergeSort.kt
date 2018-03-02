import java.util.*


fun merge(C: IntArray, D: IntArray): IntArray {
    val B = IntArray(C.count() + D.count())
    var i = 0
    var j = 0
    for (k in 0 until B.count()) {
        if (i < C.count() && j < D.count() && C[i] < D[j]) {
            B[k] = C[i]
            i += 1
        } else {
            if (j == D.count()) {
                B[k] = C[i]
                i += 1
            } else {
                B[k] = D[j]
                j += 1
            }
        }
    }
    return B
}


fun mergeSort(A: IntArray): IntArray {
    var listA = A.asList()
    if (listA.count() == 1) {
        return listA.toIntArray()
    } else {
        val C = listA.subList(0, listA.count() / 2)
        val D = listA.subList(listA.count() / 2, listA.count())
        return merge(mergeSort(C.toIntArray()), mergeSort(D.toIntArray()))
    }
}


fun main(args: Array<String>) {
    val sorted = mergeSort(arrayOf(2,1,3,5,7,4).toIntArray())
    println(Arrays.toString(sorted))
}
