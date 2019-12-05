package com.sparity.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sparity.shoppingcart.base.model.BaseModel;

@Entity
@Table(name="album_type")
public class AlbumTypeModel extends BaseModel {
	private static final long serialVersionUID = -8211971032161526434L;
	@Id
	@GeneratedValue
	@Column(name = "album_type_id",unique=true, nullable=false, precision=10)
	private Long albumId;
	
	@Column(name="album_type", length=80)
	private String albumType;

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}
	
	
}
