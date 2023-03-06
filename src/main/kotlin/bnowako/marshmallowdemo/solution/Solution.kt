import org.springframework.data.mongodb.core.mapping.Document
import kotlin.random.Random

@Document
class Solution(
    val veryLongFieldName: String,
    val omgHowLongIsThis: String,
    val listOfLongNames: List<SolutionNestedClass>
) {
    companion object {
        fun getRandom(): Solution {
            val randomString = Random.nextInt(0, 1000000).toString()
            return Solution(
                randomString,
                randomString,
                List(10) { SolutionNestedClass(randomString, randomString) }
            )
        }
    }
}

class SolutionNestedClass(
    val iAmAlsoVeryLong: String,
    val nestedVeryLongNames: String
)
