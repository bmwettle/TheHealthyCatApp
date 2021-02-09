package wsu.group18.thehealthycat;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TextInputEditText cName;
    TextInputEditText cTargetWeight;
    Button SaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cName = findViewById(R.id.NameEditText);
        cTargetWeight = findViewById(R.id.TargetWeightEditText);

        SaveButton = findViewById(R.id.SettingsSaveButton);
        SaveButton.setFocusableInTouchMode(false);

        String name = getIntent().getStringExtra("CAT_NAME");
        String targetWeight = String.valueOf(getIntent().getDoubleExtra("CAT_TARGET_WEIGHT", 0.0));

        if(!name.isEmpty()){
            cName.setText(name);
        }
        if(!targetWeight.isEmpty()){
            cTargetWeight.setText(targetWeight);
        }
    }

    /*public void CanSave(){
        String name = getIntent().getStringExtra("CAT_NAME");
        String targetWeight = String.valueOf(getIntent().getDoubleExtra("CAT_TARGET_WEIGHT", 0.0));

        if(cName.toString().isEmpty() || cTargetWeight.toString().isEmpty()){
            SaveButton.setClickable(false);
        }
        else if(cName.toString() != name || cTargetWeight.toString() != targetWeight){
            SaveButton.setClickable(true);
        }
        else{
            SaveButton.setClickable(false);
        }
    }*/

    public void OnCancel(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void OnSave(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("CAT_NAME", cName.getText().toString());
        intent.putExtra("CAT_TARGET_WEIGHT", Double.parseDouble(cTargetWeight.getText().toString()));
        startActivity(intent);
    }
}