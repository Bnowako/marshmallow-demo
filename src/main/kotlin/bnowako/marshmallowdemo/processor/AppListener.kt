package bnowako.marshmallowdemo.processor

import bnowako.marshmallowdemo.Slim
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

class AppListener(private val context: ApplicationContext) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        println("app context refreshed")
    }


}
