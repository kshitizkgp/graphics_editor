
package graphicseditor;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.event.MouseAdapter;


public class TextBox extends MouseAdapter{

    private String text = null;
    private Color c;
    private String font;
    private int font_size;

    public TextBox(String t, String f, int s, Color r){
        this.text = t;
        this.font = f;
        this.font_size = s;
        this.c = r;
    }

    public TextBox(TextBox t){
        this.text = t.text;
        this.c = t.c;
        this.font = t.font;
        this.font_size = t.font_size;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the c
     */
    public Color getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Color c) {
        this.c = c;
    }

    /**
     * @return the font
     */
    public String getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * @return the font_size
     */
    public int getFont_size() {
        return font_size;
    }

    /**
     * @param font_size the font_size to set
     */
    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }

}
