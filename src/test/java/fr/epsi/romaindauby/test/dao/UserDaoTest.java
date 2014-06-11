package fr.epsi.romaindauby.test.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;

import fr.epsi.romaindauby.dao.UserDao;
import fr.epsi.romaindauby.entity.User;

public class UserDaoTest extends AbstractDaoTest {
	@Autowired
	UserDao userDao;
	private Long id;
	private String email;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		User user = new User();
		user.setEmail("romain.dauby@gmail.com");
		user.setName("dauby");
		user.setSurname("romain");
		user.setPassword("password");
		userDao.save(user);
		this.id = user.getId();
		this.email = user.getEmail();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		userDao.delete(userDao.find(this.id));
	}
	
	@Test
	public void testFind() {
		assertTrue(userDao.find(this.id).getName().equals("dauby"));
	}
	
	@Test
	public void testFindByEmail() {
		assertTrue(userDao.findByEmail(this.email).getName().equals("dauby"));
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
		User user = userDao.find(this.id);
		user.setName("Mandi");
		userDao.update(user);
		assertTrue(userDao.find(this.id).getName().equals("Mandi"));
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