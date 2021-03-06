package fr.epsi.romaindauby.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;

import fr.epsi.romaindauby.dao.UserDao;
import fr.epsi.romaindauby.entity.User;

public class UserDaoTest extends AbstractDaoTest {
	@Autowired
	UserDao userDao;
	
	public void testFind() {
		assertTrue(userDao.find(1L).getName().equals("Dauby"));
	}

	@Test
	public void testUpdate() {
		User user = userDao.find(2L);
		user.setName("TEST");
		userDao.update(user);
		assertTrue(userDao.find(2L).getName().equals("TEST"));
	}

	@Test
	public void testSave() throws ParseException{
		User user = new User();
		user.setEmail("Test14@gmail.com");
		user.setName("Test14");
		user.setSurname("Test14");
		user.setPassword("Test14");
		userDao.save(user);

		assertTrue(userDao.find(user.getId()).getName().equals("Test14"));
	}

	@Test
	public void testDelete() {
		userDao.delete(userDao.find(3L));
		assertTrue(userDao.find(3L) == null);
	}
}