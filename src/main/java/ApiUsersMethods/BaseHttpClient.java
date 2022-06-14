package ApiUsersMethods;

import io.qameta.allure.Step;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseHttpClient {

    private final String JSON = "application/json";

    private final RestAssuredConfig config = RestAssuredConfig.newConfig()
            .sslConfig(new SSLConfig().relaxedHTTPSValidation())
            .redirect(new RedirectConfig().followRedirects(true));

    @Step("Отправить POST запрос")
    protected Response doPostRequest(String url, Object body) {
        return given().config(config)
                .header("Content-Type", JSON)
                .body(body)
                .post(url);
    }

    @Step("Отправить DELETE запрос")
    protected Response doDeleteRequest(String url, String accessToken) {
        return given().config(config)
                .header("Content-Type", JSON)
                .header("authorization", accessToken)
                .delete(url);
    }
}