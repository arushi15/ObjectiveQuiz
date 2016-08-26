package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;                                                   // TODO: 8/25/2016      intent
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mHintButton;
    private Button mCheatButton;
    int divi=0;
    int randnum;
    boolean hint,cheat;
    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mHintButton= (Button) findViewById(R.id.HintButton);
        mCheatButton= (Button) findViewById(R.id.CheatButton);

//        mTrueButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "Clicked True");
//            }
//        });
         randnum=genrand1();
        mTrueButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (primenum(randnum)==1)
                {
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();

                }

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (primenum(randnum)==1)
                {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public int genrand1()
    {
        Random r1 = new Random();
        randnum = r1.nextInt(1000) + 1;
        TextView text1 = (TextView) findViewById(R.id.textViewer);
        String str1 = String.valueOf(randnum);
        String question = "Is " + str1 + " a prime number?";
        text1.setText(question);
        return randnum;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnREsume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    int primenum(int n) {
        int x = n / 2;
        for (int i = 2; i <= x; i++)
        {
            if (n % i == 0)
            {
                divi=i;
                return 0;
            }
        }
        divi = 0;
        return 1;
    }

    public void genrandom(View view) {
        mHintButton.setEnabled(true);
        mCheatButton.setEnabled(true);
        genrand1();

    }

    public void hintfunction(View view)
    {
        Intent intent = new Intent(this, act1.class);
        primenum(randnum);
        intent.putExtra("key",randnum);
        intent.putExtra("key1",divi);
        mHintButton.setEnabled(hint);
        startActivity(intent);
    }

    public void cheatfunction(View view)
    {
        Intent intent=new Intent(this, act2.class);
        primenum(randnum);
        intent.putExtra("key2", randnum);
        intent.putExtra("key3",divi);
        mCheatButton.setEnabled(cheat);
        startActivity(intent);
      }
}
