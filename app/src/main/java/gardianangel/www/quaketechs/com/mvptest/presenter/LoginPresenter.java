package gardianangel.www.quaketechs.com.mvptest.presenter;

import gardianangel.www.quaketechs.com.mvptest.model.ILoginProcess;
import gardianangel.www.quaketechs.com.mvptest.model.IUser;
import gardianangel.www.quaketechs.com.mvptest.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;
    private IUser iUser;

    public LoginPresenter(IUser iUser) {
        this.iUser = iUser;
    }

    @Override
    public void attachView(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        iUser.isValideDate(email, password, new ILoginProcess() {
            @Override
            public void onSuccess() {
                loginView.onLoginResult("Login Success");
            }

            @Override
            public void onFaild() {
                loginView.onLoginResult("Login Error");
            }

    });
    }
    public static int sum(int a){
        return a + 11;
    }
}
