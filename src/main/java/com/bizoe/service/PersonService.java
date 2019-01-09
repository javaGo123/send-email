package com.bizoe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bizoe.dao.PersonDAO;
import com.bizoe.entity.Person;

/**
 * @author wangxinxin
 */
@Service
public class PersonService {
//	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	private PersonDAO personDao;
//
//	@Autowired
//	PersonService(PersonDAO personDao){
//		this.personDao=personDao;
//	}
//
//	/**
//	 * 根据id获取Person对象，使用缓存
//	 * @param id
//	 * @return Person对象
//	 */
//	@Cacheable(value="getPersonById", sync=true)
//	public Person getPersonById(int id){
//		logger.debug("getting data from database, personId={}", id);
//		return personDao.getPersonById(id);
//	}

}
