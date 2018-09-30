package murai.dpAndrecursion

class PowerSet {

    static void main(String[] args) {
        def powerSet = new PowerSet()
        List input = ['a', 'b', 'c']
        def results = powerSet.generatePowerSet(input)
        println("results=$results")
    }

    List<List> generatePowerSet(List input) {
        List<List> result = [[]]

        input.each { e ->
            List out = []
            result.each { l ->
                out << l + [e]
            }
            result.addAll(out)
        }
        result
    }
}
