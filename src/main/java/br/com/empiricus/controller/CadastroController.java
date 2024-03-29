package br.com.empiricus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empiricus.model.Ativos;
import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.model.UserLoginPJ;
import br.com.empiricus.service.UserPFService;
import br.com.empiricus.service.UserPJService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cadastrar")
@Tag(name = "cadastrar", description = "Controller para requisições de cadastro -> variáveis para cadastro")
public class CadastroController {
	
	
	@Autowired
	private UserPJService userPJService;
	
	@Autowired
	private UserPFService userPFService;
	
	//PJ
	@PostMapping("/cnpj")
	@Operation(
    		summary = ("Cadastro de usuario Cnpj"),
    		description = ("Cadastro de usuario cnpj / pessoa juridica"),
    		tags = {"cadastrar"},
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public ResponseEntity<UserLoginPJ> CadastrarUserPJ(@RequestBody UserLoginPJ userLoginPJ) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(userPJService.CadastrarUserPJ(userLoginPJ));
	}
	
	//PF	
	@PostMapping("/cpf")
	@Operation(
    		summary = ("Cadastro de usuario Cpf"),
    		description = ("Cadastro de usuario cpf / pessoa fisica"),
    		tags = {"cadastrar"},
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public ResponseEntity<UserLoginPF> CadastrarUserPF(@RequestBody UserLoginPF userLoginPF) {
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(userPFService.CadastrarUserPF(userLoginPF));
	}	
	
	

}
