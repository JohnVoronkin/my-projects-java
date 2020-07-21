package tests.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.qala.datagen.RandomShortApi.alphanumeric;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class WireMockJUnit5Test {

  private WireMockServer wireMockServer;

  @BeforeEach
  public void setup() {
    wireMockServer = new WireMockServer(8090);
    wireMockServer.start();
    setupStub();
  }

  @AfterEach
  public void teardown() {
    wireMockServer.stop();
  }

  private void setupStub() {
    wireMockServer.stubFor(WireMock.get(urlEqualTo("/an/endpoint"))
            .willReturn(aResponse().withHeader("Content-Type", "text/plain")
                    .withStatus(200)
                    .withBody("Status: 200\n" +
                            "Body: '" + alphanumeric(4, 20) + "'")));
  }

  @Test
  public void testStatusCodePositive() {
    given().
            when().log().all().
            get("http://localhost:8090/an/endpoint").
            then().log().all().
            assertThat().
            statusCode(200);
  }

  @Test
  public void testStatusCodeNegative() {
    given().
            when().
            get("http://localhost:8090/another/endpoint").
            then().
            assertThat().statusCode(404);
  }

  @Test
  public void testResponseContents() {
    Response response = given().when().get("http://localhost:8090/an/endpoint");
    String title = response.jsonPath().get("glossary.title");
    System.out.println(title);
    assertThat("example glossary").isEqualTo(title);
  }
}
