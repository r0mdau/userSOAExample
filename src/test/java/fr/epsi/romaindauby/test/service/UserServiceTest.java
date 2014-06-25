package fr.epsi.romaindauby.test.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epsi.romaindauby.common.CampusException;
import fr.epsi.romaindauby.entity.User;
import fr.epsi.romaindauby.service.UserService;

public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	UserService userService;

	private final static User user = new User();

	@Test
	public void testPasswordMatchWithEmail() {
		user.setEmail("romain.dauby@gmail.com");
		user.setPassword("ngLzopB+RVaKg+Lx5Uuu3w==");
		Assert.assertTrue(userService.passwordMatchWithEmail(user.getEmail(), user.getPassword()));
	}

	@Test
	public void testPasswordDoesntMatchWithEmail() {
		user.setEmail("romain.dauby@gmail.com");
		user.setPassword("ngLzopB+RVaKg+Lx5Uuu3w=s");
		Assert.assertFalse(userService.passwordMatchWithEmail(user.getEmail(), user.getPassword()));
	}

	@Test
	public void testEmailExist() throws CampusException {
		user.setEmail("romain.dauby@gmail.com");
		Assert.assertTrue(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testEmailDoesntExist() throws CampusException {
		user.setEmail("fakeEmail@gmail.com");
		Assert.assertFalse(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testGetUserByEmail() {
		user.setEmail("romain.dauby@gmail.com");
		Assert.assertTrue(userService.getUserByMail(user.getEmail()).getName().equals("Dauby"));
	}

	@Test
	public void testPasswordConfirmMatchPassword() {
		Assert.assertTrue(userService.passwordConfirmMatchPassword("Test13", "Test13"));
	}

	@Test
	public void testPasswordConfirmDoesntMatchPassword() {
		Assert.assertFalse(userService.passwordConfirmMatchPassword("Test13", "pass"));
	}

}
