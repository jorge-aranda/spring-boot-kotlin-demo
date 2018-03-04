
package es.jaranda.poc.springbootkolindemo.test.configuration

import es.jaranda.poc.springbootkolindemo.test.annotations.ExcludeFromTests
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.test.context.TestPropertySource

@TestPropertySource(locations = ["classpath:test.properties"])
@ComponentScan(excludeFilters = [
    ComponentScan.Filter(type = FilterType.ANNOTATION,
            value = [ExcludeFromTests::class])
])
@TestConfiguration
class ApplicationTestConfiguration
