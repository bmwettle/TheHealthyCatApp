package wsu.group18.thehealthycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public String ChartButton = "Chart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        startActivity(intent);
    }
}