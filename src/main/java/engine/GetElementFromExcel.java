package engine;

import base.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetElementFromExcel {

    public static Workbook book;
    public static Sheet sheet;

    public WebElement element;

    public final String SCENARIO_SHEET_PATH = "elements/KeywordDrivenFramework2.xlsx";




}
