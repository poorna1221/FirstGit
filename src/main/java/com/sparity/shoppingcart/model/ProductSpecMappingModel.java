package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="prodduct_spec_mapping")
public class ProductSpecMappingModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	@Column(name = "mappingid",unique=true, nullable=false, precision=10)
	private Long mappingId;
	
	@Column(name="mapping_name", length=20)
	private String mappingName;
	
	@Column(name="mapping_value", length=20)
	private String mappingValue;
	
	@ManyToOne
	@JoinColumn(name="spec_id",nullable=false)
	private ProductSpecModel specModel;

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public String getMappingName() {
		return mappingName;
	}

	public void setMappingName(String mappingName) {
		this.mappingName = mappingName;
	}

	public String getMappingValue() {
		return mappingValue;
	}

	public void setMappingValue(String mappingValue) {
		this.mappingValue = mappingValue;
	}

	public ProductSpecModel getSpecModel() {
		return specModel;
	}

	public void setSpecModel(ProductSpecModel specModel) {
		this.specModel = specModel;
	}
	
	
}
