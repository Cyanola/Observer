package observerComponents;

import observerComponents.Infastructure.Observable;
import observerComponents.Infastructure.Observer;

import java.text.SimpleDateFormat;
import java.util.*;


public class TimeServer implements Observable {
    private final List<Observer> observers;
    private Timer timer;
    private TimerTask task;
    private Date currentDate;
    public TimeServer(){
        this.currentDate = new Date();
        this.observers = new ArrayList<>();
        this.timer = new Timer();
        this.task = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };

        this.timer.schedule(task,currentDate,1200);
    }
    private void tick(){
        var temp_date = Calendar.getInstance();
        temp_date.add(Calendar.SECOND, 1);
        currentDate = temp_date.getTime();
        var formatter = new SimpleDateFormat("HH:mm:ss");
        var formattedTime = formatter.format(currentDate);
        System.out.println(formattedTime);
        notifyAllObserver();
    }

    @Override
    public void notifyAllObserver() {
        for(var item : observers){
           item.update();
        }
    }

    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }

}
