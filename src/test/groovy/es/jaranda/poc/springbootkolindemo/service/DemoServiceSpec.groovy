
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.properties.DemoConfigurationProperties
import spock.lang.Specification

class DemoServiceSpec extends Specification {

    def static final DEFAULT_GREET = "Hello Spock!"

    private final def demoConfigurationPropertiesMock =
            Mock(DemoConfigurationProperties)

    def """Given demoService, when it is called greet should be return a
           standard greet object"""() {
        given:
            demoConfigurationPropertiesMock.defaultGreet >> DEFAULT_GREET
            demoConfigurationPropertiesMock.greetOcurrencies >> 1
            def demoService = new DemoServiceImpl(
                    demoConfigurationPropertiesMock
            )
        when:
            def result = demoService.greet()
        then:
            result != null
            result.greet == DEFAULT_GREET
            result.name  == null
    }

}
