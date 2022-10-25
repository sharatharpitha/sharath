package com.luissoares

import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

/**
 * https://testing-library.com/docs/queries/byalttext
 */
data class ByAltText(
    private val text: String,
    private val exact: Boolean = true,
) : By() {
    override fun findElements(context: SearchContext) =
        with(TestingLibraryScript) {
            getWebDriver(context).findAllBy(
                by = "AltText",
                mainArgument = text,
                options = mapOf("exact" to exact),
            )
        }
}
