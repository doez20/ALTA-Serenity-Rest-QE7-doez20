package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

public class ReqresAPI {

    public static final String URL_REQRES = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static String GET_LIST_USER = URL_REQRES + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL_REQRES + "/api/users";
    public static String UPDATE_USER = URL_REQRES + "/api/users/{id}";
    public static String DELETE_USER = UPDATE_USER;

    //public static String URL_CREATE_NEW_USER = "https://reqres.in/api/users";
    //public static String GET_LIST_USER = "https://reqres.in/api/users?page={page}";

    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given()
                    .pathParam("page",page);

    }

    @Step("Post create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);

    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                    .pathParam("id",id);
    }
}
