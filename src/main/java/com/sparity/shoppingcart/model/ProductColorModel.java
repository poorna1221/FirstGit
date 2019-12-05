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
@Table(name="product_color")
public class ProductColorModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "prod_color_id",unique=true, nullable=false, precision=10)
	private Long prodColorId;
	
	@Column(name="prod_color_name", length=20)
	private String prodColorName;
	
	@ManyToOne
	@JoinColumn(name="prod_id",nullable=false)
	private ProductModel productModel;
	
	public Long getProdColorId() {
		return prodColorId;
	}
	public void setProdColorId(Long prodColorId) {
		this.prodColorId = prodColorId;
	}
	public String getProdColorName() {
		return prodColorName;
	}
	public void setProdColorName(String prodColorName) {
		this.prodColorName = prodColorName;
	}
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	

}
