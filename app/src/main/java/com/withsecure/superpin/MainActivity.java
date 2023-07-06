package com.withsecure.superpin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static public String pin = "0000";
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generatePIN();
    }

    public static boolean checkCounter() {
        counter++;
        return counter > 3;
    }

    public void onClick(View view) {
        if(checkCounter()) {
            Toast.makeText(this, "go away", Toast.LENGTH_SHORT).show();
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("💀 Too many invalid attempts 💀");
            Button button = (Button)findViewById(R.id.button);
            button.setEnabled(false);
            return;
        }
        EditText text = (EditText)findViewById(R.id.pinBox);
        String currentPIN = text.getText().toString();
        if(checkPIN(currentPIN))
        {
            Toast.makeText(this, "CONGRATULATION YOU ARE WINNER", Toast.LENGTH_SHORT).show();
            counter = 0;
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText("🎈 WOW! 🎈");
        }
        else
        {
            Toast.makeText(this, "Wrong PIN :(", Toast.LENGTH_SHORT).show();
        }
    }

    public static void generatePIN()
    {
        int i = new Random().nextInt(10000);
        pin = String.format("%04d", i);
        //Toast.makeText(this, pin, Toast.LENGTH_SHORT).show();
    }

    public void showPIN()
    {
        Toast.makeText(this, pin, Toast.LENGTH_SHORT).show();
    }

    public static boolean checkPIN(String toCheck) {
        return toCheck.equals(pin);
    }
}