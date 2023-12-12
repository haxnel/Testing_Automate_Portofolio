Feature: Checkout barang

  @WebTest
  Scenario: Dapat melakukan Check out barang
    Given User berada pada home page
    And User Click "single" barang
    And User click cart
    And Click Place order
    And User mengisi form dengan "Nama", "Negara", "kota", "Creadit", "bulan", dan "tahun"
    When click tombol Purchase
    Then Menampilkan pop up "Thank you for your purchase!"


  @WebTest
  Scenario: Dapat melakukan Check out multiple barang
    Given User berada pada home page
    And User Click "multiple" barang
    And User click cart
    And Click Place order
    And User mengisi form dengan "Nama", "Negara", "kota", "Creadit", "bulan", dan "tahun"
    When click tombol Purchase
    Then Menampilkan pop up "Thank you for your purchase!"

  @WebTest
  Scenario: User mendapatkan error ketika tidak melengkapi form
    Given User berada pada home page
    And User Click "multiple" barang
    And User click cart
    And Click Place order
    When click tombol Purchase
    Then User tidak dapat melanjutkan dan melihat tulisan "Please fill out Name and Creditcard."
