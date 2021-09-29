package demo

import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

class E12_ConfineMetaClass extends Specification {

    @ConfineMetaClassChanges(String)
    void 'should have sayHi method on String'() {
        given:
        String.metaClass.sayHi = { -> "Hi ${delegate}" }

        expect:
        "StarofJava".sayHi() == 'Hi StarofJava'
    }

    void 'should not have sayHi method on String'() {
        when:
        "StarofJava".sayHi()

        then:
        thrown MissingMethodException
    }
}
