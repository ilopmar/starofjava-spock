package demo

import spock.lang.Specification

class E6_Mocking extends Specification {

    void 'should send a notification when the someone registers'() {
        given:
        var mockedNotificationService = Mock(NotificationService)
        var userService = new UserService(mockedNotificationService)

        when:
        userService.createUser('Iván', 'López')

        then:
        1 * mockedNotificationService.sendNotification(_, 'User created')
        // 0 * _
    }

    void 'should check constraints on interactions'() {
        given:
        var mockedNotificationService = Mock(NotificationService)
        var userService = new UserService(mockedNotificationService)

        when:
        userService.createUser('Iván', 'López')

        then:
        1 * mockedNotificationService.sendNotification({ it.name == 'Iván' }, 'User created')
    }

    void 'should mock an implementation'() {
        given:
        var user = new User('Iván', 'López')
        var mockedEmailService = Mock(EmailService)

        when:
        mockedEmailService.sendEmail(user, 'How are you?')

        then:
        1 * mockedEmailService.sendEmail(user, 'How are you?')
    }

    void 'should check the order'() {
        given:
        var user = new User('Iván', 'López')
        var mockedNotificationService = Mock(NotificationService)

        when:
        mockedNotificationService.sendNotification(user, 'msg1')
        mockedNotificationService.sendNotification(user, 'msg2')
        mockedNotificationService.sendNotification(user, 'msg3')

        then:
        1 * mockedNotificationService.sendNotification(user, 'msg1')

        then:
        1 * mockedNotificationService.sendNotification(user, 'msg2')

        then:
        1 * mockedNotificationService.sendNotification(user, 'msg3')
    }

    void 'should mock static methods'() {
        given:
        DataHelper.metaClass.static.currentTime = { -> 42 }

        expect:
        DataHelper.currentTime() == 42
    }
}





















