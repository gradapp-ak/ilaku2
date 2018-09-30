package murai.dpAndrecursion

class RecursiveMultiply {

    static void main(String[] args) {
        def recursiveMultiply = new RecursiveMultiply()
        int m = 3
        int n = 20
        int output = recursiveMultiply.multiply(m, n)

        println("Output=${output}")
    }

    int multiply(int m, int n) {
        if (m == 0 || n == 0) return 0
        if (m == 1) return n
        return n + multiply(m - 1, n)
    }
}
