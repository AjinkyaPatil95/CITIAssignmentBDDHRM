Feature: Add Employee In Orange HRM

  Scenario: Test Login Functionality
    Given user logged in
    When user entered valid username "Admin" and password "admin123" and click on loginButton
    Then user will be navigated to HomePage

  Scenario: Test add user functionality in PIM page
    Given user click on menu button and user is on PIM page
    When click on Add Employee Button
    When enter first name middle name last name
      | FirstName | MiddleName | LastName |
      | Ajinkya   | Anil       | Patil    |
      | John      | Tom        | Haze     |
    When click on add button
    Then Employee will be added

  Scenario: Test Search and Delete user functionality in PIM page
    Given user click on menu button and user is on PIM page
    When user enter employee name as "Ajinkya" and click on search and delete button
    Then Employee will be deleted



