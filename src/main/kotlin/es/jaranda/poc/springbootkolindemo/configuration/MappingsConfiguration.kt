
package es.jaranda.poc.springbootkolindemo.configuration

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class MappingsConfiguration {
    @Bean
    fun objectMapper(jackson2ObjectMapperBuilder: Jackson2ObjectMapperBuilder)
            : ObjectMapper {
        return jackson2ObjectMapperBuilder
                .createXmlMapper(false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .modules(
                        // Kotlin immutable POJO be compatible with Jackson
                        KotlinModule()
                )
                .featuresToDisable(
                        // Using ISO-8601 to serialize/deserialize dates instead
                        // of timestamps
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
                )
                .build()
    }
}
