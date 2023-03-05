package bnowako.marshmallowdemo.slim

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/slim")
class SlimController(val repository: SlimRepository) {

    data class CreateNDocs(val count: Int)


    @PostMapping
    fun createNDocs(@RequestBody body: CreateNDocs) {
        repeat(body.count) {
            repository.save(
                Slim.getRandom()
            )
        }
    }
}
