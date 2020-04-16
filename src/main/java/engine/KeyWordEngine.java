package engine;

import base.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KeyWordEngine {

    public WebDriver driver;
    public Properties prop;

    public static Workbook book;
    public static Sheet sheet;


    public Base base;

    public WebElement element;

    public final String SCENARIO_SHEET_PATH = "C:\\Users\\JuNiOr\\IdeaProjects\\KeywordFramework2\\src\\main\\java\\elements\\KeywordDrivenFramework2.xlsx";

    WebDriverWait wait =null;

    GetElementFromExcel getElementFromExcel = null;


    public WebElement findElement(String element_Name,String sheetName) {

        String locatorType = null;

        String locatorValue = null;

        FileInputStream file = null;

        try {
            file = new FileInputStream(SCENARIO_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        int k = 0;

        for(int i = 0 ; i<sheet.getLastRowNum() ; i++){

            String element_name_fromExcel = sheet.getRow(i+1).getCell(k).toString().trim();

            if(element_name_fromExcel.equalsIgnoreCase(element_Name)){
                locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
                locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
                break;
            }
        }

        System.out.println(locatorType);
        System.out.println(locatorValue);

        switch (locatorType){

            case "id":
                element =  driver.findElement(By.id(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "text":
                element = driver.findElement(By.xpath("//*[text()=\""+element_Name+"\"]"));
            default:
                break;
        }
        return element;
    }

    public List<WebElement> findElements(String element_Name,String sheetName) {

        List<WebElement> allElements = new ArrayList<>();


        String locatorType = null;

        String locatorValue = null;

        FileInputStream file = null;

        try {
            file = new FileInputStream(SCENARIO_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        int k = 0;

        System.out.println(sheet.getLastRowNum());
        for(int i = 0 ; i<sheet.getLastRowNum() ; i++){

            String element_name_fromExcel = sheet.getRow(i+1).getCell(k).toString().trim();

            if(element_name_fromExcel.equalsIgnoreCase(element_Name)){
                locatorType = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
                locatorValue = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
                break;
            }
        }

        System.out.println(locatorType);
        System.out.println(locatorValue);

        switch (locatorType){

            case "id":
                allElements =  driver.findElements(By.id(locatorValue));
                break;
            case "xpath":
                allElements =  driver.findElements(By.xpath(locatorValue));
                break;
            case "css":
                allElements =  driver.findElements(By.cssSelector(locatorValue));
                break;
            case "text":
                allElements =   driver.findElements(By.xpath("//*[text()=\""+element_Name+"\"]"));
            default:
                break;
        }
        return allElements;
    }

    public void sendKeysFunctionality(String elementName , String sheetName , String value){

        WebElement sendkeysElemenet = findElement(elementName , sheetName);

        wait = new WebDriverWait(driver , 10);

        waitUntilVisible(sendkeysElemenet);

        sendkeysElemenet.sendKeys(value);

    }

    public void clickFunctionality(String elementName , String sheetName ){

        WebElement  clickElement = findElement(elementName , sheetName);

        waitUntilClickable(clickElement );

        clickElement.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void verifyDataIsDisplayed(String elementName , String expectedResult , String sheetName){

        WebElement  clickElement = findElement(elementName , sheetName);

        Assert.assertEquals(clickElement.getText() , expectedResult);

    }

    public void verifyDataIsRemoved(String elementName , String expectedResult , String sheetName){

        List<WebElement>  clickElement = findElements(elementName , sheetName);

        for(int i = 0 ; i<clickElement.size() ; i++){

            Assert.assertTrue( !clickElement.get(i).equals(expectedResult));
        }

    }


    public void waitUntilClickable(WebElement waitElement){

        wait = new WebDriverWait(driver , 10);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(waitElement));
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public void waitUntilVisible(WebElement waitElement){

        wait = new WebDriverWait(driver , 10);

        try {
            wait.until(ExpectedConditions.visibilityOf(waitElement));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void hoverOver( String element_name , String SheetName){
        WebElement overElement = findElement(element_name , SheetName);


        Actions action = new Actions(driver);

        action.moveToElement(overElement).perform();

    }

    public void startSteps(String whichAction){

        switch (whichAction){

            case"Open":
                base = new Base();
                prop = base.init_properties();
                driver = base.init_driver(prop.getProperty("browser"));
                break;

            case"Enter URL":
                driver.get( prop.getProperty("url"));
                break;

            case "quit":
                driver.quit();
                break;

            default:
                break;
        }




    }

}
