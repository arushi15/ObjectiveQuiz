package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act1 extends AppCompatActivity {

    private Button mBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        mBackButton = (Button) findViewById(R.id.BackButton);
        int value = getIntent().getExtras().getInt("key");
        TextView text1 = (TextView) findViewById(R.id.textView1);
        int value1 = getIntent().getExtras().getInt("key1");
        if(value1!=0)
        {
            String str1 = String.valueOf(value1);
            String question = value + " is divisible by " + value1;
            text1.setText(question);
        }
        if(value1==0)
        {
            String str2 = value+ " is not divisible by any number";
            text1.setText(str2);
        }
    }

    public void backfunction1(View view)
    {
        finish();
    }
}
