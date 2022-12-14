package seleniumtestinglib.jestdom

import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.remote.RemoteWebDriver
import seleniumtestinglib.DriverLifeCycle
import seleniumtestinglib.queries.ByType.Role
import seleniumtestinglib.queries.getBy
import seleniumtestinglib.render
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@ExtendWith(DriverLifeCycle::class)
class EnabledTest(private val driver: RemoteWebDriver) {

    @Test
    fun disabled() {
        driver.render("<div><input type='text' disabled /></div>")

        val input = driver.getBy(Role, "textbox")
        assertTrue(input.isDisabled)
        expect(input).toBeDisabled()
    }

    @Test
    fun `not disabled`() {
        driver.render("<a href=\"...\" disabled>link</a>")

        val input = driver.getBy(Role, "link")
        assertFalse(input.isDisabled)
        expect(input).not.toBeDisabled()
    }

    @Test
    fun enabled() {
        driver.render("<div><input type='text' /></div>")

        val input = driver.getBy(Role, "textbox")
        assertTrue(input.isEnabled)
        expect(input).toBeEnabled()
    }

    @Test
    fun `not enabled`() {
        driver.render("<div><input type='text' disabled /></div>")

        val input = driver.getBy(Role, "textbox")
        expect(input).not.toBeEnabled()
    }
}
