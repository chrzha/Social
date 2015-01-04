package com.chrzha.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chrzha.social.dao.ImagesDao;
import com.chrzha.social.entity.Image;
import com.chrzha.social.service.ImagesService;

@Service("imagesService")
@Transactional
public class ImagesServiceImpl implements ImagesService{

	@Autowired
	private ImagesDao imagesDao;
	
	public List<Image> getImages() {
		// TODO Auto-generated method stub
		
		return imagesDao.getImages();
	}

	@Override
	public void saveImage(Image image) {
		// TODO Auto-generated method stub
		imagesDao.saveImage(image);
	}

}
