package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Denglu {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://139.199.95.127:8093/#/access/signin";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDenglu() throws Exception {
    driver.get(baseUrl + "/#/access/signin");
    driver.findElement(By.xpath("//input[@type='password']")).clear();
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sany@2017");
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sany");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/index/dashboardManageService.js | ]]
    driver.findElement(By.xpath("//div[@id='app']/div[3]/div/div/nav/ul/li[8]/a/span[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/index/dashboardManageService.js | ]]
    driver.findElement(By.linkText("风机管理")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.linkText("添加风机")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.cssSelector("a.ui-select-choices-row-inner")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.name("turbineName")).clear();
    driver.findElement(By.name("turbineName")).sendKeys("3432");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.name("ratedPower")).clear();
    driver.findElement(By.name("ratedPower")).sendKeys("3232");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    new Select(driver.findElement(By.name("genType"))).selectByVisibleText("SANY1500高速");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.cssSelector("select[name=\"genType\"] > option[value=\"0\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    new Select(driver.findElement(By.name("turbineType"))).selectByVisibleText("905");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.cssSelector("option[value=\"905\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.name("turbineLoop")).clear();
    driver.findElement(By.name("turbineLoop")).sendKeys("3232");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    new Select(driver.findElement(By.name("protocol"))).selectByVisibleText("SY8215(1500KW)");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.cssSelector("select[name=\"protocol\"] > option[value=\"0\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=js/services/config/dictionaryManageService.js | ]]
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
