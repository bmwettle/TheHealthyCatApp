package wsu.group18.thehealthycat;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class CatInfo extends AppCompatActivity {

    TextView cName;
    TextView cCurrentWeight;
    TextView cTargetWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cName = findViewById(R.id.catNameVal);
        cCurrentWeight = findViewById(R.id.CurrentWeightVal);
        cTargetWeight = findViewById(R.id.TargetWeightVal);

        String a = getIntent().getStringExtra("CAT_NAME");
        String b =  String.valueOf(getIntent().getDoubleExtra("CAT_TARGET_WEIGHT", 0.0));
        String c = String.valueOf(getIntent().getDoubleExtra("CAT_CURRENT_WEIGHT", 0.0));

        cName.setText(getIntent().getStringExtra("CAT_NAME"));
        cTargetWeight.setText(String.valueOf(getIntent().getDoubleExtra("CAT_TARGET_WEIGHT", 0.0)));
        cCurrentWeight.setText(String.valueOf(getIntent().getDoubleExtra("CAT_CURRENT_WEIGHT", 0.0)));
    }
}