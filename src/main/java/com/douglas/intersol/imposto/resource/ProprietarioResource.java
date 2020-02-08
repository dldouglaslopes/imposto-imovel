package com.douglas.intersol.imposto.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.intersol.imposto.model.Imovel;
import com.douglas.intersol.imposto.model.Proprietario;
import com.douglas.intersol.imposto.repository.ProprietarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Proprietários", 
	description = "CRUD Proprietários",
	produces ="application/json")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioResource {
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@ApiOperation(value = "Listar proprietários")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@GetMapping
	public List<Proprietario> listar(){
		return proprietarioRepository.findAll();
	}
	
	@ApiOperation(value = "Buscar por id do proprietário")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarId(@PathVariable Integer id){
		Optional<Proprietario> salvoProprietario = proprietarioRepository.findById(id);
		return salvoProprietario.isPresent()?
				ResponseEntity.ok(salvoProprietario) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Cadastrar proprietário")
	@ApiResponses(value= @ApiResponse(code=201, 
										response= Imovel.class, 
										message = ""))
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Proprietario> criar(@Valid @RequestBody Proprietario proprietario,
												HttpServletResponse response){
		
		Proprietario salvoProprietario = proprietarioRepository.save(proprietario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvoProprietario);
	}
	
	@ApiOperation(value = "Deletar por id do proprietário")
	@ApiResponses(value= @ApiResponse(code=204, 
										response= Imovel.class, 
										message = ""))
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		proprietarioRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Atualizar por id do proprietário")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@PutMapping("/{id}")
	public ResponseEntity<Proprietario> atualizar(@PathVariable Integer id,
													@Valid @RequestBody Proprietario proprietario){
		Optional<Proprietario> salvoProprietario = proprietarioRepository.findById(id);
		Proprietario salvoProprietario2 = salvoProprietario.get();
		BeanUtils.copyProperties(proprietario, salvoProprietario2, "id");
		proprietarioRepository.save(salvoProprietario2);
		return ResponseEntity.ok(salvoProprietario2);
	}
}
