package ctci

class PalindromePermutation {

    static void main(String[] args) {
        checkPalindromePermutation("Tact Coaaa o")
    }

    static void checkPalindromePermutation(String input) {
        def upperInput = input.toUpperCase()
        Map<Character, Integer> charCount = [:]
        int strLen = 0
        for (int i = 0; i < upperInput.size(); i++) {
            Character c = upperInput.charAt(i)
            if (c != ' ' as char) {
                def count = charCount[c]
                charCount[c] = count ? ++count : 1
                ++strLen
            }
        }
        boolean oddLength = strLen % 2 != 0
        int numOfOddCountedCharacters = 0
        charCount.each { k, v ->
            (v % 2 != 0) ? ++numOfOddCountedCharacters : 0
        }
        boolean isPalindrome
        if (oddLength) {
            isPalindrome = numOfOddCountedCharacters == 1
        } else {
            isPalindrome = numOfOddCountedCharacters == 0
        }
        println("is palindrome=$isPalindrome")
    }
}
