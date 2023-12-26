package ImageComponent;

import builderComponents.ImageBuilder;
import builderComponents.Director;
import javafx.animation.FadeTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.ImageText;
import observerComponents.Infastructure.Observer;

import java.util.Date;
public class ImagePane implements Observer {
    private Director memeDirector;
    private final ImageBuilder memeBuilder;
    private ImageText meme;
    String text;
    Color color;
    private final FadeTransition fade = new FadeTransition();

    public ImagePane(String text, Color color){
        memeBuilder = new ImageBuilder();
        memeDirector = new Director();
        meme = memeDirector.Construct(memeBuilder, text, color);
this.text = text;
this.color=color;
            fade.setNode(this.meme.getPanel());
        fade.setCycleCount(1000);
    }

    public StackPane buildMeme(){
        return meme.getPanel();
    }
    @Override
    public void update(Date date) {
        if (date.getSeconds() % 5 == 0){
            fade.setDuration(new Duration(1200));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
            this.meme = new Director().Construct(memeBuilder, text, color);
        }
        else{
            fade.stop();
        }
    }
}
