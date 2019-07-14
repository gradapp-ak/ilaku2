package ctci

class StringURLEncodeCharacters {

    static void main(String[] args) {
        encode("Mr John Smith    ")

    }

    static void encode(String input) {
        char[] inputArray = input.toCharArray()
        int i = inputArray.size() - 1
        int k = i

        while (inputArray[i].equals(' ' as char)) {
            --i
        }

        for (; i >= 0; i--) {
            if (inputArray[i] != ' ' as char) {
                inputArray[k--] = inputArray[i]
            } else {
                inputArray[k--] = '0'
                inputArray[k--] = '2'
                inputArray[k--] = '%'
            }
        }
        println("output=${new String(inputArray)}")
    }
}
