package bnowako.marshmallowdemo

import bnowako.marshmallowdemo.processor.AppListener
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    fun listener(context: ApplicationContext): AppListener {
        return AppListener(context)
    }
}
