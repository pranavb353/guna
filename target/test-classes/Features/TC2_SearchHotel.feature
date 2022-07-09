@SearchHotel
Feature: Verifying Adactin Hotel Search Page

  Scenario Outline: Verify Adactin Search Hotel Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<CheckIn>","<CheckOut>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User Should Verify Message After Search "Select Hotel"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | CheckIn    | CheckOut   | AdultsPerRoom | ChildrenPerRoom |
      | Pranavguna | 69T5BW   | London   | Hotel Creek | Standard | 2 - Two  | 26/06/2022 | 27/06/2022 | 2 - Two       | 2 - Two         |

  Scenario Outline: Verify Adactin Search Hotel Page With Mandatory Feilds Only
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page "<Location>","<NoOfRoom>","<CheckIn>","<CheckOut>" and "<AdultsPerRoom>"
    Then User Should Verify Message After Search "Select Hotel"

    Examples: 
      | UserName   | Password | Location | NoOfRoom | CheckIn    | CheckOut   | AdultsPerRoom |
      | Pranavguna | 69T5BW   | London   | 2 - Two  | 26/06/2022 | 27/06/2022 | 2 - Two       |

  Scenario Outline: Verify Adactin Search Hotel Page With Invalid CheckIn & CheckOut Date
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page "<Location>","<NoOfRoom>","<CheckIn>","<CheckOut>" and "<AdultsPerRoom>"
    Then User Should Verify Invalid Date Error Message After Search "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | CheckIn    | CheckOut   | AdultsPerRoom | ChildrenPerRoom |
      | Pranavguna | 69T5BW   | London   | Hotel Creek | Standard | 2 - Two  | 26/06/2024 | 27/06/2022 | 2 - Two       | 2 - Two         |

  Scenario Outline: Verify Adactin Search Hotel Page Without Filling Any Details
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Submit Search Hotel Page Without Filling Any Details
    Then User Should Verify Error Message After Search "Please Select a Location"

    Examples: 
      | UserName   | Password |
      | Pranavguna | 69T5BW   |
