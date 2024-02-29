package builderComponents;

import javafx.scene.paint.Color;
import model.ImageText;

public class Director {

    public ImageText Construct(ImageBuilder builder, String text, Color color){
        builder.setImage();
        builder.setDesign();
        builder.setColor(color);
        builder.setText(text);
        return builder.build();
    }

}
