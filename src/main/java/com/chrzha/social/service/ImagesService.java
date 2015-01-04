package com.chrzha.social.service;

import java.util.List;

import com.chrzha.social.entity.Image;

public interface ImagesService {

	public List<Image> getImages();
	public void saveImage(Image image);
}
