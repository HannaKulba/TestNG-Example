package eu.senla.testng.example.package1;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.Log;

public class TestAnnotations {

    @BeforeSuite
    public void beforeSuite() {
        Log.info("Метод выполняется перед набором тестов, объединенных в suit");
    }

    @BeforeTest
    public void beforeTest() {
        Log.info("Метод выполняется перед каждым методом, помеченным аннотацией @Test в классе, указанном внутри тега <test>");
    }

    @BeforeGroups(groups = {"test"})
    public void beforeGroups() {
        Log.info("Метод выполняется перед набором тестов, объединенных в группы и указанных внутри тега <group>");
    }

    @BeforeClass
    public void beforeClass() {
        Log.info("Метод выполняется перед набором тестов, размещенных в текущем классе");
    }

    @BeforeMethod
    public void setUp() {
        Log.info("Метод выполняется перед каждым методом, помеченным аннотацией @Test");
    }

    @Test(description = "Простейший тест", groups = {"test"})
    public void testSum() {
        Log.info("Выполнение тестового метода");
        Assert.assertEquals(2 + 3, 5, "Сумма цифр не совпадает с ожидаемым результатом");
    }

    @Test(description = "Простейший тест_2", enabled = false)
    public void testPrint() {
        Log.info("Выполнение тестового метода_2. Печать данных в консоли");
    }

    @AfterMethod
    public void tearDown() {
        Log.info("Метод выполняется после каждого метода, помеченного аннотацией @Test");
    }

    @AfterClass
    public void afterClass() {
        Log.info("Метод выполняется после набора тестов, размещенных в текущем классе");
    }

    @AfterGroups(groups = {"test"})
    public void afterGroups() {
        Log.info("Метод выполняется после набора тестов, объединенных в группы и указанных внутри тега <group>");
    }

    @AfterTest
    public void afterTest() {
        Log.info("Метод выполняется после каждого метода, помеченного аннотацией @Test в классе, указанном внутри тега <test>");
    }

    @AfterSuite
    public void afterSuite() {
        Log.info("Метод выполняется после набора тестов, объединенных в suit");
    }

}
