package demo

import spock.lang.Specification

class E7_Stubbing extends Specification {

    void 'should return predefined value'() {
        given:
        var stubbedRepository = Stub(UserRepository) {
            findById(_) >> new User('John', 'Doe')
        }

        when:
        var user = stubbedRepository.findById(1)

        then:
        user.name == 'John'
        user.lastName == 'Doe'
    }

    void 'should return different values in every call'() {
        given:
        var stubbedRepository = Stub(UserRepository) {
            findById(_) >>> [
                new User('John', 'Doe'),
                new User('Jane', 'Doe')
            ]
        }

        when:
        var user1 = stubbedRepository.findById(1)
        var user2 = stubbedRepository.findById(1)
        var user3 = stubbedRepository.findById(1)
        var user4 = stubbedRepository.findById(1)

        then:
        user1.name == 'John'
        user2.name == 'Jane'
        user3.name == 'Jane'
        user4.name == 'Jane'
    }

    void 'should return values depending the parameters'() {
        given:
        var stubbedRepository = Stub(UserRepository) {
            findById(20) >> new User('Jane', 'Doe')
            findById(11) >> new User('John', 'Doe')
            findById(_) >> new User('Peter', 'Smith')
        }

        when:
        var user1 = stubbedRepository.findById(11)
        var user2 = stubbedRepository.findById(20)
        var user3 = stubbedRepository.findById(99)
        var user4 = stubbedRepository.findById(42)

        then:
        user1.name == 'John'
        user2.name == 'Jane'
        user3.name == 'Peter'
        user4.name == 'Peter'
    }

    void 'should throw an exception'() {
        given:
        var stubbedRepository = Stub(UserRepository) {
            findById(_) >> { throw new RuntimeException("User does not exist") }
        }

        when:
        stubbedRepository.findById(1)

        then:
        var e = thrown RuntimeException
        e.message == 'User does not exist'
    }

    void 'should stub more than one method'() {
        given:
        var stubbedRepository = Stub(UserRepository) {
            findById(_) >> new User('Peter', 'Smith')
            findAllByLastName('Doe') >> [
                new User('John', 'Doe'),
                new User('Jane', 'Doe')
            ]
        }

        expect:
        stubbedRepository.findById(99).name == 'Peter'
        stubbedRepository.findAllByLastName('Doe').size() == 2
    }
}
