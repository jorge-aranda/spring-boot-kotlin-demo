
package es.jaranda.poc.springbootkolindemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Logger factory
 */
fun <R : Any> R.generateLogger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}