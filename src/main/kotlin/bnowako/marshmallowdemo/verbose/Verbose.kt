import bnowako.marshmallowdemo.Slim
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.random.Random

@Document
@Slim
class Verbose(
    val veryLongFieldName: String,
    val omgHowLongIsThis: String,
    val listOfLongNames: List<VerboseNestedClass>
) {
    companion object {
        fun getRandom(): Verbose {
            val randomString = Random.nextInt(0, 1000000).toString()
            return Verbose(
                randomString,
                randomString,
                List(10) { VerboseNestedClass(randomString, randomString) }
            )
        }
    }
}

class VerboseNestedClass(
    val iAmAlsoVeryLong: String,
    val nestedVeryLongNames: String
)
