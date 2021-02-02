package wsu.group18.thehealthycat;
import java.time.LocalDateTime;

public class HistoricalWeightEvent{
    public double Weight;
    public LocalDateTime Time;

    public HistoricalWeightEvent(double weight, LocalDateTime time){
        Weight = weight;
        Time = time;
    }
}
