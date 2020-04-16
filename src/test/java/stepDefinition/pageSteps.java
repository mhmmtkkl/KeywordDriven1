package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import engine.KeyWordEngine;

import java.util.List;

public class pageSteps {

    KeyWordEngine keyWordEngine = keyWordEngine = new KeyWordEngine();


    @Given("^\"([^\"]*)\" browser$")
    public void browser(String action) {
        keyWordEngine.startSteps(action);
    }

    @And("^Enter the following values in the \"([^\"]*)\" page$")
    public void enter_the_following_values_in_the_page(String sheetName, DataTable ElementAndValues) {

     List<List<String>> allElementAndValues = ElementAndValues.raw();

     System.out.println(allElementAndValues.size());

    for(int i = 0; i <allElementAndValues.size() ; i++ ){

        System.out.println( i + " i is here ");
        String elementName = allElementAndValues.get(i).get(0);
        String value = allElementAndValues.get(i).get(1);
        System.out.println(elementName);
        System.out.println(value);
        keyWordEngine.sendKeysFunctionality(elementName, sheetName , value);


    }

    }

    @And("^Click on following button in the \"([^\"]*)\" page$")
    public void click_on_following_button_in_the_page(String sheetName, DataTable ElementName) {

        List<List<String>> allElementAndValues = ElementName.raw();

        for(int i = 0; i <allElementAndValues.size() ; i++ ){

            System.out.println(allElementAndValues.get(i).size());
            System.out.println(allElementAndValues);

            String elementName = allElementAndValues.get(i).get(0);

            System.out.println(elementName);
            keyWordEngine.clickFunctionality(elementName, sheetName );


        }
    }
    @And("^Hover over on name is \"([^\"]*)\" element in the \"([^\"]*)\" sheet$")
    public void hover_over_on_element_number_name_is_element_in_the_sheet( String elementName, String sheetName) {

        keyWordEngine.hoverOver( elementName , sheetName);

    }


    @Given("^Verify the data as expected int he \"([^\"]*)\" page$")
    public void verify_the_data_as_expected_int_he_page(String sheetName, DataTable elements) {

        List<List<String>> allElementAndValues = elements.raw();

        System.out.println(allElementAndValues.size());

        for(int i = 0; i <allElementAndValues.size() ; i++ ){

            System.out.println( i + " i is here ");
            String expectedResult = allElementAndValues.get(i).get(0);
            String elementName = allElementAndValues.get(i).get(1);
            System.out.println(elementName);
            System.out.println(expectedResult);
            keyWordEngine.verifyDataIsDisplayed(elementName, expectedResult , sheetName  );


        }

    }

    @Given("^Verify Element is deleted succesfully in the \"([^\"]*)\" page$")
    public void verify_Element_is_not_deleted_succesfully_in_the_page(String sheetName, DataTable elements) {


        List<List<String>> allElementAndValues = elements.raw();

        System.out.println(allElementAndValues.size());

        for(int i = 0; i <allElementAndValues.size() ; i++ ){

            System.out.println( i + " i is here ");
            String expectedResult = allElementAndValues.get(i).get(0);
            String elementName = allElementAndValues.get(i).get(1);
            System.out.println(elementName);
            System.out.println(expectedResult);
            keyWordEngine.verifyDataIsRemoved(elementName, expectedResult , sheetName  );


        }

    }




}
