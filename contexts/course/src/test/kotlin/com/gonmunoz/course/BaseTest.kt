package com.gonmunoz.course

import com.gonmunoz.course.domain.Clock
import io.mockk.every
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterEach
import java.time.LocalDateTime

open class BaseTest {
    protected lateinit var clock: Clock
    protected fun givenFixedDate(fixedDatetime: LocalDateTime) {
        every {
            clock.now()
        } returns fixedDatetime
    }

    @AfterEach
    protected fun cleanMock(){
        unmockkAll()
    }
}