
package es.jaranda.poc.springbootkolindemo.service

import es.jaranda.poc.springbootkolindemo.exceptions.ResourceNotFoundException
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

// TODO pending to include unit test
@Service
class KartofelServiceImpl(val kartofelRepository: KartofelRepository)
    : KartofelService {

    override fun findAll() = kartofelRepository.findAll()
    override fun get(id : String) = `try` {
        kartofelRepository.get(id)
                .getOrElseThrow {
                    ResourceNotFoundException(
                            "kartofel with id=${id} not found"
                    )
                }
    }
    override fun save(kartofel : Kartofel) = kartofelRepository.save(kartofel)

}
