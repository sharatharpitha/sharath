package com.luissoares.userinteractions

import com.luissoares.DriverLifeCycle
import com.luissoares.interactions.tripleClick
import com.luissoares.interactions.user
import com.luissoares.isChecked
import com.luissoares.locators.ByRole
import com.luissoares.render
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.remote.RemoteWebDriver
import kotlin.test.assertTrue

@ExtendWith(DriverLifeCycle::class)
class TripleClickTest(private val driver: RemoteWebDriver) {

    @Test
    fun `triple click`() {
        driver.render(
            """ <input type="checkbox" /> """
        )
        val checkbox = driver.findElement(ByRole("checkbox"))

        driver.user.tripleClick(checkbox)

        assertTrue(checkbox.isChecked)
    }
}