@CancelBooking
Feature: Verifying Adactin Hotel Cancel page

  Scenario Outline: Verify Adactin Hotel Cancelling Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User Should Verify Message After Search "Select Hotel"
    And User Should Select Hotel
    Then User Should Verify Message After Select "Book A Hotel"
    And User Should Book Hotel "<FirstName>","<LastName>","<Address>" and Save Generated Order ID
      | CreditCardType   | CreditCardNo     | Month    | Year | CCVNo |
      | American Express | 1234567887654321 | December | 2022 |   321 |
      | VISA             | 1234567887654321 | December | 2022 |   321 |
      | Master Card      | 1234567887654321 | December | 2022 |   321 |
    Then User Should Verify Message After Booking "Booking Confirmation"
    And User Should Cancel The Order Id
    Then User Should Verify Message After Cancelling "The booking has been cancelled."

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | Address |
      | Pranavguna | 69T5BW   | London   | Hotel Creek | Standard | 1 - One  | 21/06/2022 | 23/06/2022 | 2 - Two       | 1 - One         | pranav    | guna     | chennai |

  Scenario Outline: Verify Adactin Hotel Cancelling Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"
    And User Should Cancel The Previously Booked Order Id "<Order Id>"
    Then User Should Verify Message After Cancelling "The booking has been cancelled."

    Examples: 
      | UserName   | Password | Order Id   |
      | Pranavguna | 69T5BW   | 6UVKC4GSQF |
