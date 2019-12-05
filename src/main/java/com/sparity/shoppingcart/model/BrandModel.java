package com.sparity.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="brand")
public class BrandModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "brand_id",unique=true, nullable=false, precision=10)
	private Long brandId;
	
	@Column(name="brand_code", unique = true, nullable=false, length=20)
	private String brandCode;
	
	@Column(name="brand_name", length=20)
	private String brandName;
	
	@Column(name="brand_desc", length=80)
	private String branndDesc;
	
	@Column(name="brand_image", length=80)
	private String brandImpage;
	
	@ManyToMany(mappedBy="brand",fetch=FetchType.EAGER)
	private Set<CategoryModel>  categoryModel = new HashSet<CategoryModel>(0);
	
	@OneToMany(mappedBy="brandModel",targetEntity = ProductModel.class, fetch = FetchType.EAGER)
	private Set<ProductModel> products = new HashSet<ProductModel>(0);

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBranndDesc() {
		return branndDesc;
	}

	public void setBranndDesc(String branndDesc) {
		this.branndDesc = branndDesc;
	}

	
	public Set<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}

	public String getBrandImpage() {
		return brandImpage;
	}

	public void setBrandImpage(String brandImpage) {
		this.brandImpage = brandImpage;
	}

	public Set<CategoryModel> getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(Set<CategoryModel> categoryModel) {
		this.categoryModel = categoryModel;
	}


	

}
