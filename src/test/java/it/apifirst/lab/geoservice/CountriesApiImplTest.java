package it.apifirst.lab.geoservice;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import it.apifirst.lab.geoservice.openapi.model.Country;
import it.apifirst.lab.geoservice.openapi.model.GetCountries200Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * TODO parametric test for lang
 */
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
class CountriesApiImplTest {

    @Test
    void testCountriesEndpointIt() {
        var r = given()
                .header("Accept", "application/json;version=1")
                .when()
                .get("/countries?lang=it")
                .then()
                .statusCode(200)
                .extract().as(GetCountries200Response.class);

        var list = r.getData();
        assertThat(list).hasSize(3);
        assertThat(list).containsExactly(
                new Country().countryId("it").name("italia").deleted(false).phoneCode("39"),
                new Country().countryId("es").name("spagna").deleted(false).phoneCode("49"),
                new Country().countryId("de").name("germania").deleted(false).phoneCode("34"));
    }

    @Test
    void testCountriesEndpointEn() {
        var r = given()
                .header("Accept", "application/json;version=1")
                .when()
                .get("/countries?lang=en")
                .then()
                .statusCode(200)
                .extract().as(GetCountries200Response.class);

        var list = r.getData();
        assertThat(list).hasSize(3);
        assertThat(list).containsExactly(
                new Country().countryId("it").name("italy").deleted(false).phoneCode("39"),
                new Country().countryId("es").name("spain").deleted(false).phoneCode("49"),
                new Country().countryId("de").name("germany").deleted(false).phoneCode("34"));
    }
}