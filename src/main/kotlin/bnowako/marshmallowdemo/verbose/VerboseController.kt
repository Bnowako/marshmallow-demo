package bnowako.marshmallowdemo.verbose

import Verbose
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/verbose")
class VerboseController(val repository: VerboseRepository) {

    data class CreateDocumentsRequest(val count: Int)

    @PostMapping
    fun createNDocuments(@RequestBody body: CreateDocumentsRequest) {
        repeat(body.count) {
            repository.save(
                Verbose.getRandom()
            )
        }
    }
}
