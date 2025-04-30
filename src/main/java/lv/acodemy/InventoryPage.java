package lv.acodemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
        List<WebElement> inventoryItems;

    private final By addToCartButton = By.xpath("//div[@class='inventory_item']");

    public void addItemTestToTheList(String itemName) {
        for (int i = 0; i < inventoryItems.size(); i++) {
            if(inventoryItems.get(i).getText().contains(itemName)) {
                inventoryItems.get(i).findElement(addToCartButton).click();
                break;
            }
        }

    }
}
