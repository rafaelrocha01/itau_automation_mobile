package org.br.itau.core;

import io.appium.java_client.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;

public class AppiumLib {

    public AppiumDriver<MobileElement> driver;

    public AppiumLib(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void click(MobileElement element) {
        element.click();
    }


    public void write(MobileElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(MobileElement element) {
        return element.getText();
    }

    public boolean verifyExistsElement(By by) {
        List<MobileElement> element = driver.findElements(by);
        return element.size() > 0;
    }

    public boolean verifyExistsElement(List<MobileElement> element) {
        return element.size() > 0;
    }

    public void clickForText(String text) {
        MobileElement element = driver.findElement(By.xpath("//*[@text='" + text + "']"));
        click(element);
    }

    public void tap(int x, int y) {
        new TouchAction((MobileDriver) driver).tap(PointOption.point(x, y)).perform();
    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void scroll(double inicio, double fim) {
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction((MobileDriver) driver)
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(500)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void swipe(double inicio, double fim) {
        Dimension size = driver.manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction(driver)
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();
    }


    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        new TouchAction(driver)
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();
    }

    public void longPress(MobileElement element) {
        new TouchAction((MobileDriver) driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element))).perform();
    }

    public void seekBar(double posicao) {
        int delta = 50;
        MobileElement seek = driver.findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);

        int xinicial = seek.getLocation().x + delta;
        int x = (int) (xinicial + ((seek.getSize().width - 2 * delta) * posicao));
        System.out.println(x);

        tap(x, y);
    }
}
