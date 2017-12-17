
package es.jaranda.poc.springbootkolindemo.repository

import es.jaranda.poc.springbootkolindemo.model.domain.Kartofel
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.stereotype.Repository

interface KartofelRepository {
    fun findAll() : List<Kartofel>
    fun get(id : String) : Option<Kartofel>
    fun save(kartofel : Kartofel)
}

@Repository
class KartofelRepositoryImpl : KartofelRepository {

    private val kartofeln : MutableMap<String, Kartofel> = mutableMapOf()

    override fun findAll() = kartofeln.values.toList()
    override fun get(id : String) = kartofeln[id].option()
    override fun save(kartofel : Kartofel) {
        kartofeln[kartofel.id] = kartofel
    }

}
