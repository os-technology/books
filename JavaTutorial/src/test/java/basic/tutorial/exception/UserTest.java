package basic.tutorial.exception;

import org.junit.Test;

public class UserTest {
	@Test
	public void testInput() {
		InputUser input = new InputUser();
		UserInformation user = new UserInformation();
		try {
			input.checkUser(user);
		} catch (UserInfoException e) {
			e.printStackTrace();
		}
	}

}
