package br.com.mayke.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.mayke.data.vo.v2.PersonVOV2;
import br.com.mayke.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setBirthDay(new Date());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 personV2) {
		Person entity = new Person();
		entity.setId(personV2.getId());
//		entity.setBirthDay(new Date());
		entity.setAddress(personV2.getAddress());
		entity.setFirstName(personV2.getFirstName());
		entity.setLastName(personV2.getLastName());
		entity.setGender(personV2.getGender());
		return entity;
	}
}
