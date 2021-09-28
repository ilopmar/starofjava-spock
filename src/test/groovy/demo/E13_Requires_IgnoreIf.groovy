package demo

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification
import spock.util.environment.Jvm
import spock.util.environment.OperatingSystem

class E13_Requires_IgnoreIf extends Specification {

    @Requires({ OperatingSystem.current.linux })
    void 'should only run on Linux'() {
        expect:
        true
    }

    @Requires({ OperatingSystem.current.windows })
    void 'should only run on Windows'() {
        expect:
        false
    }

    @IgnoreIf({ Jvm.current.java8Compatible })
    void 'should be ignored in Java8+'() {
        expect:
        false
    }

    @IgnoreIf({ Jvm.current.java9 })
    void 'should be ignored only in Java9'() {
        expect:
        true
    }

    @Requires({ isGreetingMsg('Hello') })
    void 'should run for amazing conferences'() {
        expect:
        true
    }

    static boolean isGreetingMsg(String msg) {
        msg in ['Hello', 'Hi']
    }

}
