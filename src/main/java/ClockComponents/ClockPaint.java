package ClockComponents;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import observerComponents.Infastructure.Observer;

import java.time.LocalTime;

public class ClockPaint  extends StackPane implements Observer {
    private final double width = 300;
    private final double height = 300;
    Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    @Override
    public void update() {
drawClock(gc);
    }
    LocalTime time;
    public ClockPaint(){
     time = LocalTime.of(0,0,0);
            this.panel.getChildren().add(canvas);

    }
    private final StackPane panel = new StackPane();
    public StackPane getPanel(){
        return this.panel;
    }
    private void drawClock(GraphicsContext gc) {
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(centerX, centerY) * 0.9;


        time= time.plusSeconds(1);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();


        gc.clearRect(0, 0, width, height);


        gc.setFill(Color.WHITE);
        gc.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);


        gc.setFill(Color.BLACK);
        double fontSize = radius * 0.1;
        gc.setFont(Font.font(fontSize));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.PI / 6 * (i - 3);
            double labelX = centerX + Math.cos(angle) * radius * 0.8 - fontSize / 2;
            double labelY = centerY + Math.sin(angle) * radius * 0.8 + fontSize / 4;
            gc.fillText(Integer.toString(i), labelX, labelY);
        }


        double hourAngle = Math.toRadians((hour % 12 + minute / 60.0) * 30);
        double hourHandLength = radius * 0.5;
        drawHand(gc, centerX, centerY, hourAngle, hourHandLength, Color.BLACK);


        double minuteAngle = Math.toRadians((minute + second / 60.0) * 6);
        double minuteHandLength = radius * 0.7;
        drawHand(gc, centerX, centerY, minuteAngle, minuteHandLength, Color.BLACK);


        double secondAngle = Math.toRadians(second * 6);
        double secondHandLength = radius * 0.8;
        drawHand(gc, centerX, centerY, secondAngle, secondHandLength, Color.RED);
    }
    private void drawHand(GraphicsContext gc, double centerX, double centerY, double angle, double handLength, Color color) {
        gc.setStroke(color);
        gc.setLineWidth(2);
        double x2 = centerX + Math.sin(angle) * handLength;
        double y2 = centerY - Math.cos(angle) * handLength;
        gc.strokeLine(centerX, centerY, x2, y2);
    }

}
