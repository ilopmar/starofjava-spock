package demo

import spock.lang.Specification

class E9_Old extends Specification {

    void 'should increase the size of the list when adding a number'() {
        given:
        var numbers = [1, 1, 2, 3, 5, 8, 13]

        when:
        numbers << 21

        then:
        false
    }
}
