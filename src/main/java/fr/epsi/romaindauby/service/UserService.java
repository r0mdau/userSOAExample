package fr.epsi.romaindauby.service;

import fr.epsi.romaindauby.common.CampusException;
import fr.epsi.romaindauby.entity.User;

public interface UserService {

	/**
	 * Check if the entered email exists in the database
	 * @return
	 */
	public boolean emailExists(String email) throws CampusException;

	/**
	 * Return a user thanks to his mail
	 * @param email
	 * @return
	 */
	public User getUserByMail(String email);

	/**
	 * Check if password confirm match with password
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public boolean passwordConfirmMatchPassword(String password, String passwordConfirm);

	/**
	 * Check if the entered password match with the database password for the provided email
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean passwordMatchWithEmail(String email, String password);

}
