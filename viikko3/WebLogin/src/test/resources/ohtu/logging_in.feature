Feature: As a registered user can log in with valid username/password-combination

  Scenario: user can login with correct password
    Given login is selected
    When  correct username "jukka" and password "akkuj" are given
    Then  user is logged in

  Scenario: user can not login with incorrect password
    Given login is selected
    When  correct username "jukka" and incorrect password "wrong" are given
    Then  user is not logged in and error message is given

  Scenario: nonexistent user can not login to
    Given login is selected
    When  non-existent username "idontexist" and non-existent password "meneither123" are given
    Then  user is not logged in and error message is given

  Scenario: creation is successful with valid username and password
    Given command new user is selected
    When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
    Then  a new user is created

  Scenario: creation fails with too short username and valid password
    Given command new user is selected
    When  a short username "pb" and valid password "passw0rd" are entered
    Then  user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given command new user is selected
    When  a valid username "mikael" and short password "pass" are entered
    Then  user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given command new user is selected
    When  a valid username "username" and non-matching passwords "password1" and "password2" are entered
    Then  user is not created and error "password and password confirmation do not match" is reported

  Scenario: user can login with successfully generated account
    Given user with username "lea" with password "salainen1" is successfully created
    And   login is selected
    When  correct username "lea" and password "salainen1" are given
    Then  user is logged in

  Scenario: user can not login with account that is not successfully created
    Given user with username "aa" and password "bad" is tried to be created
    And   login is selected
    When  correct username "aa" and password "bad" are given
    Then  user is not logged in and error message is given