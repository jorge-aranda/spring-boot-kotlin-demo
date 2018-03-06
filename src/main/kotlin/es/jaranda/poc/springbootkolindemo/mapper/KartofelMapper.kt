
@file:JvmName("KartofelMappingFunctions")

package es.jaranda.poc.springbootkolindemo.mapper

import es.jaranda.poc.springbootkolindemo.model.domain.Kartofel
import es.jaranda.poc.springbootkolindemo.model.dto.request.KartofelCreationRequest
import es.jaranda.poc.springbootkolindemo.model.dto.response.KartofelResponse
import org.springframework.stereotype.Component

interface KartofelMapper {
    fun toDomain(request : KartofelCreationRequest) : Kartofel
    fun toResponse(domain : Kartofel) : KartofelResponse
}

@Component
class KartofelMapperImpl : KartofelMapper {
    override fun toDomain(request: KartofelCreationRequest) = request.toDomain()
    override fun toResponse(domain: Kartofel) = domain.toResponse()
}

fun KartofelCreationRequest.toDomain() =
        Kartofel(id=this.id, message=this.message)

fun Kartofel.toResponse() =
        KartofelResponse(id=this.id, message=this.message)
