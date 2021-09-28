package demo

import spock.lang.Specification

class E10_Shared extends Specification {

    var user = new User('Iván', 'López')

    void 'should print user'() {
        expect:
        println user
    }

    void 'should println user (II)'() {
        expect:
        println user
    }

}
