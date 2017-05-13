package ph.com.juan.lazy.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private EditText message;
    private Button register, signIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText) findViewById(R.id.etMessage);

        register = (Button) findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        signIn = (Button) findViewById(R.id.btnSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user != null){
                    mAuth.signOut();
                    signIn.setText("Sign In");
                    register.setVisibility(View.VISIBLE);
                } else {
                    startActivity(new Intent(MainActivity.this, SignInActivity.class));
                }
            }
        });

        Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, message.getText().toString());
                String value = message.getText().toString();
                DatabaseReference child = myRef.child("Name");
                child.setValue(value);
            }
        });
    }

    public void onUserUpdate(){
        super.onUserUpdate();
        if (user != null){
            signIn.setText("Sign Out");
            register.setVisibility(View.GONE);
        }
    }
}
