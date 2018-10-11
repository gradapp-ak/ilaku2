package murai.dpAndrecursion

class LargestRectangle {

    static void main(String[] args) {
        def largestRectangle = new LargestRectangle()
        def max = largestRectangle.find(
                [
                        [0, 1, 1],
                        [0, 1, 1],
                        [0, 1, 0],
                        [0, 1, 0],
                        [0, 1, 0]

                ]
        )
        println("Max=$max")
    }

    Rectangle find(List<List> input) {
        Rectangle max = new Rectangle(l: 0, b: 0)
        List<List<Rectangle>> sum = []
        for (int r = 0; r < input.size(); r++) {
            sum[r] = []
            for (int c = 0; c < input.get(r).size(); c++) {

                if (input[r][c] == 0) {
                    sum[r].add(new Rectangle(l: 0, b: 0, endC: c, endR: r))
                } else {
                    def rectangle = new Rectangle(endC: c, endR: r, l: 1, b: 1)
                    if (c - 1 >= 0) {
                        rectangle.l = sum[r][c - 1].l + 1
                    }
                    if (r - 1 >= 0) {
                        rectangle.b = sum[r - 1][c].b + 1
                    }
                    if (max.getArea() < rectangle.getArea()) {
                        max = rectangle;
                    }
                    sum[r].add(rectangle)
                }
            }
        }
        //println("Sum=$sum")
        return max
    }
}

class Rectangle {
    int l
    int b

    int endR
    int endC

    int getArea() {
        l * b
    }

    String toString() {
        "Area=${getArea()}, l=$l,b=$b, for end coordinates: r:$endR, c:$endC"
    }
}