package com.gonmunoz.course

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterEach
import java.time.LocalDateTime

open class BaseTest {

    protected fun givenFixedDate(fixedDatetime: LocalDateTime){
        mockkStatic(LocalDateTime::class)
        every {
            LocalDateTime.now()
        } returns fixedDatetime
    }

    @AfterEach
    protected fun cleanMock(){
        unmockkAll()
    }
}