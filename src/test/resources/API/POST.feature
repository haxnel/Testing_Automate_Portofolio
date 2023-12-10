Feature: Post New user

  @APITest
  Scenario: Membuat user baru
    Given Mempersiapkan URL untuk "Post users"
    And Hit API untuk mendaptakan list
    Then Mendapatkan status code 200
    Then Terdapat "updatedDate" dan "registerDate"
    Then Memvalidasi respons json dengan JSONSchema "Post.json"