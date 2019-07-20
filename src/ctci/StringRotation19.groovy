package ctci

class StringRotation19 {
    static void main(String[] args) {
        checkStringRotation("waterbottle", "erbottlewat")
        checkStringRotation("waterbottle", "tlewaterbot")
        checkStringRotation("waterbottle", "tlewatexbot")
        checkStringRotation("water", "qater")
        checkStringRotation("water", "water")
    }

    static void checkStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return

        int matchEnd = 0
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(matchEnd)) {
                matchEnd++
            } else if (matchEnd > 0 && s1.charAt(i) == s2.charAt(0)) {
                matchEnd = 0
            }
        }
        int k = 0
        boolean match = true
        for (int j = matchEnd ; j < s2.length(); j++) {
            match = s2.charAt(j) == s1.charAt(k++)
            if (!match) {
                break
            }
        }
        println("matched=$match")
    }
}
