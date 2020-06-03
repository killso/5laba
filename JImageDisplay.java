import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.JComponent;
public class JImageDisplay extends JComponent{
    public static final long serialVersionUID = 1L;
    public BufferedImage buffer;
    public JImageDisplay(int width, int height) {
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
        return;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(buffer, 0, 0, buffer.getWidth(), buffer.getHeight(), null);
        return;
    }
    public BufferedImage getImage() {
        return buffer;
    }
    //оба методы насписаны с помощью BufferedImage, подклчили выше
    public void clearImage() {
        //устанавливает все пиксели изображения в черный цвет (значение RGB 0)
        int width = getWidth();
        int height = getHeight();
        int[] rgbArray = new int[width * height];
        buffer.setRGB(0, 0, width, height, rgbArray, 0, 1);
        return;
    }
    public void drawPixel(int x, int y, int rgbColor) { //устанвливает пиксель в определеннй цвет
        buffer.setRGB(x, y, rgbColor);
        return;
    }
}

