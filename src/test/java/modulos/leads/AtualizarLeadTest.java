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
public class AtualizarLeadTest {
	
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
	@DisplayName("Validar a atualização de um novo lead")
	
	public void testValidarAtualizaçãoDeUmNovoLead() {
		
		// tentar criar um lead e validar a mensagem so status code foi 201
	
		given()
			
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"linkedin_url\": \"www.perfil.com\",\r\n"
					+ "    \"phone_number\": \"11784354338\",\r\n"
					+ "    \"twitter\": \"@teste1\"\r\n"
					+ "}")
			.when()
			//acrecentar/o numero desesado depois ?
					. put("/leads/97916939?api_key=" + this.token)
			.then()
					.assertThat()
					 .statusCode(204);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	

}
