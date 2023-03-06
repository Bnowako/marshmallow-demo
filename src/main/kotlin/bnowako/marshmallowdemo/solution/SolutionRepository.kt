package bnowako.marshmallowdemo.solution

import Solution
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class SolutionRepository(val mongoOperations: MongoOperations) {

    fun save(solution: Solution) {
        mongoOperations.save(solution)
    }

    fun findOne(): Solution? {
        return mongoOperations.findOne(Query())
    }
}
