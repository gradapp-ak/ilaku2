package murai

class MatrixPath {

    static void main(String[] args) {
        def matrixPath = new MatrixPath()
        List<List> input = [
                [3, 7, 9, 2, 7],
                [9, 8, 3, 5, 5],
                [1, 7, 9, 8, 5],
                [3, 8, 6, 4, 10],
                [6, 3, 9, 7, 8]
        ]
        List<List> input2 = [
                [3, 7, 7, 8, 5],
                [6, 6, 6, 4, 1],
                [9, 7, 8, 8, 1],
                [9, 8, 7, 8, 9],
                [9, 9, 9, 9, 1]
        ]
        input=input2
        Map path = matrixPath.findPath(input, input.size() - 1, input.size() - 1)
        println("Sum=${path.v}")
        println("Path=${path.path}")
    }

    Map findPath(List<List> array, int r, int c) {
        Map result = [:]
        println("input=r:$r,c;$c")
        if (r == 0 && c == 0) {
            result << [path: [[r: r, c: c]], v: array.get(r).get(c)]
            println("output=sum:${result.v},${result.path}")
            return result
        }
        int lV = 0
        int uV = 0
        Map lPath
        if (r - 1 >= 0) {
            lPath = findPath(array, r - 1, c)
            lV = lPath.v ?: 0
        }
        Map uPath
        if (c - 1 >= 0) {
            uPath = findPath(array, r, c - 1)
            uV = uPath.v ?: 0
        }
        if (lV >= uV) {
            lPath.path << [r: r, c: c]
            lPath.v = lV + array.get(r).get(c)
            result = lPath
        } else {
            uPath.path << [r: r, c: c]
            uPath.v = uV + array.get(r).get(c)
            result = uPath
        }
        result
    }
}
