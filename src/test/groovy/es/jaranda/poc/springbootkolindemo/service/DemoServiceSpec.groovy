
package es.jaranda.poc.springbootkolindemo.service

import spock.lang.Specification

class DemoServiceSpec extends Specification {

    def static final DEFAULT_GREET = "Hello Spock!"

    def """Given demoService, when it is called greet should be return a
           standard greet object"""() {
        given:
            def demoService = new DemoServiceImpl(DEFAULT_GREET)
        when:
            def result = demoService.greet()
        then:
            result != null
            result.greet == DEFAULT_GREET
            result.name  == null
    }

}
