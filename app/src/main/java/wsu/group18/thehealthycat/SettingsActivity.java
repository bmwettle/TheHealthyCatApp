package wsu.group18.thehealthycat;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    TextInputEditText cName;
    TextInputEditText cTargetWeight;
    Button SaveButton;

    private RecyclerView recyclerView;
    private CustomTimeAdapter customAdapter;
    public ArrayList<TimeEditModel> editModelArrayList;

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

        recyclerView = findViewById(R.id.TimeEditorList);
        editModelArrayList = populateList();
        customAdapter = new CustomTimeAdapter(this, editModelArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
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

    private ArrayList<TimeEditModel> populateList(){

        ArrayList<TimeEditModel> list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            TimeEditModel editModel = new TimeEditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }

        return list;
    }
}