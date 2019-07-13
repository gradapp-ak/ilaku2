package slidingWindow

//https://leetcode.com/problems/minimum-window-substring/
class MinWindowSubstring {

    static void main(String[] args) {
        findMinWindow("ADOBECODEBANC", "ABC")
    }

    static void findMinWindow(String input, String target) {
        Map<Character, Integer> currentWindowCharCount = new HashMap<>()
        HashSet<Character> targetChars = new HashSet<>()

        for (Character c in target) {
            targetChars.add(c)
        }

        int s = 0
        int minSoFar = Integer.MAX_VALUE
        for (int end = 0; end < input.length(); end++) {
            Character c = input.charAt(end)
            Integer count = currentWindowCharCount.get(c)
            currentWindowCharCount[c] = count ? ++count : 1
            while (hasAllChars(currentWindowCharCount, targetChars)) {
                int l = end - s + 1
                println("start=$s,end=$end, length=$l")
                if (l < minSoFar) {
                    println("new min, start=$s,end=$end, length=$l")
                    minSoFar = l
                }
                def sc = input.charAt(s++)
                currentWindowCharCount[sc] = --currentWindowCharCount.get(sc)
            }
        }
    }

    static boolean hasAllChars(HashMap<Character, Integer> characterIntegerHashMap,
                               HashSet<Character> targetChars) {
       return targetChars.every { tc -> characterIntegerHashMap[tc] > 0 }
    }
}
