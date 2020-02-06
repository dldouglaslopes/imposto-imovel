package com.douglas.intersol.imposto.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/imoveis")
public class ImovelResource {
	@Autowired 
	private ImovelRepository imovelRepository;
	
	@GetMapping
	private List<Imovel> listar(){
		return imovelRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarId(@PathVariable Integer id){
		Optional<Imovel> salvoImovel = imovelRepository.findById(id);
		
		return salvoImovel.isPresent()? ResponseEntity.ok(salvoImovel) :
										ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Imovel> criar(@Valid @RequestBody Imovel imovel){
		Long areaTotal = imovel.getAreaTerreno() + imovel.getAreaContruida();
		Long venalTotal = imovel.getVenalTerreno() + imovel.getVenalConstrucao();
		Long imposto = venalTotal * imovel.getAliquota();
		imovel.setAreaTotal(areaTotal);
		imovel.setVenalTotal(venalTotal);
		imovel.setImposto(imposto);
		Imovel salvoImovel = imovelRepository.save(imovel);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvoImovel);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		imovelRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Imovel> atualizar(@PathVariable Integer id,
											@Valid @RequestBody Imovel imovel){
		Optional<Imovel> salvoImovel = imovelRepository.findById(id);
		Imovel salvoImovel2 = salvoImovel.get();
		Long areaTotal = imovel.getAreaTerreno() + imovel.getAreaContruida();
		Long venalTotal = imovel.getVenalTerreno() + imovel.getVenalConstrucao();
		Long imposto = venalTotal * imovel.getAliquota();
		imovel.setAreaTotal(areaTotal);
		imovel.setVenalTotal(venalTotal);
		imovel.setImposto(imposto);
		BeanUtils.copyProperties(imovel, salvoImovel2, "id");
		imovelRepository.save(salvoImovel2);
		return ResponseEntity.ok(salvoImovel2);
	}
}
