Feature: Get to the Aspiration home page
  Scenario: Users should be able to view two products through the spend and save button.
    Given the user accepts the cookie
    When the user clicks on the spend and save link
    Then the user should be able to view two card products Aspiration and Aspiration Plus
    When The user should click on get Aspiration
    Then the user should be able to view a modal containing an input field for an email.
    Then the user is goes back to the page displayed when clicking spend and save.
    When  the user clicks on the get Aspiration plus button
    Then the user should be able to view a modal with monthly and yearly plan.
    Then  I close the browser.
