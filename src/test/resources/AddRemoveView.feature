@ST2
Feature: Add remove view

  Scenario Outline: Add remove view

    Given "Open" browser
    And "Enter URL" browser
    And Enter the following values in the "login" page
    |username|makoklu32@gmail.com|
    |password|China1949.|

    And Click on following button in the "login" page
    |loginBtn|

    And Click on following button in the "GettingStarted" page
    |contactsDropdown|
    |companiesButton|

    And Click on following button in the "Contacts_Companies" page
      |buttonAddView|
      |buttonCreateNewView|
      |<sharedWith>|

    And Enter the following values in the "Contacts_Companies" page
      |inputName|<name>|

    And Click on following button in the "Contacts_Companies" page
      |buttonSave    |
      |buttonAllViews|
    And Hover over on name is "myNameCreated" element in the "Contacts_Companies" sheet
    And Click on following button in the "Contacts_Companies" page
      |options|
      |deleteDropdown|
      |deleteFrame|

  Examples:
    |name|sharedWith|
    |myName|radioButtonPrivate|
    |myName|radioButtonEveryone|
