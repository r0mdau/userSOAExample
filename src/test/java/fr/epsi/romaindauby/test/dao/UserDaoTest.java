package fr.epsi.romaindauby.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;

import fr.epsi.romaindauby.dao.UserDao;
import fr.epsi.romaindauby.entity.User;

public class UserDaoTest extends AbstractDaoTest {
	@Autowired
	UserDao userDao;
	
	@Test
	public void testFind() {
		User user = new User();
		user.setEmail("romain.dauby@gmail.com");
		user.setName("dauby");
		user.setSurname("romain");
		user.setPassword("password");
		userDao.save(user);
		
		assertTrue(userDao.find(user.getId()).getName().equals("dauby"));
		userDao.delete(userDao.find(user.getId()));
	}
	
	@Test
	public void testFindByEmail() {
		User user = new User();
		user.setEmail("romain.dauby@gmail.com");
		user.setName("dauby");
		user.setSurname("romain");
		user.setPassword("password");
		userDao.save(user);
		
		assertTrue(userDao.findByEmail("romain.dauby@gmail.com").getName().equals("dauby"));
		userDao.delete(userDao.find(user.getId()));
	}
	
	@Test
	public void testSave() throws ParseException{
		User user = new User();
		user.setEmail("georges.dupont@gmail.com");
		user.setName("Dupont");
		user.setSurname("Georges");
		user.setPassword("password");
		userDao.save(user);

		assertTrue(userDao.find(user.getId()).getName().equals("Dupont"));
		userDao.delete(userDao.find(user.getId()));
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setEmail("georges.dupont@gmail.com");
		user.setName("Dupont");
		user.setSurname("Georges");
		user.setPassword("password");
		userDao.save(user);
		
		User user2 = userDao.find(user.getId());
		user2.setName("Mandi");
		userDao.update(user2);
		assertTrue(userDao.find(user.getId()).getName().equals("Mandi"));
		userDao.delete(userDao.find(user.getId()));
	}
	
	@Test
	public void testDelete() {
		User user = new User();
		user.setEmail("georges.dupont@gmail.com");
		user.setName("Dupont");
		user.setSurname("Georges");
		user.setPassword("password");
		userDao.save(user);
		
		userDao.delete(userDao.find(user.getId()));
		assertTrue(userDao.find(user.getId()) == null);
	}
}