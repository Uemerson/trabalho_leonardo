package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Uemerson
 */
public class TextFieldIconPlaceHolder extends JTextField implements DocumentListener{
    
    //Icone
    private static final int ICON_SPACING = 5;
    private Border mBorder;
    private Icon mIcon;
    
    //Place Holder
    private String placeholder = "";
    private Color phColor= new Color(0,0,0);
    private boolean band = true;
    
    //Max Length
    private int limit;
    
    //Caixa alta
    private boolean upper = false;
    private boolean onlyNumber = false;
    
    public TextFieldIconPlaceHolder(){
        getDocument().addDocumentListener(this);
    }
       
    public void setMaxLength(int limit){
        this.limit = limit;
        
        if (!onlyNumber)
            this.setDocument(new JTextFieldLimit(limit, upper));
        else
            this.setDocument(new JTextFieldLimit(limit, upper, onlyNumber));
        
        getDocument().addDocumentListener(this);
    }
    
    public void setUpper(boolean upper){
        this.upper = upper;
    }
    
    public void setOnlyNumber(boolean onlyNumber){
        this.onlyNumber = onlyNumber;
    }
    
    @Override
    public void setBorder(Border border)
    {
        mBorder = border;

        if (mIcon == null)
        {
            super.setBorder(border);
        } 

        else 
        {
            Border margin = BorderFactory.createEmptyBorder(0, mIcon.getIconWidth() + ICON_SPACING, 0, 0);
            Border compoud = BorderFactory.createCompoundBorder(border, margin);
            super.setBorder(compoud);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) 
    {
        super.paintComponent(graphics);

        if (mIcon != null)
        {
            Insets iconInsets = mBorder.getBorderInsets(this);
            mIcon.paintIcon(this, graphics, iconInsets.left, iconInsets.top);
            
            //Place Holder
            graphics.setColor( new Color(phColor.getRed(),phColor.getGreen(),phColor.getBlue(),90));

            graphics.drawString((band)?placeholder:"",
                         getMargin().left + mIcon.getIconWidth() + ICON_SPACING + 5,
                         (getSize().height)/2 + getFont().getSize() / 2);
        }else {
            //Place Holder
            graphics.setColor( new Color(phColor.getRed(),phColor.getGreen(),phColor.getBlue(),90));

            graphics.drawString((band)?placeholder:"",
                         getMargin().left + 5,
                         (getSize().height)/2 + getFont().getSize() / 2);
        }
     
    }

    public void setIcon(Icon icon) 
    {
        mIcon = icon;
        resetBorder();
    }

    private void resetBorder() 
    {
        setBorder(mBorder);
    }

    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }
    
    public Color getPhColor() {
        return phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }    
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        band = false;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        band = (getText().length()>0) ? false:true ;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSelectedComponent(TextFieldIconPlaceHolder txtId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
