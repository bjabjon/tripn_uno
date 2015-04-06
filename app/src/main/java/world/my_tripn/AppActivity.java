package world.my_tripn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by bbj3 on 3/31/15.
 */

public class AppActivity extends Activity {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;
    private Button cambtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        Firebase.setAndroidContext(this);


        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        cambtn = (Button) findViewById(R.id.cambtn);


        // SqLite database handler



        // Fetching user details from sqlite

        //String name = user.get("name");
        //String email = user.get("email");

        // Displaying the user details on the screen
        //txtName.setText(name);
        //txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


        cambtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        CameraActivity.class);

                startActivity(i);
                finish();

            }
        });


    }




    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        // unauthorising user
        Firebase ref = new Firebase("https://vivid-torch-2644.firebaseio.com");
        ref.unauth();
        // Launching the login activity
        Intent intent = new Intent(AppActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
