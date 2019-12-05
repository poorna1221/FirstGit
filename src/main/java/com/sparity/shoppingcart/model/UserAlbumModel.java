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
@Table(name="user_album")
public class UserAlbumModel extends BaseModel {
	private static final long serialVersionUID = -8211971032161526434L;
	@Id
	@GeneratedValue
	@Column(name = "user_album_id",unique=true, nullable=false, precision=10)
	private Long userAlbumId;
	
	@Column(name="location", length=255)
	private String location;
	
	@ManyToOne
	@JoinColumn(name="album_id",nullable=false)
	private AlbumModel albumModel;
	
	
	@ManyToOne
	@JoinColumn(name="album_type_id",nullable=false)
	private AlbumTypeModel albumTypeModel;

	public Long getUserAlbumId() {
		return userAlbumId;
	}

	public void setUserAlbumId(Long userAlbumId) {
		this.userAlbumId = userAlbumId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public AlbumModel getAlbumModel() {
		return albumModel;
	}

	public void setAlbumModel(AlbumModel albumModel) {
		this.albumModel = albumModel;
	}

	public AlbumTypeModel getAlbumTypeModel() {
		return albumTypeModel;
	}

	public void setAlbumTypeModel(AlbumTypeModel albumTypeModel) {
		this.albumTypeModel = albumTypeModel;
	}
	
}
