package eu.senla.testng.example.package2;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CustomerProperty;
import utils.Log;

import java.util.HashMap;

public class TestDependencyTests {
    private HashMap<String, String> dataMap = (HashMap<String, String>) CustomerProperty.getCustomerData("test.properties");

    @Test
//    @Test(priority = 1)
    public void openWebPage() {
        String actualWebPageName = dataMap.get("webPage");
        Assert.assertEquals(actualWebPageName, "www.books.com", "Страница не открыта");
        Log.info("Страница открыта");
    }

    @Test(dependsOnMethods = "openWebPage")
//    @Test(priority = 2)
    public void login() {
        String login = dataMap.get("login");
        Assert.assertTrue(login.equalsIgnoreCase("admin"), "Что-то пошло не так, попробуйте залогиниться снова");
        Log.info("Логин выполнен успешно");
    }

    @Test(dependsOnMethods = "login")
    //    @Test(priority = 3)
    public void goToBookList() {
        String bookPage = dataMap.get("bookPage");
        Assert.assertTrue(bookPage.equalsIgnoreCase("www.books.com/bookList"), "Открыта иная страница");
        Log.info("Страница со списком книг открыта");
    }

    @Test(dependsOnMethods = "goToBookList")
    //    @Test(priority = 4)
    public void addBookToCart() {
        String statusBook = dataMap.get("bookAdded");
        Assert.assertTrue(Boolean.parseBoolean(statusBook), "Книга не добавлена в корзину");
        Log.info("Книга добавлена в корзину");
    }

    @Test(dependsOnMethods = "addBookToCart")
    //    @Test(priority = 5)
    public void checkBookInCart() {
        String bookName = dataMap.get("bookName");
        Assert.assertTrue(bookName.equalsIgnoreCase("50 Shades of Grey"), "Книга не находится в корзине");
        Log.info("Книга находится в корзине");
    }
}
