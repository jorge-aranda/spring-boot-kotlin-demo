
package es.jaranda.poc.springbootkolindemo

import es.jaranda.poc.springbootkolindemo.test.configuration.ApplicationTestConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [ApplicationTestConfiguration::class])
class SpringBootKotlinDemoApplicationIT {

    @Test
    fun contextLoads() {
        // only test spring context
        Thread.sleep(100000L) // FIXME remove as soon as is working @ExcludeFromTests annotation
    }

}
