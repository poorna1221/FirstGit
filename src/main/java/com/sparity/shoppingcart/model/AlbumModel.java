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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="album")
public class AlbumModel extends BaseModel {

	private static final long serialVersionUID = -8211971032161526434L;
	@Id
	@GeneratedValue
	@Column(name = "album_id",unique=true, nullable=false, precision=10)
	private Long albumId;
	
	@Column(name="albumname", length=20)
	private String albumName;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserModel userModel;
	
	@OneToOne(mappedBy="album",targetEntity = CartUserModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private CartUserModel userAccount;
	
	@OneToMany(mappedBy="albumModel",targetEntity = UserAlbumModel.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<UserAlbumModel> userAlbum = new HashSet<UserAlbumModel>(0);
	
	public Long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public CartUserModel getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(CartUserModel userAccount) {
		this.userAccount = userAccount;
	}
	public Set<UserAlbumModel> getUserAlbum() {
		return userAlbum;
	}
	public void setUserAlbum(Set<UserAlbumModel> userAlbum) {
		this.userAlbum = userAlbum;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	

}
