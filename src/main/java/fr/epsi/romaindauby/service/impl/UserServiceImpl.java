package fr.epsi.romaindauby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.romaindauby.common.CampusException;
import fr.epsi.romaindauby.dao.UserDao;
import fr.epsi.romaindauby.entity.User;
import fr.epsi.romaindauby.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public boolean emailExists(String email) throws CampusException {
		if (userDao.findByEmail(email) != null)
			return true;
		return false;
	}

	public User getUserByMail(String email) {
		return userDao.findByEmail(email);
	}

	public boolean passwordConfirmMatchPassword(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm))
			return true;
		return false;
	}

	public boolean passwordMatchWithEmail(String email, String password) {
		if (userDao.findByEmail(email) != null && userDao.findByEmail(email).getPassword().equals(password))
			return true;
		return false;
	}
}
