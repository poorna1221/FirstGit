package com.sparity.shoppingcart.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.sparity.shoppingcart.base.model.BaseModel;
@Entity
@Table(name="user")
public class UserModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "user_id",unique=true, precision=10)
	private Long userId;
	
	@Column(name="user_emailid", unique=true, length=55)
	private String userEmailId;
	
	@Column(name="user_password", length=20)
	private String userPassword;
	
	@Column(name="mobile_number", length=10)
	private String mobileNumber;
	
	@OneToOne(mappedBy="user",targetEntity = CartUserModel.class, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private CartUserModel cartUser;
	
	@OneToOne(mappedBy="user",targetEntity = ShoppingCartModel.class, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private ShoppingCartModel cartModel;
    
	@OneToMany(mappedBy="user",targetEntity = ShippingAddressModel.class, fetch = FetchType.EAGER)
	private Set<ShippingAddressModel> shippingAddLists = new HashSet<ShippingAddressModel>(0);
	
	@OneToMany(mappedBy="userModel",targetEntity = AlbumModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<AlbumModel> albumModel = new HashSet<AlbumModel>(0);
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Set<ShippingAddressModel> getShippingAddLists() {
		return shippingAddLists;
	}

	public void setShippingAddLists(Set<ShippingAddressModel> shippingAddLists) {
		this.shippingAddLists = shippingAddLists;
	}

	public ShoppingCartModel getCartModel() {
		return cartModel;
	}

	public void setCartModel(ShoppingCartModel cartModel) {
		this.cartModel = cartModel;
	}

	public CartUserModel getCartUser() {
		return cartUser;
	}

	public void setCartUser(CartUserModel cartUser) {
		this.cartUser = cartUser;
	}

	public Set<AlbumModel> getAlbumModel() {
		return albumModel;
	}

	public void setAlbumModel(Set<AlbumModel> albumModel) {
		this.albumModel = albumModel;
	}
}
