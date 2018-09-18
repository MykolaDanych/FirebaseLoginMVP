package gardianangel.www.quaketechs.com.mvptest.presenter;

import gardianangel.www.quaketechs.com.mvptest.view.ILoginView;

public interface ILoginPresenter {
    void onLogin(String email, String password);
    void attachView(ILoginView view);
}
