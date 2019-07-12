package slidingWindow

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
class LargestNumberInSubArray {

    static void main(String[] args) {
        findMaxBruteForce([1, 2, 3, 1, 4, 5, 2, 3, 6], 3)
        findMaxBruteForce([8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4)
        findMaxDeque([1, 2, 3, 1, 4, 5, 2, 3, 6], 3)
        findMaxDeque([8, 5, 10, 7, 9, 4, 15, 12, 90, 13], 4)
    }

    //O(n)
    static void findMaxDeque(List<Integer> elements, int k) {
        Deque deque = new ArrayDeque<Integer>()
        for (int i = 0; i < elements.size(); i++) {
            if (deque.size() == k) {
                deque.removeFirst()
            }
            if (deque.isEmpty() || deque.peekLast() > elements[i]) {
                deque.addLast(elements[i])
            } else {
                while (!deque.isEmpty() && deque.peekLast() < elements[i]) {
                    deque.removeLast()
                }
                deque.addLast(elements[i])
            }
            if(i >= k-1){
                println("max so far, start=${i - k + 1},end=$i,max=${deque.peekFirst()}")
            }
        }
    }

    //O(n2)
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
