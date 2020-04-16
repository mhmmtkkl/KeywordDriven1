@ST3
Feature: Ticket Add

  Scenario Outline: Ticket add and close it


    Given "Open" browser
    And "Enter URL" browser
    And Enter the following values in the "login" page
      |username|makoklu32@gmail.com|
      |password|China1949.|

    And Click on following button in the "login" page
      |loginBtn|

    And Click on following button in the "GettingStarted" page
      |ServiceDropdown|
      |TicketsButton|

    And Click on following button in the "GettingStarted" page
      |ServiceDropdown|
      |TicketsButton|

    And Click on following button in the "Tickets" page
      |buttonCreateTicket|
      |ticketStatus      |
      |<ticketStatus>    |
      |dropdownSource    |
      |<dropdownSource>  |
      |dropdownPriority  |
      |<dropdownPriority>|

    And Enter the following values in the "Tickets" page
      |inputTicketName| <name>|
      |inputCreateDate| <date>|
      |inputTicketDescription|<description>|

    And Click on following button in the "Tickets" page
    |createButton|

    And Click on following button in the "GettingStarted" page
      |ServiceDropdown|
      |TicketsButton|

    And Click on following button in the "Tickets" page
      |ElementTicket|

    And Verify the data as expected int he "Tickets" page
    |<name>|getTextTicketName|
    |<description>|getTextTicketDescription|
    |<dropdownPriority>|getTextPriority|

    And Click on following button in the "Tickets" page
      |buttonActions|
      |buttonDelete|
      |buttonDeleteTicket|

    And Verify Element is deleted succesfully in the "Tickets" page
    |<name>|elementAllTickets|

    Examples:
    |ticketStatus           |dropdownSource |dropdownPriority|name     |date      | description         |
    |buttonWaitingOnContact |buttonEmail    |Low        |nameOfThe|05/15/2020| bestDesctiption     |
    |buttonWaitingOnUs      |buttonForm     |Medium    |nameOfThe|05/15/2020| bestDesctiption     |
    |buttonWaitingOnClosed  |buttonPhone    |High      |nameOfThe|05/15/2020| bestDesctiption     |
    |buttonWaitingOnNew     |buttonChat     |High      |nameOfThe|05/15/2020| bestDesctiption     |
