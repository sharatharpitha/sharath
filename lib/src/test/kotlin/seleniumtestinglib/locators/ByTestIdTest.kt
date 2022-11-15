package seleniumtestinglib.locators

import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.remote.RemoteWebDriver
import seleniumtestinglib.DriverLifeCycle
import seleniumtestinglib.coreapi.TextMatch.Regex
import seleniumtestinglib.render
import kotlin.test.Test
import kotlin.test.assertEquals

@ExtendWith(DriverLifeCycle::class)
class ByTestIdTest(private val driver: RemoteWebDriver) {

    @Test
    fun `by test id`() {
        driver.render(""" <div data-testid="custom-element" /> """)

        val result = driver.findElement(ByTestId("custom-element"))

        assertEquals("div", result.tagName)
    }

    @Test
    fun regex() {
        driver.render(""" <div data-testid="custom-element" /> """)

        val result = driver.findElement(ByTestId(Regex("/Custom/i")))

        assertEquals("div", result.tagName)
    }
}
