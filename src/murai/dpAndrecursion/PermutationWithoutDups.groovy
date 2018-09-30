package murai.dpAndrecursion

class PermutationWithoutDups {

    static void main(String[] args) {
        def withoutDups = new PermutationWithoutDups()
        def permutation = withoutDups.generatePermutation("abcd".toCharArray(), 0)
        println("results=${permutation}")
        println("results size=${permutation.size()}")
    }

    List<String> generatePermutation(char[] input, int i) {
        if (i == input.size() - 1) return ["${input[i]}"]
        return permute(input[i], generatePermutation(input, i + 1))
    }

    List<String> permute(char c, List<String> permutations) {
        List<String> output = []
        permutations.each { String s ->
            for (int j = 0; j < s.size() + 1; j++) {
                char[] result = new char[s.size() + 1]
                int sPos = 0
                for (int i = 0; i < result.size(); i++) {
                    if (i == j) {
                        result[i] = c
                    } else {
                        result[i] = s.charAt(sPos++)
                    }
                }
                output.add(String.valueOf(result))
            }
        }
        output
    }
}
