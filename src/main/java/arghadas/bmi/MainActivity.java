package arghadas.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calcBtn;
    private TextView result, status;
    private EditText weight, height;
    private Bmi bmi = new Bmi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = (Button) findViewById(R.id.calcBtn);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        result = (TextView) findViewById(R.id.result);
        status = (TextView) findViewById(R.id.status);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnBg();
                calculateBmi();
                calcBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn));
            }
        });
    }

    private void changeBtnBg() {
        calcBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_pressed));
    }

    private void calculateBmi() {
        if (weight.getText().length() < 1 || height.getText().length() < 1) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
        } else {
            double w = Double.parseDouble(weight.getText().toString());
            double h = Double.parseDouble(height.getText().toString());
            bmi.calculateBmi(w, h);
            result.setText(bmi.getStatus());
            status.setText(bmi.getStatus());
        }
    }
}
