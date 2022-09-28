  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
    @tag
Feature: Purchase the item from the site.
  I want to use this template for my feature file
  
  Background: 
  Given I landed on the login page
  
  @smoke
  Scenario Outline: positive test of submitting the order
    Given I login with the username<username> and password<password>
    When I add the product<product> to the cart
    And checkout <product> and submit the order
    Then I verify "THANKYOU FOR THE ORDER." message is displayed on the page

    Examples: 
      | username  							| password 					| product 		|
      | boserupjit13@gmail.com	| STIzNDU2N2E=			|ZARA COAT 3	|
      
      
      
 
      
