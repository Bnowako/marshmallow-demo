package bnowako.marshmallowdemo.solution

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/solution")
@RestController
class SolutionController(val repository: SolutionRepository) {

    data class CreateDocumentsRequest(val count: Int)

    @PostMapping
    fun createNDocuments(@RequestBody body: CreateDocumentsRequest) {
        repeat(body.count) {
            repository.save(
                Solution.getRandom()
            )
        }
    }
}
