package fr.epsi.romaindauby.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.epsi.romaindauby.dao.AbstractDao;
import fr.epsi.romaindauby.dao.UserDao;
import fr.epsi.romaindauby.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super();
	}

	public User find(Long id) {
		return this.find(User.class, id);
	}

	public User findByEmail(String email) {
		try {
			return (User) getHibernateTemplate().find(
					"from User u where u.email =?", email).get(0);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}
}