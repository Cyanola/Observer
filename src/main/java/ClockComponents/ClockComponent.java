package ClockComponents;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import observerComponents.Infastructure.Observer;

import java.time.LocalTime;

public class ClockComponent implements Observer {
    private final Text text = new Text();
    LocalTime date  =LocalTime.of(0,0,0);;
    @Override
    public void update() {
date = date.plusSeconds(1);
        text.setFont(new Font("Verdana", 25));
        text.setText(String.valueOf(date.getHour())+":"+String.valueOf(date.getMinute())+":"
        +String.valueOf(date.getSecond()));
    }

    public Text getClock(){
        return this.text;
    }


}
