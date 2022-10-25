package com.luissoares

import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

data class ByRole(
    private val role: String,
    private val exact: Boolean? = true,
    private val selected: Boolean? = null,
    // TODO
    // hidden?: boolean = false,
    // name?: TextMatch,
    // description?: TextMatch,
    // checked?: boolean,
    // pressed?: boolean,
    // current?: boolean | string,
    // expanded?: boolean,
    // queryFallbacks?: boolean,
    // level?: number,
) : By() {
    override fun findElements(context: SearchContext) =
        with(TestingLibraryScript) {
            getWebDriver(context).findAllBy(
                by = "Role",
                mainArgument = role,
                options = mapOf(
                    "exact" to exact,
                    "selected" to selected,
                ).filterValues { it != null },
            )
        }
}
