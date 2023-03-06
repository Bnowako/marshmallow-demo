package bnowako.marshmallowdemo.solution

import Solution
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun getDocument(): Solution? {
        return repository.findOne()
    }
}
