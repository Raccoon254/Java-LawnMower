import java.awt.*;

public class GrassCutter {
    public void cut(Mower thisMower) {
        System.out.println("Cutting grass");
        thisMower.getLawn().lawnPanel.setCellColor(thisMower.getPositionX(), thisMower.getPositionY(), Color.WHITE);
    }
    public int getWidth() {
        return 20;
    }
}
