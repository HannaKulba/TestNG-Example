package eu.senla.testng.example.package1;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Log;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestParametrizedTests {

    @Parameters(value = "name")
    @Test(description = "Параметризированный тестовый метод")
    public void testWithParams(String param) {
        Log.info("Печать имени " + param);
    }

    @DataProvider
    public Object[][] dataProvider() {
        Object[][] loginData = null;
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/loginData.csv"))) {
            List<String[]> r = reader.readAll();
            loginData = new Object[r.size()][r.get(0).length]; //5 rows * 2 columns
            for (int i = 0; i < r.size(); i++) {
                loginData[i][0] = r.get(i)[0];
                loginData[i][1] = r.get(i)[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginData;
    }

    @Test(dataProvider = "dataProvider")
    public void dynamicTest(String login, String password) {
        password = password.replace("a", "*").replace("s", "-");
        Log.info("Пользователь залогинился на сайт под логином '" + login + "' и паролем '" + password + "'");
    }
}
