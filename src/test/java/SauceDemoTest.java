import lv.acodemy.InventoryPage;
import lv.acodemy.LoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoTest {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void verifyLoggedInTest() {
        loginPage.authoeize("standard_user", "secret_sauce");

        String productsText = driver.findElement(By.className("title")).getText();
        Assertions.assertThat(productsText)
                .withFailMessage("Are u lalka? Expected title to be 'Products' but was '%s'", productsText)
                .isNotNull()
                .isNotEmpty()
                .startsWith("Prod")
                .endsWith("ucts")
                .isEqualTo("Products");
    }

    @Test
    public void LogInTest() {
        loginPage.authoeize("standard_user", "secret_sauce");
    }

    @Test
    public void AddItemTestToTheList() {
        loginPage.authoeize("standard_user", "secret_sauce");
        inventoryPage.addItemTestToTheList("Onesie");
    }

    @AfterMethod()
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
