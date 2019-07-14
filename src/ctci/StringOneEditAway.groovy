package ctci

class StringOneEditAway {

    static void main(String[] args) {
        isOneEditAway("pale", "bale")
        isOneEditAway("pale", "b")
        isOneEditAway("pale", "paale")
        isOneEditAway("pale", "ple")
        isOneEditAway("pale", "pxle")
        isOneEditAway("palle", "pale")
    }

    static void isOneEditAway(String str1, String str2) {
        int i = 0, j = 0
        int noOfMisMatch = 0
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++; j++
            } else {
                noOfMisMatch++;
                if (noOfMisMatch > 1) break
                if (str1.length() == str2.length()) {
                    i++; j++
                } else {
                    str1.length() > str2.length() ? i++ : j++
                }
            }
        }
        println("match=${noOfMisMatch < 2}, with noOfMisMatch=$noOfMisMatch")
    }
}
