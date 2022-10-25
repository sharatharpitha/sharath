package com.luissoares

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds

fun <T> WebDriver.waitUntil(fn: (WebDriver) -> T): T {
    val implicitWaitTimeout = manage().timeouts().implicitWaitTimeout
    val timeout = implicitWaitTimeout.seconds.takeIf { it > 0 } ?: 5
    return WebDriverWait(this, ofSeconds(timeout))
        .pollingEvery(ofMillis(100))
        .until(fn)
}