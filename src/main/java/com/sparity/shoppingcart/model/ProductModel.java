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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="product")
public class ProductModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "prod_id",unique=true, nullable=false, precision=10)
	private Long productId;
	
	@Column(name="prod_code", unique = true, nullable=false, length=20)
	private String productCode;
	
	@Column(name="prod_name", length=65)
	private String productName;
	
	@Column(name="prod_desc", length=80)
	private String productDesc;
	
	@Column(name="mrp_price", length=10)
	private Double mrpPrice;
	
	@Column(name="prod_video")
    private Boolean productVideo;
	
	@Column(name="prod_avalabulity")
	@Type(type="true_false")
	private Boolean productAvalabulity;
	
	@Column(name="prod_count", length=5)
	private Integer productCount;
	
	@Column(name="prod_offers")
	@Type(type="true_false")
	private Boolean productOffers;
	
	@Column(name="imgepath", length=255)
	private String impagePath;
	
	@Column(name="offer_price", length=45)
	private Double offerPrice;
	
	@Column(name="disc_price", length=45)
	private Double discPrice;
	
	@Column(name="video_path", length=80)
	private String prodVideoPath;
	
	@Column(name="prod_status" )
    private Boolean prodstatus;
	


	@ManyToOne
	@JoinColumn(name="prod_type_id",nullable=false)
	private ProductTypeModel prodTypeModel;
	
	@ManyToOne
	@JoinColumn(name="brand_id",nullable=false)
	private BrandModel brandModel;

	@OneToMany(mappedBy="productModel",targetEntity = ProductColorModel.class, fetch = FetchType.EAGER)
	private Set<ProductColorModel> productColor = new HashSet<ProductColorModel>(0);
	
	@OneToMany(mappedBy="productModel",targetEntity = WhishListsModel.class, fetch = FetchType.EAGER)
	private Set<WhishListsModel> wishLists = new HashSet<WhishListsModel>(0);
	
	@OneToMany(mappedBy="product",targetEntity = ShoppingCartModel.class, fetch = FetchType.EAGER)
	private Set<ShoppingCartModel> shoppingCart = new HashSet<ShoppingCartModel>(0);
	
	@OneToOne(mappedBy="product",targetEntity = ProductSpecModel.class, fetch = FetchType.EAGER)
	private ProductSpecModel specModel ;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Boolean getProductVideo() {
		return productVideo;
	}

	public void setProductVideo(Boolean productVideo) {
		this.productVideo = productVideo;
	}

	public Boolean getProductAvalabulity() {
		return productAvalabulity;
	}

	public void setProductAvalabulity(Boolean productAvalabulity) {
		this.productAvalabulity = productAvalabulity;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Boolean getProductOffers() {
		return productOffers;
	}

	public void setProductOffers(Boolean productOffers) {
		this.productOffers = productOffers;
	}

	public ProductTypeModel getProdTypeModel() {
		return prodTypeModel;
	}

	public void setProdTypeModel(ProductTypeModel prodTypeModel) {
		this.prodTypeModel = prodTypeModel;
	}

	public BrandModel getBrandModel() {
		return brandModel;
	}

	public void setBrandModel(BrandModel brandModel) {
		this.brandModel = brandModel;
	}

	public Set<ProductColorModel> getProductColor() {
		return productColor;
	}

	public void setProductColor(Set<ProductColorModel> productColor) {
		this.productColor = productColor;
	}

	public Set<WhishListsModel> getWishLists() {
		return wishLists;
	}

	public void setWishLists(Set<WhishListsModel> wishLists) {
		this.wishLists = wishLists;
	}

	public Set<ShoppingCartModel> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Set<ShoppingCartModel> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getImpagePath() {
		return impagePath;
	}

	public void setImpagePath(String impagePath) {
		this.impagePath = impagePath;
	}

	public ProductSpecModel getSpecModel() {
		return specModel;
	}

	public void setSpecModel(ProductSpecModel specModel) {
		this.specModel = specModel;
	}

	public Double getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(Double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Double getDiscPrice() {
		return discPrice;
	}

	public void setDiscPrice(Double discPrice) {
		this.discPrice = discPrice;
	}

	public String getProdVideoPath() {
		return prodVideoPath;
	}

	public void setProdVideoPath(String prodVideoPath) {
		this.prodVideoPath = prodVideoPath;
	}
	
	public Boolean getProdstatus() {
		return prodstatus;
	}

	public void setProdstatus(Boolean prodstatus) {
		this.prodstatus = prodstatus;
	}	
	

}
