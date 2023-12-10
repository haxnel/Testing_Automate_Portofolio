Feature: Delete Users

  @APITest
  Scenario: Dapat melakukan delete user
    Given Mempersiapkan URL untuk "Delete user"
    And Hit API untuk mendaptakan list
    Then Mendapatkan status code 404
    Then Terdapat "error" di body
    Then Memvalidasi respons json dengan JSONSchema "Delete_userError.json"