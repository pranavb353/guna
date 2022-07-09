@Login
Feature: Verifying Adactin Hotel Login Page

  Scenario Outline: Verify Adactin Login With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"

    Examples: 
      | UserName   | Password |
      | Pranavguna | 69TBBW   |

  Scenario Outline: Verify Adactin Login With Valid Credentials With ENTER key
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>" With Help of ENTER key
    Then User Should Verify Welcome Message After Login "Hello Pranavguna!"

    Examples: 
      | UserName   | Password |
      | Pranavguna | 69TBBW   |

  Scenario Outline: Verify Adactin Login With Invalid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify Login Error Message Contains After Login "Invalid Login Details or Your Password Might Have Expired"

    Examples: 
      | UserName   | Password |
      | Pranavguna |     5478 |
