import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.in28minutes.mvc.LoginService;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setup() {
        loginService = new LoginService();
    }

    @Test
    public void testValidateUser_ValidCredentials_In28Minutes() {
        assertTrue(loginService.validateUser("Minutes", "dummy"));
    }

    @Test
    public void testValidateUser_ValidCredentials_JohnDoe() {
        assertTrue(loginService.validateUser("johnDoe", "password123"));
    }

    @Test
    public void testValidateUser_ValidCredentials_JaneSmith() {
        assertTrue(loginService.validateUser("janeSmith", "letmein"));
    }

    @Test
    public void testValidateUser_InvalidCredentials() {
        assertFalse(loginService.validateUser("invalidUser", "invalidPassword"));
    }
}
