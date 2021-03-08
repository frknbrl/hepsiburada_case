@HepsiburadaTest
Feature: Shipping with new created user account
  Scenario: Create a new account with email and user information
    Given Go to the "http://automationpractice.com/index.php" url
    When Click to "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a" with xpath
    Then Check "Login - My Store" actual page title is true
    When Write to "firstName14@gmail.com" on "email_create" field
    And Click to "SubmitCreate" with id
    And Write to "firstName" on "customer_firstname" field
    And Write to "lastName" on "customer_lastname" field
    And Write to "password" on "passwd" field
    And Write to "firstName" on "firstname" field
    And Write to "lastName" on "lastname" field
    And Write to "address" on "address1" field
    And Write to "city" on "city" field
    And Select to "California" from "id_state" with id
    And Select to "United States" from "id_country" with id
    And Write to "12345" on "postcode" field
    And Write to "0123456789" on "phone_mobile" field
    And Write to "firstName" on "alias" field
    And Click to "submitAccount" with id
    Then Check '//*[@id="header"]/div[2]/div/div/nav/div[1]/a/span' current value and "firstName lastName" reference value with xpath
    And Test closure activities

  Scenario: Shipping a product with newly created user account
    Given Go to the "http://automationpractice.com/index.php" url
    When Click to "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a" with xpath
    Then Check "Login - My Store" actual page title is true
    When Write to "firstName14@gmail.com" on "email" field
    And Write to "password" on "passwd" field
    And Click to "SubmitLogin" with id
    Then Check "My account - My Store" actual page title is true
    When Select to '//*[@id="block_top_menu"]/ul/li[2]/ul/li[3]/a' from '//*[@id="block_top_menu"]/ul/li[2]/a' with hover
    Then Check "Summer Dresses - My Store" actual page title is true
    When Click to '//*[@id="center_column"]/ul/li[3]/div/div[1]/div/a[1]/img' with xpath
    And Get product name '//*[@id="center_column"]/div/div/div[3]/h1', quantity "quantity_wanted" and price "our_price_display"
    And Click to 'add_to_cart' with id
    And Click to '//*[@id="layer_cart"]/div[1]/div[2]/div[4]/a' with xpath
    Then Check "Order - My Store" actual page title is true
#    And Check product name "//*[div[starts-with(@id,'product_')]]/td[2]/p", quantity "//*[div[starts-with(@id,'product_')]]/td[5]/input[2]" and price "total_product"
    And Check price "total_product"
    When Click to '//*[@id="center_column"]/p[2]/a[1]' with xpath
    And Click to '//*[@id="center_column"]/form/p/button' with xpath
    And Click to "uniform-cgv" with id
    And Click to '//*[@id="form"]/p/button' with xpath
    And Click to '//*[@id="HOOK_PAYMENT"]/div[1]/div/p/a' with xpath
    Then Check "My Store" actual page title is true
    When Click to '//*[@id="cart_navigation"]/button' with xpath
    Then Check "Order confirmation - My Store" actual page title is true
    When Click to '//*[@id="header"]/div[2]/div/div/nav/div[1]/a' with xpath
    Then Check "My account - My Store" actual page title is true
    When Click to '//*[@id="center_column"]/div/div[1]/ul/li[1]/a' with xpath
    Then Check "Order history - My Store" actual page title is true
    And Test closure activities
