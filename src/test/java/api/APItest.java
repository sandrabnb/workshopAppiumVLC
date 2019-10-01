package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APItest {
    private static String baseURL = "https://en.wikipedia.org/w/api.php" +
            "?action=query" +
            "&list=search" +
            "&utf8=" +
            "&format=json";

    public String getSearchResults (String query) {
        return (String) given().get(baseURL+"&srsearch="+query)
                .then()
                .extract()
                .jsonPath()
                .getList("query.search.title")
                .get(0);

    }

    @Test
    public void testSearchAPI() {
        Assert.assertEquals(getSearchResults("Nelson Mandela"), "Nelson Mandela");
    }
}
