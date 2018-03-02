
package es.jaranda.poc.springbootkolindemo.util

interface HasherUtil {

    fun hashSecret(plainSecret : Any) : String

}