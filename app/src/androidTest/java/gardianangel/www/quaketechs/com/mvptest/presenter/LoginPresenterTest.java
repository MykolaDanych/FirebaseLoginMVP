package gardianangel.www.quaketechs.com.mvptest.presenter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginPresenterTest {

    @Test
    public void onLogin() {
        assertEquals(LoginPresenter.sum(12),22);
    }

}