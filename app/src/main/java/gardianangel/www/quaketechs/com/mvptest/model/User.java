package gardianangel.www.quaketechs.com.mvptest.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import gardianangel.www.quaketechs.com.mvptest.view.ILoginView;


public class User implements IUser {

    @Override
    public void isValideDate(String username, String password, final ILoginProcess iLoginProcess) {
       FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    iLoginProcess.onFaild();
                }else {
                    iLoginProcess.onSuccess();
                }
            }
        });

    }

}
