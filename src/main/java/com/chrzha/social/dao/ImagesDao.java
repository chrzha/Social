package com.chrzha.social.dao;

import java.util.List;

import com.chrzha.social.entity.Image;

public interface ImagesDao {

	public List<Image> getImages();
	public void saveImage(Image image);
}
