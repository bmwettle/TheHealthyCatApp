package wsu.group18.thehealthycat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
//import android.support.v7.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        mChart = findViewById(R.id.chart);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);
        MyMarkerView mv = new MyMarkerView(getApplicationContext(), R.layout.custom_marker_view);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        renderData();
    }

    ArrayList<Entry> weights = new ArrayList<>();
    float targetWeight;

    public void renderData() {
        setData();
        LimitLine llXAxis = new LimitLine(10f, "Index 10");
        llXAxis.setLineWidth(4f);
        llXAxis.enableDashedLine(10f, 10f, 0f);
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);

        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum((float) weights.size());
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawLimitLinesBehindData(true);

        LimitLine targetWeightLine = new LimitLine(targetWeight, "Target Weight");
        targetWeightLine.setLineWidth(4f);
        targetWeightLine.enableDashedLine(10f, 10f, 0f);
        targetWeightLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        targetWeightLine.setTextSize(10f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(targetWeightLine);
        leftAxis.setAxisMaximum(25f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(false);

        mChart.getAxisRight().setEnabled(false);
    }

    private void setData() {

        //get data for historic weights
        //manual data entered for now to test chart
        weights.add(new Entry(0, 18.5f));
        weights.add(new Entry(1, 18.3f));
        weights.add(new Entry(2, 18.0f));
        weights.add(new Entry(3, 17.5f));
        weights.add(new Entry(4, 17.8f));
        weights.add(new Entry(5, 16.9f));
        weights.add(new Entry(7, 16.3f));
        weights.add(new Entry(8, 15.8f));
        weights.add(new Entry(9, 15.6f));
        weights.add(new Entry(10, 14.5f));
        weights.add(new Entry(11, 15.6f));
        weights.add(new Entry(12, 14.5f));

        //get value for target weight
        //manual value for now to test chart
        targetWeight = 12.6f;

        //create data set of past weights
        LineDataSet weightData;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            weightData = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            weightData.setValues(weights);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            weightData = new LineDataSet(weights, "Past Weights");
            weightData.setDrawIcons(false);
            weightData.enableDashedLine(10f, 5f, 0f);
            weightData.enableDashedHighlightLine(10f, 5f, 0f);
            weightData.setColor(Color.DKGRAY);
            weightData.setCircleColor(Color.DKGRAY);
            weightData.setLineWidth(1f);
            weightData.setCircleRadius(3f);
            weightData.setDrawCircleHole(false);
            weightData.setValueTextSize(9f);
            weightData.setDrawFilled(true);
            weightData.setFormLineWidth(1f);
            weightData.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            weightData.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_blue);
                weightData.setFillDrawable(drawable);
            } else {
                weightData.setFillColor(Color.DKGRAY);
            }
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(weightData);
            LineData data = new LineData(dataSets);
            mChart.setData(data);

        }
    }
}