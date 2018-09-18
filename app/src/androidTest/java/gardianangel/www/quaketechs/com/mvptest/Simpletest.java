package gardianangel.www.quaketechs.com.mvptest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import gardianangel.www.quaketechs.com.mvptest.model.ILoginProcess;
import gardianangel.www.quaketechs.com.mvptest.model.IUser;
import gardianangel.www.quaketechs.com.mvptest.presenter.LoginPresenter;
import gardianangel.www.quaketechs.com.mvptest.view.ILoginView;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class Simpletest {

    LoginPresenter loginPresenter;
    @Mock
    ILoginView iLoginView;
    @Mock
    IUser iUser;


@Test
public void myTest(){
    loginPresenter = new LoginPresenter(iUser);
    loginPresenter.attachView(iLoginView);
    doAnswer(new Answer() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            ((ILoginProcess)invocation.getArguments()[2]).onSuccess();
            return null;
        }
    }).when(iUser).isValideDate(anyString(), anyString(), any(ILoginProcess.class));
    loginPresenter.onLogin("", "");
    verify(iLoginView).onLoginResult("Login Error");
 }
}
