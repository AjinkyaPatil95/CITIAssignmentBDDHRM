package stepDefinition;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.PIMPage;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StepDefinition extends BaseClass {

    private static PIMPage pimPage;

    @Given("user logged in")
    public void user_logged_in() throws IOException {
        BaseClass baseclass=new BaseClass();
        baseclass.BaseClassMethod();
        log.info("Login Page Opened");
    }

    @When("user entered valid username {string} and password {string} and click on loginButton")
    public void user_entered_valid_username_and_password_and_click_on_login_button(String string, String string2) {
        LoginPage loginpage = new LoginPage();
        loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
    }

    @Then("user will be navigated to HomePage")
    public void user_will_be_navigated_to_home_page() {

    }

    @Given("user click on menu button and user is on PIM page")
    public void user_click_on_menu_button_and_user_is_on_pim_page() {
        HomePage homepage = new HomePage();
        homepage.homePagePIM();
    }

    @When("click on Add Employee Button")
    public void click_on_add_employee_button() throws AWTException {
        pimPage.AddEmployee();
    }

        @When("enter first name middle name last name")
        public void enter_first_name_middle_name_last_name ( DataTable dataTable) throws InterruptedException {
            List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : rows) {
                String firstname = row.get("FirstName");
                String middlename = row.get("MiddleName");
                String lastname = row.get("LastName");
                pimPage.AddDetails(firstname, middlename, lastname);
            }
        }

        @When("click on add button")
        public void click_on_add_button () {
            PIMPage pim = new PIMPage();
            pim.ClickElement();
        }

        @Then("Employee will be added")
        public void employee_will_be_added () {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @When("user enter employee name as {string} and click on search and delete button")
        public void user_enter_employee_name_as_and_click_on_search_and_delete_button (String string) throws
        InterruptedException {
            PIMPage pim = new PIMPage();
            pim.SearchEmployee(prop.getProperty("name"));
        }

        @Then("Employee will be deleted")
        public void employee_will_be_deleted () {
            Scenario scenario = null;
            BaseClass.closing(scenario);
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }
    }
