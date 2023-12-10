Feature: Testing Website

  @WebTest
  Scenario: Login ke website dengan valid user
    Given User berada pada home page
    And User click Login
    And User memasukan username "testiop"
    And User memasukan password "testing"
    When User click tombol login
    Then User dapat melihat akun masuk dengan "Welcome asdkiiek"

  @WebTest
  Scenario: Login ke website dengan invalid user
    Given User berada pada home page
    And User click Login
    And User memasukan username "testiop"
    And User memasukan password "asdasdas"
    When User click tombol login
    Then Muncul pop up dengan tulisan "Wrong password."
