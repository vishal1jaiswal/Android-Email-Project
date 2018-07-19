package vishaljai.v_email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button butSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo=(EditText)findViewById(R.id.editText1);
        editTextSubject=(EditText)findViewById(R.id.editText2);
        editTextMessage=(EditText)findViewById(R.id.editText3);

         butSend=(Button)findViewById(R.id.but);


        butSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to=editTextTo.getText().toString();
                String sub=editTextSubject.getText().toString();
                String mes=editTextMessage.getText().toString();

                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,sub);
                email.putExtra(Intent.EXTRA_SUBJECT,mes);
                //need this to prompts email client only

                email.setType("message/rfc2580");
                startActivity(Intent.createChooser(email,"choose an Email client"));
            }
        });


    }
}
