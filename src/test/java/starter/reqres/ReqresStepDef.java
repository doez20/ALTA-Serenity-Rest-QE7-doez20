package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {

        reqresAPI.getListUser(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);

    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {

        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should be {int}")
    public void responseBodyShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    //Scenario 2
    @Given("Post create new user with valid json")
    public void postCreateNewUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/CreateUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when()
                    .post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                    .statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                    .body(ReqresResponses.NAME,equalTo(name))
                    .body(ReqresResponses.JOB,equalTo(job));
    }

    @Given("Update data user with valid {int} and json")
    public void updateDataUserWithValidJson(int id) {
        File jsonUpdate = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUser.json");
        reqresAPI.putUpdateUser(id,jsonUpdate);
        
        
    }

    @When("Send update user request")
    public void sendUpdateUserRequest() {
        SerenityRest.when()
                    .put(ReqresAPI.UPDATE_USER);

    }

    @Given("Delete user with {int}")
    public void deleteUserWith(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when()
                    .delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then()
                    .statusCode(noContent);

    }
}
