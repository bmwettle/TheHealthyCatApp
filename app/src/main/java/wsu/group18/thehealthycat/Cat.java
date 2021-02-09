package wsu.group18.thehealthycat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {

    public String Name;
    public double TargetWeightLBS;
    public double CurrentWeightLBS;
    public List HistoricalWeightData = new ArrayList<HistoricalWeightEvent>();

    public Cat(){
        Name = "";
        TargetWeightLBS = 0.0;
        CurrentWeightLBS = 0.0;
        HistoricalWeightData = new ArrayList<HistoricalWeightEvent>();

    }

    public Cat(String name, double targetWeight, double currentWeight, List<HistoricalWeightEvent> historicalWeightData) {
        Name = name;
        TargetWeightLBS = targetWeight;
        CurrentWeightLBS = currentWeight;
        HistoricalWeightData = historicalWeightData;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getTargetWeightLBS() {
        return TargetWeightLBS;
    }

    public void setTargetWeightLBS(double targetWeightLBS) {
        TargetWeightLBS = targetWeightLBS;
    }

    public double getCurrentWeightLBS() {
        return CurrentWeightLBS;
    }

    public void setCurrentWeightLBS(double currentWeightLBS) { CurrentWeightLBS = currentWeightLBS; }

    public List getHistoricalWeightData() {
        return HistoricalWeightData;
    }

    public void setHistoricalWeightData(List historicalWeightData) {
        HistoricalWeightData = historicalWeightData;
    }

}

