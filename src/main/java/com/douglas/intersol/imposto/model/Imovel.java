package com.douglas.intersol.imposto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "imovel")
public class Imovel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "proprietario_id")
	private Integer idProprietario;
	
	private String endereco;
	
	@Column(name = "area_terreno")
	private Long areaTerreno;
	
	@Column(name = "area_construida")
	private Long areaContruida;
	
	@Column(name = "area_total")
	private Long areaTotal;
	
	private Long aliquota;
	
	@Column(name = "valor_venal_terreno")
	private Long venalTerreno;
	
	@Column(name = "valor_venal_construcao")
	private Long venalConstrucao;
	
	@Column(name = "valor_venal_total")
	private Long venalTotal;
	
	@Column(name = "aliquota_aplicada")
	private Long aliquotaAplicada;
	
	@Column(name = "valor_imposto")
	private Long imposto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(Long areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public Long getAreaContruida() {
		return areaContruida;
	}

	public void setAreaContruida(Long areaContruida) {
		this.areaContruida = areaContruida;
	}

	public Long getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(Long areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Long getAliquota() {
		return aliquota;
	}

	public void setAliquota(Long aliquota) {
		this.aliquota = aliquota;
	}

	public Long getVenalTerreno() {
		return venalTerreno;
	}

	public void setVenalTerreno(Long venalTerreno) {
		this.venalTerreno = venalTerreno;
	}

	public Long getVenalConstrucao() {
		return venalConstrucao;
	}

	public void setVenalConstrucao(Long venalConstrucao) {
		this.venalConstrucao = venalConstrucao;
	}

	public Long getVenalTotal() {
		return venalTotal;
	}

	public void setVenalTotal(Long venalTotal) {
		this.venalTotal = venalTotal;
	}

	public Long getAliquotaAplicada() {
		return aliquotaAplicada;
	}

	public void setAliquotaAplicada(Long aliquotaAplicada) {
		this.aliquotaAplicada = aliquotaAplicada;
	}

	public Long getImposto() {
		return imposto;
	}

	public void setImposto(Long imposto) {
		this.imposto = imposto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
