package bnowako.marshmallowdemo.solution

import Solution
import SolutionNestedClass
import org.bson.Document
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions

class SolutionConverter(private val nestedSolutionConverter: NestedSolutionConverter) : Converter<Solution, Document> {
    override fun convert(source: Solution): Document {
        val dbo = Document()
        dbo["v"] = source.veryLongFieldName
        dbo["o"] = source.omgHowLongIsThis
        dbo["l"] = source.listOfLongNames.map { nestedSolutionConverter.convert(it) }
        return dbo
    }

}

class NestedSolutionConverter : Converter<SolutionNestedClass, Document> {
    override fun convert(source: SolutionNestedClass): Document {
        val dbo = Document()
        dbo["i"] = source.iAmAlsoVeryLong
        dbo["n"] = source.nestedVeryLongNames
        return dbo
    }

}

class SolutionReadConverter() : Converter<Document, Solution> {
    override fun convert(source: Document): Solution {
        //todo add nested converter
        return Solution(
            source["v"] as String,
            source["o"] as String,
            listOf()
        )
    }
}

@Configuration
class ConvertersConfig {

    @Bean
    fun co(): MongoCustomConversions {
        return MongoCustomConversions(
            listOf(
                SolutionConverter(NestedSolutionConverter()),
                SolutionReadConverter()
            )
        )
    }
}
