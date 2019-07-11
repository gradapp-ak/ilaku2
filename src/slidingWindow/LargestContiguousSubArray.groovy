package slidingWindow

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
class LargestContiguousSubArray {

    static void main(String[] args) {
        findMaxBruteForce([1, 2, 3, 1, 4, 5, 2, 3, 6], 3)
        findMaxBruteForce([8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4)
    }

    static void findMaxBruteForce(List<Integer> elements, int k) {
        for (int j = 0; j <= elements.size() - k; j++) {
            println("start=$j,end=${j + k},max=${findMax(j, j + k, elements)}")
        }
    }

    private static int findMax(int i, int n, List<Integer> elements) {
        int maxSoFar = Integer.MIN_VALUE
        for (; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, elements[i])
        }
        maxSoFar
    }
}
