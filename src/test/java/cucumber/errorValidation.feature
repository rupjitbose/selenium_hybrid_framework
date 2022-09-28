Feature: Purchase the item from the site.
  I want to use this template for my feature file
  
  
  @regression
  Scenario Outline: positive test of submitting the order
  	Given I landed on the login page
    Given I login with the username<username> and password<password>
    Then I verify "Incorrect email or password." message is displayed

    Examples: 
      | username  							| password 			|
      | boserupjit13@gmail.com	| STIznDU2N2E=	|