Feature: User form fill

@sanity @regression
  Scenario: Successful Summit
    Given the user will land on Protocommerce
    When the user enters all reqired fields (username: "Hemanth", email: "hemanth@gmail.com", pass: "1234@56" ,date:"01/01/2001")
    And the user clicks on the summit button
    Then the user should see a Success message