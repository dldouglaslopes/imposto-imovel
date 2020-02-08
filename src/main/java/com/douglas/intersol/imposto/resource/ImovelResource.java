package com.douglas.intersol.imposto.resource;

import java.util.List;
import java.util.Optional;

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
import com.douglas.intersol.imposto.repository.ImovelRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Imóveis", 
	description = "CRUD Imóveis",
	produces ="application/json")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/imoveis")
public class ImovelResource {
	@Autowired 
	private ImovelRepository imovelRepository;
	
	@ApiOperation(value = "Listar proprietários")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@GetMapping
	private List<Imovel> listar(){
		return imovelRepository.findAll();
	}
	
	@ApiOperation(value = "Buscar por id do proprietário")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarId(@PathVariable Integer id){
		Optional<Imovel> salvoImovel = imovelRepository.findById(id);
		
		return salvoImovel.isPresent()? ResponseEntity.ok(salvoImovel) :
										ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Cadastrar proprietário")
	@ApiResponses(value= @ApiResponse(code=201, 
										response= Imovel.class, 
										message = ""))
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Imovel> criar(@Valid @RequestBody Imovel imovel){
		Float areaTotal = imovel.getAreaTerreno() + imovel.getAreaConstruida();
		Float venalTotal = imovel.getVenalTerreno() + imovel.getVenalConstrucao();
		Float imposto = venalTotal * imovel.getAliquota();
		imovel.setAreaTotal(areaTotal);
		imovel.setVenalTotal(venalTotal);
		imovel.setImposto(imposto);
		Imovel salvoImovel = imovelRepository.save(imovel);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvoImovel);
	}
	
	@ApiOperation(value = "Deletar por id do proprietário")
	@ApiResponses(value= @ApiResponse(code=204, 
										response= Imovel.class, 
										message = ""))
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		imovelRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Atualizar por id do imovel")
	@ApiResponses(value= @ApiResponse(code=200, 
										response= Imovel.class, 
										message = ""))
	@PutMapping("/{id}")
	public ResponseEntity<Imovel> atualizar(@PathVariable Integer id,
											@Valid @RequestBody Imovel imovel){
		Optional<Imovel> salvoImovel = imovelRepository.findById(id);
		Imovel salvoImovel2 = salvoImovel.get();
		Float areaTotal = imovel.getAreaTerreno() + imovel.getAreaConstruida();
		Float venalTotal = imovel.getVenalTerreno() + imovel.getVenalConstrucao();
		Float imposto = venalTotal * imovel.getAliquota();
		imovel.setAreaTotal(areaTotal);
		imovel.setVenalTotal(venalTotal);
		imovel.setImposto(imposto);
		BeanUtils.copyProperties(imovel, salvoImovel2, "id");
		imovelRepository.save(salvoImovel2);
		return ResponseEntity.ok(salvoImovel2);
	}
}
