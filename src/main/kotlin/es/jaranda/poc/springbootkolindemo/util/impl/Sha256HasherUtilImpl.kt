
package es.jaranda.poc.springbootkolindemo.util.impl

import es.jaranda.poc.springbootkolindemo.util.HasherUtil
import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class Sha256HasherUtilImpl : HasherUtil {

    private val md = MessageDigest.getInstance("SHA-256")

    /**
     * @see https://gist.github.com/lovubuntu/164b6b9021f5ba54cefc67f60f7a1a25
     */
    override fun hashSecret(plainSecret: Any): String {
        val bytes = plainSecret.toString().toByteArray()
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }

}
