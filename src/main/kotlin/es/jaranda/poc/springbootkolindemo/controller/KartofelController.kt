
package es.jaranda.poc.springbootkolindemo.controller

import es.jaranda.poc.springbootkolindemo.mapper.KartofelMapper
import es.jaranda.poc.springbootkolindemo.model.dto.request.KartofelCreationRequest
import es.jaranda.poc.springbootkolindemo.service.KartofelService
import org.springframework.web.bind.annotation.*

@RequestMapping("kartofeln")
@RestController
class KartofelController(val kartofelService : KartofelService,
                         val kartofelMapper : KartofelMapper) {

    @GetMapping
    fun findAll() = kartofelService
            .findAll()
            .map(kartofelMapper::toResponse)

    @GetMapping("{id}")
    fun get(@PathVariable("id") id : String) =
            kartofelMapper.toResponse(
                kartofelService.get(id).get()
            )


    @PostMapping
    fun save(@RequestBody kartofel : KartofelCreationRequest) {
        kartofelService.save(
                kartofelMapper.toDomain(kartofel)
        )
    }

}
