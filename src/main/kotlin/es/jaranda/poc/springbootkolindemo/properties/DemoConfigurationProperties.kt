
package es.jaranda.poc.springbootkolindemo.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Validated
@Configuration
@ConfigurationProperties(prefix = "es.jaranda.poc.springbootkolindemo.demo")
class DemoConfigurationProperties {

    /** Default greet message in case of no message passed as parameter */
    @NotNull
    lateinit var defaultGreet : String

    /** Number of repetitions of greeting on console log */
    @NotNull
    @Min(1)
    lateinit var greetOcurrencies: Integer

}
