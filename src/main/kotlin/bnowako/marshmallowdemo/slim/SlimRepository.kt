package bnowako.marshmallowdemo.slim

import Slim
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class SlimRepository(val mongoOperations: MongoOperations) {

    fun save(slim: Slim) {
        mongoOperations.save(slim)
    }
}
