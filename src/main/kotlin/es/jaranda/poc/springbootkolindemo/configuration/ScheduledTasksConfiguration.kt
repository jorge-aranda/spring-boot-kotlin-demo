
package es.jaranda.poc.springbootkolindemo.configuration

import es.jaranda.poc.springbootkolindemo.test.annotations.ExcludeFromTests
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@ExcludeFromTests
@EnableScheduling
@Configuration
class ScheduledTasksConfiguration
