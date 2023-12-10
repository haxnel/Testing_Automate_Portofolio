Feature: Checkout barang

  @WebTest
  Scenario: Dapat melakukan Checkout barang
    Given User berada pada home page
    And User Click multiple barang
    And User click cart
    When User click delete barang
    Then Barang sudah tidak ada pada list
