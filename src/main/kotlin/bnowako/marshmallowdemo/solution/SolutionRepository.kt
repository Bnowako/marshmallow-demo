package bnowako.marshmallowdemo.solution

import Solution
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class SolutionRepository(val mongoOperations: MongoOperations) {

    fun save(solution: Solution) {
        mongoOperations.save(solution)
    }
}
