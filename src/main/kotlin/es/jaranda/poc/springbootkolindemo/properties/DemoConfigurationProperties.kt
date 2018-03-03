
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

    @NotNull
    lateinit var defaultGreet : String

    @NotNull
    @Min(1)
    lateinit var greetOcurrencies: Integer

}
