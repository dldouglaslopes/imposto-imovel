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
	private Float areaTerreno;
	
	@Column(name = "area_construida")
	private Float areaConstruida;
	
	@Column(name = "area_total")
	private Float areaTotal;
	
	private Float aliquota;
	
	@Column(name = "valor_venal_terreno")
	private Float venalTerreno;
	
	@Column(name = "valor_venal_construcao")
	private Float venalConstrucao;
	
	@Column(name = "valor_venal_total")
	private Float venalTotal;
	
	@Column(name = "aliquota_aplicada")
	private Float aliquotaAplicada;
	
	@Column(name = "valor_imposto")
	private Float imposto;

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

	public Float getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(Float areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public Float getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(Float areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public Float getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(Float areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Float getAliquota() {
		return aliquota;
	}

	public void setAliquota(Float aliquota) {
		this.aliquota = aliquota;
	}

	public Float getVenalTerreno() {
		return venalTerreno;
	}

	public void setVenalTerreno(Float venalTerreno) {
		this.venalTerreno = venalTerreno;
	}

	public Float getVenalConstrucao() {
		return venalConstrucao;
	}

	public void setVenalConstrucao(Float venalConstrucao) {
		this.venalConstrucao = venalConstrucao;
	}

	public Float getVenalTotal() {
		return venalTotal;
	}

	public void setVenalTotal(Float venalTotal) {
		this.venalTotal = venalTotal;
	}

	public Float getAliquotaAplicada() {
		return aliquotaAplicada;
	}

	public void setAliquotaAplicada(Float aliquotaAplicada) {
		this.aliquotaAplicada = aliquotaAplicada;
	}

	public Float getImposto() {
		return imposto;
	}

	public void setImposto(Float imposto) {
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
