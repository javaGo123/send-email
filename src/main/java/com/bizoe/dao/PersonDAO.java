package com.bizoe.dao;

import com.bizoe.entity.Person;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangxinxin
 */
//@Mapper
@Repository
public interface PersonDAO {
//	/**
//	 * getPersonById
//	 * @param id
//	 * @return Person
//	 */
//	@Select("SELECT id, first_name AS firstName, last_name AS lastName, birth_date AS birthDate, sex, phone_no AS phoneNo"
//			+ " FROM test.t_person WHERE id=#{0};")
//	Person getPersonById(int id);
//
//	/**
//	 * updatePersonById
//	 * @param person
//	 * @return int
//	 */
//	int updatePersonById(Person person);
//
//	/**
//	 * selectUnionPerson
//	 * @param ids
//	 * @return List<Person>
//	 */
//	List<Person> selectUnionPerson(@Param("ids") List<Integer> ids);
}
