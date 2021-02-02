package wsu.group18.thehealthycat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Cat cat;

    public String ChartButton = "Chart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean hasStarted = prefs.getBoolean("hasStarted", true);

        if (hasStarted) {
            showStartupDialog();
        }

        initializeCatClass();
    }

    public void OpenChartActivity(View v){
        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }

    public void OpenSettingsActivity(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void OpenCatInfoActivity(View v){
        Intent intent = new Intent(this, CatInfo.class);
        intent.putExtra("CAT_NAME", cat.Name);
        intent.putExtra("CAT_TARGET_WEIGHT", cat.TargetWeightLBS);
        intent.putExtra("CAT_CURRENT_WEIGHT", cat.CurrentWeightLBS);
        startActivity(intent);
    }

    private void initializeCatClass(){
        // TO-DO: This is where we will communicate between the cat feeder and the app to get all the necessary cat info.

        //The following is hard coded values for test purposes:
        List l = new ArrayList<>();
        cat = new Cat("Fred", 7.0, 10.0, l);
    }

    private void showStartupDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View startupDialogView = inflater.inflate(R.layout.startup_dialog, null);
        builder.setTitle("Welcome to the Healthy Cat!");

        final EditText catNameInput = (EditText) startupDialogView.findViewById(R.id.cat_name);
        final EditText targetWeightInput = (EditText) startupDialogView.findViewById(R.id.target_weight);
        builder.setView(startupDialogView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TO-DO Save Input name and target weight to Cat object

                //catName = catNameInput.getText().toString();
                //targetWeight = targetWeightInput.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("hasStarted", false);
        editor.apply();
    }
}