package leetcode

class Solution {
    public int majorityElement(int[] nums) {
        Map counter = new HashMap();
        return nums.find {
            if (counter[it]) {
                counter[it] = counter[it] + 1
            } else {
                counter[it] = 1
            }
            counter[it] > nums.size() / 2
        }
    }

    static void main(String[] args) {
        println("result=" + new Solution().majorityElement([3,3,2] as int[]))
    }
}
