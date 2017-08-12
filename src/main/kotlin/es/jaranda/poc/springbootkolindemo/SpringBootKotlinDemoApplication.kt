
package es.jaranda.poc.springbootkolindemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootKotlinDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinDemoApplication::class.java, *args)
}
