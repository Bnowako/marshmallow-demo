package bnowako.marshmallowdemo.verbose

import Verbose
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component


@Component
class VerboseRepository(val mongoOperations: MongoOperations) {

    fun save(verbose: Verbose) {
        mongoOperations.save<Verbose>(verbose)
    }

}
