package demo

import spock.lang.Specification

import java.util.stream.Collectors

class E2_Groovy extends Specification {

    void 'should add an element to a list'() {
        given:
        var numbers = DataHelper.someFibonacciNumbers()

        when:
        numbers << 21 // same as: numbers.add(21)

        then:
        numbers.contains(21)
    }

    void 'should make some assertions in elements in a list'() {
        when:
        var users = DataHelper.makeUserList()

        then:
        users.size() == 4
        users.name == ['Sheldon', 'Leonard', 'Raj', 'Howard']

//        println users.name
//        println users*.name
//        println users.collect { it.name }
//        println users.collect { it.getName() }
//        println users.collect { User u -> u.getName() }
//        println users.stream().map { User u -> u.getName() }.collect(Collectors.toList())
//        println users.stream().map { User u -> u.getName() }.toList()

        users.name.sort() == ['Howard', 'Leonard', 'Raj', 'Sheldon']
        users.lastName.collect { it.size() } == [6, 10, 12, 8]
        users.name.min { it.length() } == 'Raj'
    }

    void 'should remove an element from a map'() {
        given:
        var map = DataHelper.makeUserMap()

        when:
        map.remove('name')

        then:
        map.size() == 2
        !map.keySet().contains('name')
        map.lastName == 'López'
        map.get('lastName') == 'López'
        map['lastName'] == 'López'
        map.age == 41
    }

}













