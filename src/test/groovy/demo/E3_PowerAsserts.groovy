package demo

import spock.lang.Specification

class E3_PowerAsserts extends Specification {

    void 'should fail with numbers'() {
        expect:
        2 * 3 == 5 * 4
    }

    void 'should fail with maps and lists'() {
        given:
        var data = [
            name  : 'Iván',
            age   : 41,
            childs: [
                [name: 'Judith', age: 14], [name: 'Adriana', age: 11]
            ]
        ]

        expect:
        data.childs.name.first() == 'Adriana'
    }
}
