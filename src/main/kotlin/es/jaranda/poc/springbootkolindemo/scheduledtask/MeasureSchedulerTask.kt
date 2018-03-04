
package es.jaranda.poc.springbootkolindemo.scheduledtask

import es.jaranda.poc.springbootkolindemo.utils.log
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

@Component
class MeasureSchedulerTask {

    @Scheduled(fixedDelay=5000)
    fun withCurrentTimeMillis() {
        val executionMillis = measureTimeMillis(::performThreadSleep)

        log.debug("Execution time: $executionMillis milli(s)")
    }

    @Scheduled(fixedDelay=5000)
    fun withNanoTime() {
        val executionNanos = measureNanoTime(::performThreadSleep)

        log.debug("Execution time: $executionNanos nanos(s)")
    }

    private fun performThreadSleep() {
        Thread.sleep(1000L)
    }

}
