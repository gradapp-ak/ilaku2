package ctci

class QuickSort {
    def static quickSort = new QuickSort()

    static void main(String[] args) {
        def list = [4, 11, 13, 0, 12, 8, 0]
        //def list = [4]
        //def list = [4, 2]
        quickSort.putinPlace(list, 0, list.size()-1)
        println("Output=${list}")
    }

    void putinPlace(List arr, int start, int end) {
        if (start >= end) {
            return
        }
        int pivot = arr[start]
        int j = start

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                j++
                int temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
        }
        arr[start] = arr[j]
        arr[j] = pivot
        putinPlace(arr, start, j-1)
        putinPlace(arr, j+1, end)
    }
}
