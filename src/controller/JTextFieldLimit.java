package controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Uemerson
 */
public class JTextFieldLimit extends PlainDocument{
    private int limit;
    private boolean upper;
    private boolean onlyNumber;
    
    public JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
    }

    public JTextFieldLimit(int limit, boolean upper) {
      super();
      this.limit = limit;
      this.upper = upper;
    }
    
    public JTextFieldLimit(int limit, boolean upper, boolean onlyNumber) {
      super();
      this.limit = limit;
      this.upper = upper;
      this.onlyNumber = onlyNumber;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null)
        return;

      if ((getLength() + str.length()) <= limit) {
        
        if (onlyNumber && isDigit(str))                                              //Verifica se é aceitavel apenas numeros e se caso sim o que foi digitado também
            super.insertString(offset, (upper ? str.toUpperCase() : str), attr);
        else if (!onlyNumber)
            super.insertString(offset, (upper ? str.toUpperCase() : str), attr);
      }
    }
    
    boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
              char ch = s.charAt(i);
              if (ch < 48 || ch > 57)
                   return false;
        }
        return true;
    }
}
