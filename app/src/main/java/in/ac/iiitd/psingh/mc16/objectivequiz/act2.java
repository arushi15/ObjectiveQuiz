package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act2 extends AppCompatActivity {

    private Button mBackButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        mBackButton2 = (Button) findViewById(R.id.BackButton2);
        int value2 = getIntent().getExtras().getInt("key2");
        TextView text2 = (TextView) findViewById(R.id.textView2);
        int value1 = getIntent().getExtras().getInt("key3");
        if(value1!=0)
        {
            String str1 = String.valueOf(value1);
            String answer = value2 + " is not a Prime Number";
            text2.setText(answer);
        }
        if(value1==0)
        {
            String str2 = value2 + " is a Prime Number";
            text2.setText(str2);
        }

    }
    public void backfunction2(View view)
    {
        finish();
    }
}
