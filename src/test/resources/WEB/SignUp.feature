Feature: Sign up

  Scenario: Dapat melakukan Sign Up
    Given User berada pada home page
    And User Click "Sign up 1"
    And User memasukan username "User baru"
    And User memasukan password "Pass baru"
    When User Click "Sign up 2"
    Then Muncul pop up dengan tulisan "Sign up successful."

  Scenario: Melakukan Sign Up dengan user terdaftar
    Given User berada pada home page
    And User Click "Sign up 1"
    And User memasukan username "asdkiiek"
    And User memasukan password "Pass baru"
    When User Click "Sign up 2"
    Then Muncul pop up dengan tulisan "This user already exist."