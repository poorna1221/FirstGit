package com.sparity.shoppingcart.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="category")
public class CategoryModel extends BaseModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "cat_id",unique=true, precision=10)
	private Long categoryId;
	
	@Column(name="cat_cod", unique = true, nullable=false, length=20)
	private String categoryCode;
	
	@Column(name="cat_name", length=20)
	private String categoryName;
	
	@Column(name="cat_description",length=80)
	private String categoryDesc;
	
	@OneToMany(mappedBy="categoryModel",targetEntity = ProductTypeModel.class, fetch = FetchType.EAGER)
	private Set<ProductTypeModel> productType = new HashSet<ProductTypeModel>(0);
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "category_brand", joinColumns = { @JoinColumn(name = "cat_id") }, inverseJoinColumns = { @JoinColumn(name = "brand_id") })
	private Set<BrandModel> brand = new HashSet<BrandModel>(0);
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public Set<ProductTypeModel> getProductType() {
		return productType;
	}
	public void setProductType(Set<ProductTypeModel> productType) {
		this.productType = productType;
	}
	public Set<BrandModel> getBrand() {
		return brand;
	}
	public void setBrand(Set<BrandModel> brand) {
		this.brand = brand;
	}
	

}
