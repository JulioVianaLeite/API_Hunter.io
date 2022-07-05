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
public class NovoLeadTest {
	
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
	@DisplayName("Validar a criação de um novo lead")
	
	public void testValidarCriançaoDeUmNovoLead() {
		
		// tentar criar um lead e validar a mensagem so status code foi 201
	
		given()
			
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"email\": \"Teste1@Mill.com\",\r\n"
					+ "  \"first_name\": \"teste1\",\r\n"
					+ "  \"last_name\": \"teste1\",\r\n"
					+ "  \"position\": \"Socio-fundador\",\r\n"
					+ "  \"company\": \"millsz\",\r\n"
					+ "  \"company_industry\": \"Agencia de Edição de video\",\r\n"
					+ "  \"confidence_score\": 13,\r\n"
					+ "  \"website\": \"millsz.com\"\r\n"
					+ "}")
			.when()
					.post("/leads?api_key=" + this.token)
			.then()
					.assertThat()
					 .statusCode(201);
	}
		
	@Test 
	@DisplayName("Validar a criação de outro lead")
		
	public void testValidarACriançaoOutroLead() {
			
			// tentar criar um lead e validar a mensagem so status code foi 201
		
			given()
				
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"email\": \"teste2@Mill.com\",\r\n"
						+ "  \"first_name\": \"teste2\",\r\n"
						+ "  \"last_name\": \"teste2\",\r\n"
						+ "  \"position\": \"Socio-fundador\",\r\n"
						+ "  \"company\": \"millsz\",\r\n"
						+ "  \"company_industry\": \"Agencia de Edição de video\",\r\n"
						+ "  \"confidence_score\": 11,\r\n"
						+ "  \"website\": \"millsz.com\"\r\n"
						+ "}")
				.when()
						.post("/leads?api_key=" + this.token)
				.then()
						.assertThat()
						 .statusCode(201);
	
		 
		
	}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
