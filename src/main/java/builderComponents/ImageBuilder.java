package builderComponents;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.ImageText;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class ImageBuilder implements Builder {
    private final String fileTopic = new File("src//main//resources//Images//").getAbsolutePath() + "\\";
    private final ImageText img = new ImageText();
    private final Text text = new Text();

    @Override
    public void setImage() {
        Image image = new Image(Paths.get(fileTopic + "img"+ new Random().nextInt(1,12)  + ".jpg").toUri().toString());
        this.img.addImage(image);
    }

    @Override
    public void setText(String text) {
        this.text.setText(text);
        this.img.addText(this.text);
    }

    @Override
    public void setColor(Color color){
        text.setFill(color);
    }

    @Override
    public void setDesign(){
        text.fontProperty().setValue(Font.font("Verdana", FontWeight.BOLD, 12));
    }

    @Override
    public ImageText build() {
        return this.img;
    }
}
