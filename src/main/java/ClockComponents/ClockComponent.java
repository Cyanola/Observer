package ClockComponents;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import observerComponents.Infastructure.Observable;
import observerComponents.Infastructure.Observer;

import java.time.LocalTime;
import java.util.Date;

public class ClockComponent implements Observer {
    private final Text text = new Text();
    LocalTime date;
    @Override
    public void update() {
        date= LocalTime.now();
        text.setFont(new Font("Verdana", 25));
        text.setText(String.valueOf(date.getHour())+":"+String.valueOf(date.getMinute())+":"
        +String.valueOf(date.getSecond()));
    }

    public Text getClock(){
        return this.text;
    }


}
