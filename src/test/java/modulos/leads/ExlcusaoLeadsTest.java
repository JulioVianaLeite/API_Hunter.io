package modulos.leads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;	

@DisplayName("Teste de API do Hunter io")
public class ExlcusaoLeadsTest {
	
	
	private String token;
	
	@BeforeEach
	public void beforeEach() {
		
		// configurando os dados da API
		baseURI = "https://api.hunter.io";
		basePath = "/v2";	
		// Obter token
		this.token = "e389ee8d88a6d3c95ba7590b9abcbd0362118a9a";
				
	}
	
	@Test 
	@DisplayName("Validar o DELETE de um  lead")
	
	public void testValidarAExclusãoDeUmLead() {
		
		
		// tentar criar um lead e validar a mensagem so status code foi 204

		given()
			 	.delete("/leads/94711837?api_key=" + token)
			 .then()
			 	.assertThat()
			 	.statusCode(204);
		

						 
		
	}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
