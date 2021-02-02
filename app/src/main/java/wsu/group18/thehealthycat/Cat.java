package wsu.group18.thehealthycat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cat {

    public String Name;
    public double TargetWeightLBS;
    public double CurrentWeightLBS;
    public List HistoricalWeightData = new ArrayList<HistoricalWeightEvent>();

    public Cat(String name, double targetWeight, double currentWeight, List<HistoricalWeightEvent> historicalWeightData){
        Name = name;
        TargetWeightLBS = targetWeight;
        CurrentWeightLBS = currentWeight;
        HistoricalWeightData = historicalWeightData;
    }
}

