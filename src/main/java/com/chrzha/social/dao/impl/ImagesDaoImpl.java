package com.chrzha.social.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.chrzha.social.dao.ImagesDao;
import com.chrzha.social.entity.Image;

@Repository
public class ImagesDaoImpl implements ImagesDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private Session session;
	 
	@SuppressWarnings("unchecked")
	public List<Image> getImages() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Image");
	}

	@Override
	public void saveImage(Image image) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(image);
	}

}
