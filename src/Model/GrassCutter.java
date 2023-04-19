package Model;

import java.awt.*;
/*
* --This class is used to cut the grass.
* --This class has only one method --@cut()
* --By changing the color of the cell to white the grass is cut
*/
public class GrassCutter {
    public void cut(Mower thisMower) {
        thisMower.getLawn().lawnPanel.setCellColor(thisMower.getPositionX(), thisMower.getPositionY(), Color.WHITE);
    }
    public int getWidth() {
        return 20;
    }
}
