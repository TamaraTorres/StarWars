package startwars;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StarWarsTests {

    @Test
    public void GetAllCharacters(){

        Response allCharacters= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PEOPLE).
                then().log().body().
                statusCode(200)
                .extract().response();

        System.out.println("Characters from StarWars: "+ allCharacters.getBody().jsonPath().get("count"));
    }


    @Test
    public void GetLeia(){
        Response leiaCharacter=
                given().
                        baseUri(StarWarsConstants.BASE_URI).
                        when().
                        accept(ContentType.JSON).
                        get(StarWarsConstants.GET_PEOPLE+"/5/").
                        then().log().body().
                        statusCode(200).
                        body("name", equalTo("Leia Organa")).
                        extract().response();
        System.out.println("Leia has been in : "+ leiaCharacter.getBody().jsonPath().getList("films").size()+ " films");
    }

    @Test
    public void GetAllPlanets(){

        Response allPlanets= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PLANETS).
                then().log().body().
                statusCode(200)
                .extract().response();

        System.out.println("Planets from StarWars: "+ allPlanets.getBody().jsonPath().get("count"));
    }

    @Test
    public void GetResidentsFromPlanet7(){
        Response planet7= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PLANETS+ "/7/").
                then().log().body().
                statusCode(200)
                .extract().response();

        System.out.println("Residents from Planet 7: "+ planet7.getBody().jsonPath().getList("residents").size());
    }
}
