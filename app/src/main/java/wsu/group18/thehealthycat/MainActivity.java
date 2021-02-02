package wsu.group18.thehealthycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Cat cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}