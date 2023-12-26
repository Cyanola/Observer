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
    {инициализация анимации}
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
    public void update() {
        if (какой-то счетчик проверить){
            
            fade.play();
            this.meme = new Director().Construct(memeBuilder, text, color);
        }
        else{
            fade.stop();
        }
    }
}
