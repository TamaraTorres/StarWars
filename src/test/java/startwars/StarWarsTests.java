package startwars;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import starwars.model.Character;
import starwars.model.CharacterResponse;
import starwars.model.Planet;
import starwars.model.PlanetResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StarWarsTests {


    @BeforeClass
    public  static void setup(){
        RestAssured.defaultParser = Parser.JSON;
    }
    @Test
    public void GetAllCharacters(){

        CharacterResponse allCharacters= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PEOPLE).
                then().log().body().
                statusCode(200)
                .extract().response().as(CharacterResponse.class);

        System.out.println("Characters from StarWars: "+ allCharacters.getCount());
    }


    @Test
    public void GetLeia(){
        Character leiaCharacter=
                given().
                        baseUri(StarWarsConstants.BASE_URI).
                        when().
                        accept(ContentType.JSON).
                        get(StarWarsConstants.GET_PEOPLE+"/5/").
                        then().log().body().
                        statusCode(200).
                        body("name", equalTo("Leia Organa")).
                        extract().response().as(Character.class);

          System.out.println("Leia has been in : "+ leiaCharacter.getFilms().length+ " films");
    }

    @Test
    public void GetAllPlanets() throws  Exception{

        PlanetResponse allPlanets= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PLANETS).
                then().log().body().
                statusCode(200)
                .extract().response().as(PlanetResponse.class);

        System.out.println("Planets from StarWars: "+ allPlanets.getCount());
    }

    @Test
    public void GetResidentsFromPlanet7(){
        Planet planet7= given().
                baseUri(StarWarsConstants.BASE_URI).
                when().
                accept(ContentType.JSON).
                get(StarWarsConstants.GET_PLANETS+ "/7/").
                then().log().body().
                statusCode(200)
                .extract().response().as(Planet.class);

        System.out.println("Residents from Planet 7: "+ planet7.getResidents().length);
    }
}
