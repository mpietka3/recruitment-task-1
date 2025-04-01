Feature: Add product to cart
  Navigate to product site and add

  Scenario: Go to product site and add product to cart
    Given Open browser
    When User goes to home page
    Then Home page is visible

    When User expands devices list
    Then Devices list is visible

    When User picks Smartfony from Bez abonamentu section
    Then Product List is visible

    When User clicks on second element from site
    Then Product page is visible

    When User adds product to cart
    Then Then user gets to basket

    When User goes back to home page
    Then Home page is visible
    And Products number is shown on basket icon
