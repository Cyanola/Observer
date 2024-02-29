package builderComponents;

import javafx.scene.paint.Color;
import model.ImageText;

public interface Builder {
    public void setImage();
    public void setText(String text);
    public void setDesign();
    public void setColor(Color color);
    public ImageText build();
}