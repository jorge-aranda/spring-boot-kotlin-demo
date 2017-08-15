
package es.jaranda.poc.springbootkolindemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Logger factory
 *
 * @see https://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin
 */
fun <R : Any> R.generateLogger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}