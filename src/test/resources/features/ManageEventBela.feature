@AndroidFeatures
Feature: Manage Event
  I need to confirm how many people going to the event
  in order to know how much beer
  that I need to buy

  Scenario: Register in the event
    Given I not confirm me in the event 'Halloweeen 2017'
    When I try to confirm my register
    Then the app send a confirmation message 'Registered'


  Scenario: Unregister in the event
    Given I am already register in to the event 'Halloweeen 2017'
    When I try to unregister me
    Then the app send a confirmation message 'Register'
