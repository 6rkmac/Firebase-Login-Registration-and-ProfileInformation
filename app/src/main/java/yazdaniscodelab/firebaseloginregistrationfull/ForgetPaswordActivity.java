package yazdaniscodelab.firebaseloginregistrationfull;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPaswordActivity extends AppCompatActivity {

    private EditText inputemail;
    private Button btnrest;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pasword);

        firebaseAuth=FirebaseAuth.getInstance();
        inputemail=(EditText)findViewById(R.id.emailReset_xml);
        btnrest=(Button)findViewById(R.id.forget_password_btn);

        btnrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=inputemail.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Input Your Registered Email Address",Toast.LENGTH_LONG).show();
                    return;
                }


                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"We have sent you " +
                                            "instruction to rest password",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Field to reset Password",Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }

        });

    }
}
