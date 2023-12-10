Feature: Update Users

  @APITest
  Scenario: Update user yang sudah ada
    Given Mempersiapkan URL untuk "Update user"
    And Hit API untuk mendaptakan list
    Then Mendapatkan status code 200
    Then Terdapat "updatedDate" dan "registerDate"
    Then Memvalidasi respons json dengan JSONSchema "Update_user.json"