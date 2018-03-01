
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.model.domain.Kartofel
import es.jaranda.poc.springbootkolindemo.repository.KartofelRepository
import io.vavr.control.Try
import io.vavr.kotlin.`try`
import org.springframework.stereotype.Service

interface KartofelService {
    fun findAll() : List<Kartofel>
    fun get(id : String) : Try<Kartofel>
    fun save(kartofel : Kartofel)
}

@Service
class KartofelServiceImpl(val kartofelRepository: KartofelRepository)
    : KartofelService {

    override fun findAll() = kartofelRepository.findAll()
    override fun get(id : String) = `try` {
        kartofelRepository
                .get(id)
                .getOrElseThrow { NoSuchElementException() }    // TODO use a @ResponseStatus to returns 404
    }
    override fun save(kartofel : Kartofel) = kartofelRepository.save(kartofel)

    // TODO async save operation?
    // TODO async findAll and get operations?

}
