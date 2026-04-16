package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Aneeta Boni
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "225100695";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Aneeta Palampalliparambil Boni";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
	    LoginStatus status = LoginForm.login(null, null);
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	@Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("aneeta", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("aneeta", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "aneeta123");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "aneeta123");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndEmptyValidationCode() {
        LoginStatus status = LoginForm.login("aneeta", "aneeta123");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode(null));
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndWrongValidationCode() {
        LoginStatus status = LoginForm.login("aneeta", "aneeta123");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertFalse(LoginForm.validateCode("abc"));
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("aneeta", "aneeta123");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertTrue(LoginForm.validateCode("193"));
    }
}
	
