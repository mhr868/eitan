package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {

	public static List<String> validate(User u, Boolean user_id_duplicate_check_flag, Boolean password_check_flag) {
		List<String> errors = new ArrayList<>();

		String user_id_error = _validateUser_id(u.getUser_id(), user_id_duplicate_check_flag);
		if(!user_id_error.equals("")) {
			errors.add(user_id_error);
		}

		String password_error = _validatePassword(u.getPassword(), password_check_flag);
		if(!password_error.equals("")) {
			errors.add(password_error);
		}

		String name_error = _validateName(u.getName());
		if(!name_error.equals("")) {
			errors.add(name_error);
		}

		return errors;
	}

	private static String _validateUser_id(String user_id, Boolean user_id_duplicate_check_flag) {
		if(user_id == null || user_id.equals("")) {
			return "ユーザーIDを入力してください。";
		}
		if(user_id_duplicate_check_flag) {
			EntityManager em = DBUtil.createEntityManager();
			long user_count = em.createNamedQuery("User_id_duplicate_Check", Long.class)
					.setParameter("user_id", user_id)
					.getSingleResult();
			em.close();

			if(user_count > 0) {
				return "入力されたユーザーidの情報はすでに存在しています。";
			}
		}
		return "";
	}

	private static String _validatePassword(String password, Boolean password_check_flag) {
		if(password_check_flag &&(password == null || password.equals(""))) {
			return "パスワードを入力してください。";
		}
		return "";
	}

	private static String _validateName(String name) {
		if(name == null || name.equals("")) {
			return "名前を入力してください。";
		}
		return "";
	}

}
