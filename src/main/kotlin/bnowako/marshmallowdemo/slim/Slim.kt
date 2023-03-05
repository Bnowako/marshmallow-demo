import org.springframework.data.mongodb.core.mapping.Document
import kotlin.random.Random

@Document
class Slim(
    val s: String,
    val h: String,
    val o: List<VerboseNestedClass>
) {
    companion object {
        fun getRandom(): Slim {
            val randomString = Random.nextInt(0, 1000000).toString()
            return Slim(
                randomString,
                randomString,
                List(10) { VerboseNestedClass(randomString, randomString) }
            )
        }
    }
}

class SlimNestedClass(
    val r: String,
    val t: String
)
