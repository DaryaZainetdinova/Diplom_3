package ApiUsersMethods;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class UserApiClient extends BaseHttpClient {

    private final String baseUrl = "https://stellarburgers.nomoreparties.site/api";

    @Step("создание пользователя")
    public Response createUser(User user) {
        return doPostRequest(baseUrl + "/auth/register", user);
    }

    @Step("удалениe пользователя")
    public Response deleteUser(String acceesToken) {
        return doDeleteRequest(baseUrl + "/auth/user", acceesToken);
    }
}
