
package es.jaranda.poc.springbootkolindemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Logger factory
 *
 * @see https://stackoverflow.com/questions/34416869/idiomatic-way-of-logging-in-kotlin
 * @see https://kotlinlang.org/docs/reference/extensions.html
 */
private fun <R : Any> generateLogger(item : R) =
        lazy { LoggerFactory.getLogger(item.javaClass) }

val <R : Any> R.log : Logger get() = generateLogger(this).value