package wsu.group18.thehealthycat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {

    private String Name;
    private double TargetWeightLBS;
    private double CurrentWeightLBS;
    private List HistoricalWeightData;
    private List FeedingTimes;

    public Cat(){
        Name = "";
        TargetWeightLBS = 0.0;
        CurrentWeightLBS = 0.0;
        HistoricalWeightData = new ArrayList<HistoricalWeightEvent>();
        FeedingTimes = new ArrayList<LocalTime>();
    }

    public Cat(String name, double targetWeight, double currentWeight, List<HistoricalWeightEvent> historicalWeightData, List<LocalTime> feedingTimes) {
        Name = name;
        TargetWeightLBS = targetWeight;
        CurrentWeightLBS = currentWeight;
        HistoricalWeightData = historicalWeightData;
        FeedingTimes = feedingTimes;
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

    public List getFeedingTimes() {
        return FeedingTimes;
    }

    public void setFeedingTimes(List feedingTimes) {
        FeedingTimes = feedingTimes;
    }

}

