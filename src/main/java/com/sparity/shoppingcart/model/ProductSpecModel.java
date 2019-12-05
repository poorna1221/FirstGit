package com.sparity.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="product_spec")
public class ProductSpecModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	@Column(name = "spec_id",unique=true, nullable=false, precision=10)
	private Long specId;
	
	@Column(name="modelname" ,length=20)
	private String specModel;
	
	@Column(name="modeltype" ,length=20)
	private String specType;
	
	@Column(name="warrenty" ,length=20)
	private String warrenty;
	
	@Column(name="service" ,length=20)
	private String service;
	
	@Column(name="weight" ,length=20)
	private String weight;
	
	@Column(name="pkgcontent1" ,length=20)
	private String pkgcontent1;
	
	@Column(name="pkgcontent2" ,length=20)
	private String pkgcontent2;
	
	@Column(name="pkgcontent3" ,length=20)
	private String pkgcontent3;
	
	@Column(name="pkgcontent4" ,length=20)
	private String pkgcontent4;
	
	@Column(name="pkgcontent5" ,length=20)
	private String pkgcontent5;
	
	@Column(name="emi_option1" ,length=20)
	private String emiOption1;
	
	@Column(name="emi_option2" ,length=20)
	private String emiOption2;
	
	@Column(name="emi_option3" ,length=20)
	private String emiOption3;
	
	@OneToOne
	@JoinColumn(name="prod_id",nullable=false)
	private ProductModel product;
	
	@OneToMany(mappedBy="specModel",targetEntity = ProductSpecMappingModel.class, fetch = FetchType.EAGER)
	private Set<ProductSpecMappingModel> specMapping = new HashSet<ProductSpecMappingModel>(0);

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getSpecModel() {
		return specModel;
	}

	public void setSpecModel(String specModel) {
		this.specModel = specModel;
	}

	public String getSpecType() {
		return specType;
	}

	public void setSpecType(String specType) {
		this.specType = specType;
	}

	public String getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPkgcontent1() {
		return pkgcontent1;
	}

	public void setPkgcontent1(String pkgcontent1) {
		this.pkgcontent1 = pkgcontent1;
	}

	public String getPkgcontent2() {
		return pkgcontent2;
	}

	public void setPkgcontent2(String pkgcontent2) {
		this.pkgcontent2 = pkgcontent2;
	}

	public String getPkgcontent3() {
		return pkgcontent3;
	}

	public void setPkgcontent3(String pkgcontent3) {
		this.pkgcontent3 = pkgcontent3;
	}

	public String getPkgcontent4() {
		return pkgcontent4;
	}

	public void setPkgcontent4(String pkgcontent4) {
		this.pkgcontent4 = pkgcontent4;
	}

	public String getPkgcontent5() {
		return pkgcontent5;
	}

	public void setPkgcontent5(String pkgcontent5) {
		this.pkgcontent5 = pkgcontent5;
	}

	public String getEmiOption1() {
		return emiOption1;
	}

	public void setEmiOption1(String emiOption1) {
		this.emiOption1 = emiOption1;
	}

	public String getEmiOption2() {
		return emiOption2;
	}

	public void setEmiOption2(String emiOption2) {
		this.emiOption2 = emiOption2;
	}

	public String getEmiOption3() {
		return emiOption3;
	}

	public void setEmiOption3(String emiOption3) {
		this.emiOption3 = emiOption3;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public Set<ProductSpecMappingModel> getSpecMapping() {
		return specMapping;
	}

	public void setSpecMapping(Set<ProductSpecMappingModel> specMapping) {
		this.specMapping = specMapping;
	}
	
}
