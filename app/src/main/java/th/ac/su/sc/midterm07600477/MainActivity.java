package th.ac.su.sc.midterm07600477;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import th.ac.su.sc.midterm07600477.model.Auth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                EditText userEdittext = findViewById(R.id.user_edit_text);
                EditText passwordEdittext = findViewById(R.id.password_edit_text);
                String inputuser = userEdittext.getText().toString();
                String inputpass = passwordEdittext.getText().toString();
                Auth auth = new Auth(inputuser,inputpass);
                final boolean result = auth.check();
                if(result==true){
                    Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("aaa", inputuser);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this,"ยินดีต้อนรับ ",Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage(R.string.Invalid);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }
            }
        });
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },1000);
    }
}
