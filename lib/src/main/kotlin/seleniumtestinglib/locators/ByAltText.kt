package seleniumtestinglib.locators

import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import seleniumtestinglib.queries.ByType
import seleniumtestinglib.queries.JsType
import seleniumtestinglib.queries.JsType.Companion.asJsFunction
import seleniumtestinglib.queries.JsType.Companion.asJsString
import seleniumtestinglib.queries.executeTLQuery

/**
 * https://testing-library.com/docs/queries/byalttext
 */
data class ByAltText(
    private val text: JsType,
    private val exact: Boolean? = null,
    private val normalizer: String? = null,
) : By() {

    constructor(
        text: String,
        exact: Boolean? = null,
        normalizer: String? = null,
    ) : this(
        text = text.asJsString(),
        exact = exact,
        normalizer = normalizer,
    )

    @Suppress("UNCHECKED_CAST")
    override fun findElements(context: SearchContext): List<WebElement> =
        (getWebDriver(context) as RemoteWebDriver).executeTLQuery(
            by = ByType.AltText,
            textMatch = text,
            options = mapOf(
                "exact" to exact,
                "normalizer" to normalizer?.asJsFunction(),
            ),
        ) as List<WebElement>
}
