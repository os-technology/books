package basic.tutorial.exception;

public class InputUser {

	public String checkUser(UserInformation user) throws UserInfoException {
		if (user.getName() == null) {
			throw new UserInfoException("用户名为空");
		}
		if (user.getMail() == null || "".equals(user.getMail())) {
			throw new UserInfoException("User mail is null");
		}

		return "SUCCESS";
	}

}
