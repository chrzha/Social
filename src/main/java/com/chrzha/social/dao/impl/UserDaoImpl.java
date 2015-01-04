package com.chrzha.social.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.chrzha.social.dao.UserDao;
import com.chrzha.social.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private Session session;
	 
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		/*session = hibernateTemplate.getSessionFactory().getCurrentSession(); 
		User user = (User) session.get(User.class, 1);
		List<User> list = new ArrayList<User>();
		list.add(user);*/
		return hibernateTemplate.find("from User");
	}

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
		return 1;
	}

}
