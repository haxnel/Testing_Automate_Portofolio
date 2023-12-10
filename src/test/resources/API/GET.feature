Feature: GET Response

  @APITest
  Scenario: Hit API dan mendapatkan All Users
    Given Mempersiapkan URL untuk "GET users"
    And Hit API untuk mendaptakan list
    Then Mendapatkan status code 200
    Then Memvalidasi respons body user yang didapat page 0
    Then Memvalidasi respons json dengan JSONSchema "GET_All.json"

  @APITest
  Scenario: Mendapatkan Single User dengan method GET
    Given Mempersiapkan URL untuk "GET single users"
    And Hit API untuk mendaptakan list
    Then Mendapatkan status code 200
    Then Memvalidasi respons body user yang didapat id "60d0fe4f5311236168a109da"
    Then Memvalidasi respons json dengan JSONSchema "GET_Single.json"


  @APITest
  Scenario: Mendapatkan Tag list dengan method GET
    Given Mempersiapkan URL untuk "GET tags list"
    Then Mendapatkan status code 200
    Then Memvalidasi respons body user yang didapat "data" pada tag
    Then Memvalidasi respons json dengan JSONSchema "GET_Tag.json"