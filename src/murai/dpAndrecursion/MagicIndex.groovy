package murai.dpAndrecursion

class MagicIndex {
    static MagicIndex magicIndex = new MagicIndex()

    static void main(String[] args) {
        List input = [-1, 0, 1, 3, 5, 6, 7]
        input = [0, 1, 3, 5, 6, 7]
        input = [-1, 0, 1, 2, 3, 5]
        //input = [-1, 0, 1, 2, 3, 6]
        println("magicIndex=${magicIndex.findMagicIndex(input)}")
        println("magicIndex; binary=${magicIndex.findMagicIndexBinarySearch(input, 0, input.size() - 1)}")
    }

    int findMagicIndexBinarySearch(List input, int start, int end) {
        int magicIndex = -1
        if (end < start) {
            return magicIndex
        }
        int mid = (start + end) / 2
        if (mid == input.get(mid)) {
            magicIndex = mid
        } else if (mid > input.get(mid)) {
            magicIndex = findMagicIndexBinarySearch(input, mid + 1, end)
        } else if (mid < input.get(mid)) {
            magicIndex = findMagicIndexBinarySearch(input, start, mid - 1)
        }
        magicIndex
    }

    int findMagicIndex(List input) {
        int i = 0
        boolean found = false
        for (; i < input.size(); i++) {
            if (i == input.get(i)) {
                found = true
                break
            }
        }
        found ? i : -1
    }
}
