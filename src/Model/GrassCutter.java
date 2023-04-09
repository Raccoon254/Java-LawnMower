package Model;
import view.*;
import Model.*;
import controller.*;

import java.awt.*;

public class GrassCutter {
    public void cut(Mower thisMower) {
        thisMower.getLawn().lawnPanel.setCellColor(thisMower.getPositionX(), thisMower.getPositionY(), Color.WHITE);
    }
    public int getWidth() {
        return 20;
    }
}
