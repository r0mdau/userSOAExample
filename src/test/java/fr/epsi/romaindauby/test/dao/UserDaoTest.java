package fr.epsi.romaindauby.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epsi.romaindauby.dao.UserDao;

public class UserDaoTest extends AbstractDaoTest {

	@Autowired
	UserDao userDao;

	@Test
	public void testFind() {
		assertTrue(userDao.find(1L).getName().equals("dauby"));
	}
}