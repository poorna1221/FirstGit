package com.sparity.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="product_type")
public class ProductTypeModel extends BaseModel{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "prod_type_id",unique=true, nullable=false, precision=10)
	private Long prodTypeId;
	
	@Column(name="prod_type_code", unique = true, nullable=false, length=20)
	private String prodTypeCode;
	
	@Column(name="prod_type_name", length=20)
	private String prodTypeName;
	
	@Column(name="prod_type_desc", length=20)
	private String prodTypeDesc;
	
	@Column(name="prod_type_stock", length=5)
	private Long prodTypeStock;
	
	
	@ManyToOne
	@JoinColumn(name="cat_id",nullable=false)
	private CategoryModel categoryModel;

	@OneToMany(mappedBy="prodTypeModel",targetEntity = ProductModel.class, fetch = FetchType.EAGER)
	private Set<ProductModel> products = new HashSet<ProductModel>(0);
	
	
	public Long getProdTypeId() {
		return prodTypeId;
	}


	public void setProdTypeId(Long prodTypeId) {
		this.prodTypeId = prodTypeId;
	}


	public String getProdTypeCode() {
		return prodTypeCode;
	}


	public void setProdTypeCode(String prodTypeCode) {
		this.prodTypeCode = prodTypeCode;
	}


	public String getProdTypeName() {
		return prodTypeName;
	}


	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}


	public String getProdTypeDesc() {
		return prodTypeDesc;
	}


	public void setProdTypeDesc(String prodTypeDesc) {
		this.prodTypeDesc = prodTypeDesc;
	}


	public Long getProdTypeStock() {
		return prodTypeStock;
	}


	public void setProdTypeStock(Long prodTypeStock) {
		this.prodTypeStock = prodTypeStock;
	}


	public CategoryModel getCategoryModel() {
		return categoryModel;
	}


	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}


	public Set<ProductModel> getProducts() {
		return products;
	}


	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}
	
}
