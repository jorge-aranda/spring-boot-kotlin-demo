
package es.jaranda.poc.springbootkolindemo.repository

import es.jaranda.poc.springbootkolindemo.model.domain.User
import es.jaranda.poc.springbootkolindemo.model.enums.UserRole
import io.vavr.control.Option
import spock.lang.Specification

class UserRepositorySpec extends Specification {

    def "Should have two users at initialize"() {
        when:
            final def userRepository = new UserRepositoryImpl()
        then:
            userRepository.users == [
                    "1": new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    ),
                    "2": new User(
                            "2",
                            "user",
                            "04f8996da763b7a969b1028ee300756" +
                                    "9eaf3a635486ddab211d512c85b9df8fb",
                            UserRole.USER,
                            true
                    )
            ]
    }

    def "Should have three users after insert new"() {
        given:
            final def user = new User(
                    "3",
                    "john",
                    "hashedPassword",
                    UserRole.USER,
                    false
            )
        when:
            final def userRepository = new UserRepositoryImpl()
            userRepository.save(user)
        then:
            userRepository.users == [
                    "1": new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    ),
                    "2": new User(
                            "2",
                            "user",
                            "04f8996da763b7a969b1028ee300756" +
                                    "9eaf3a635486ddab211d512c85b9df8fb",
                            UserRole.USER,
                            true
                    ),
                    "3": new User(
                            "3",
                            "john",
                            "hashedPassword",
                            UserRole.USER,
                            false
                    )
            ]
            userRepository.users["3"] == new User(
                    "3",
                    "john",
                    "hashedPassword",
                    UserRole.USER,
                    false
            )
    }

    def "Should have two users when call findAll()"() {
        given:
            final def userRepository = new UserRepositoryImpl()
        when:
            final def users = userRepository.findAll()
        then:
            users == [
                new User(
                        "1",
                        "admin",
                        "8c6976e5b5410415bde908bd4dee15d" +
                                "fb167a9c873fc4bb8a81f6f2ab448a918",
                        UserRole.ADMIN,
                        true
                ),
                new User(
                        "2",
                        "user",
                        "04f8996da763b7a969b1028ee300756" +
                                "9eaf3a635486ddab211d512c85b9df8fb",
                        UserRole.USER,
                        true
                )
        ]
    }

    def "Should have three users when call findAll() after insert user"() {
        given:
            final def userRepository = new UserRepositoryImpl()
            final def user = new User(
                    "3",
                    "john",
                    "hashedPassword",
                    UserRole.USER,
                    false
            )
        when:
            userRepository.save(user)
            final def users = userRepository.findAll()
        then:
            users == [
                    new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    ),
                    new User(
                            "2",
                            "user",
                            "04f8996da763b7a969b1028ee300756" +
                                    "9eaf3a635486ddab211d512c85b9df8fb",
                            UserRole.USER,
                            true
                    ),
                    new User(
                            "3",
                            "john",
                            "hashedPassword",
                            UserRole.USER,
                            false
                    )
            ]
    }

    def "Should have two users when call findAll() after update user"() {
        given:
            final def userRepository = new UserRepositoryImpl()
            final def user = new User(
                    "2",
                    "john",
                    "hashedPassword",
                    UserRole.USER,
                    false
            )
        when:
            userRepository.save(user)
            final def users = userRepository.findAll()
        then:
            users == [
                    new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    ),
                    new User(
                            "2",
                            "john",
                            "hashedPassword",
                            UserRole.USER,
                            false
                    )
            ]
    }

    def "Should get null when request Id=3"() {
        given:
            final def userRepository = new UserRepositoryImpl()
        when:
            final def user = userRepository.get("3")
        then:
            user == Option.of(null)
    }

    def "Should get 'admin' when request Id=1"() {
        given:
            final def userRepository = new UserRepositoryImpl()
        when:
            final def user = userRepository.get("1")
        then:
            user == Option.of(
                    new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    )
            )
    }

    def "Should get 'admin' when is requested by username"() {
        given:
            final def userRepository = new UserRepositoryImpl()
        when:
            final def user = userRepository.findByUsername("admin")
        then:
            user == new User(
                            "1",
                            "admin",
                            "8c6976e5b5410415bde908bd4dee15d" +
                                    "fb167a9c873fc4bb8a81f6f2ab448a918",
                            UserRole.ADMIN,
                            true
                    )
    }

    def "Should get null when request no present username"() {
        given:
            final def userRepository = new UserRepositoryImpl()
        when:
            final def user = userRepository.findByUsername("no-exist")
        then:
            user == null
    }

}
