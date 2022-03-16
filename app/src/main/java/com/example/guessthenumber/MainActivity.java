package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private TextView result;
    private Button prev,next,guess;

    int rNum = new Random().nextInt(100);
    int noOfGuess=0;
    int pNum=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.number);
        result = (TextView) findViewById(R.id.result);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        guess = (Button) findViewById(R.id.guess);

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=number.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter A Number!", Toast.LENGTH_SHORT).show();
                }
                else{
                    int num=Integer.parseInt(str);
                    if(num == 6969){
                        Toast.makeText(MainActivity.this, (Integer.toString(rNum)), Toast.LENGTH_SHORT).show();
                    }
                    else if(num<0 || num>100){
                        Toast.makeText(MainActivity.this, "Enter the number between 0 to 100!", Toast.LENGTH_SHORT).show();
                    }
                    else if(num == pNum){
                        Toast.makeText(MainActivity.this, "Please Change The Number.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        noOfGuess++;
                        pNum = num;
                        if(num == rNum){
                            result.setText("Congratulation,You guessed it in "+Integer.toString(noOfGuess)+" attempts.");
                        }
                        else if(num > rNum){
                            result.setText("The Number Is Lower"+"(Guess:"+Integer.toString(noOfGuess)+")");
                        }
                        else{
                            result.setText("The Number Is Higher"+"(Guess:"+Integer.toString(noOfGuess)+")");
                        }
                    }
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=number.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter A Number!", Toast.LENGTH_SHORT).show();
                }
                else{
                    int num=Integer.parseInt(str);
                    if(num>0){
                        num--;
                    }
                    number.setText(Integer.toString(num));
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=number.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter A Number!", Toast.LENGTH_SHORT).show();
                }
                else{
                    int num=Integer.parseInt(str);
                    if(num<100){
                        num++;
                    }
                    number.setText(Integer.toString(num));
                }
            }
        });
    }
}