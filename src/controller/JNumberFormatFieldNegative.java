package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Campo para a inserção de números com base em um formato.
 *
 * @author Dyorgio da Silva Nascimento
 */

public class JNumberFormatFieldNegative extends JTextField{
    private static final long serialVersionUID = -7506506392528621022L;
    private static final NumberFormat MONETARY_FORMAT = new DecimalFormat("R$ #,##0.00");
    private NumberFormat numberFormat;
    private int limit = -1;

    public JNumberFormatFieldNegative(int casasDecimais) {
        this(new DecimalFormat((casasDecimais == 0 ? "#,##0" : "#,##0.") + makeZeros(casasDecimais)));
    }

    public JNumberFormatFieldNegative() {
        this(MONETARY_FORMAT);
    }

    public JNumberFormatFieldNegative(NumberFormat format) {// define o formato do
        // número
        numberFormat = format;// alinhamento horizontal para o texto
        setHorizontalAlignment(RIGHT);// documento responsável pela formatação
        // do campo
        setDocument(new PlainDocument() {
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                String first = (!JNumberFormatFieldNegative.this.getText().isEmpty()) ? String.valueOf(JNumberFormatFieldNegative.this.getText().charAt(0)) : "";
                String fStr = (!str.isEmpty()) ? String.valueOf(str.charAt(0)) : "";
                String text = new StringBuilder(JNumberFormatFieldNegative.this.getText().replaceAll("[^0-9]", "")).append(str.replaceAll("[^0-9]", "")).toString();

                super.remove(0, getLength());
                if (text.isEmpty()) {
                    text = "0";
                } else {
                    text = new BigInteger(text).toString();
                }

                BigDecimal n = new BigDecimal(getLimit() > 0 == text.length() > getLimit() ? text.substring(0, getLimit()) : text).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits())));

                if (str.equals("-") || first.equals("-") || fStr.equals("-")) {
                    n = n.multiply(new BigDecimal(-1));
                }

                super.insertString(0, numberFormat.format(n), a);
            }

            @Override
            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);
                if (len != getLength()) {
                    insertString(0, "", null);
                }
            }
        });// mantem o cursor no final
        // do campo
        addCaretListener(new CaretListener() {
            boolean update = false;

            @Override
            public void caretUpdate(CaretEvent e) {
                if (!update) {
                    update = true;
                    setCaretPosition(getText().length());
                    update = false;
                }
            }
        });// limpa o campo se
        // apertar DELETE
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    setText("");
                }
            }
        });// formato
        // inicial
        setText("0");
        setCaretPosition(getText().length());
    }

    /**
     * *
     * Define um valor BigDecimal ao campo**
     *
     * @param value
     */
    public void setValue(BigDecimal value) {
        super.setText(numberFormat.format(value));
    }

    /**
     * *
     * Recupera um valor BigDecimal do campo**
     *
     * @return
     */
    public final BigDecimal getValue() {
        String first = (!getText().isEmpty()) ? String.valueOf(getText().charAt(0)) : "0";

        BigDecimal valor = new BigDecimal(getText().replaceAll("[^0-9]", "")).divide(new BigDecimal(Math.pow(10, numberFormat.getMaximumFractionDigits())));
        if (first.equals("-")) {
            valor = valor.multiply(new BigDecimal(-1));
        }
        return valor;
    }

    /**
     * *
     * Recupera o formatador atual do campo**
     *
     * @return
     */
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }

    /**
     * *
     * Define o formatador do campo** @param numberFormat
     */
    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    /**
     * *
     * Preenche um StringBuilder com zeros** @param zeros*
     *
     * @return
     */
    private static final String makeZeros(int zeros) {
        if (zeros >= 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < zeros; i++) {
                builder.append('0');
            }
            return builder.toString();
        } else {
            throw new RuntimeException("Número de casas decimais inválida (" + zeros + ")");
        }
    }

    /**
     * *
     * Recupera o limite do campo.** @return
     */
    public int getLimit() {
        return limit;
    }

    /**
     * *
     * Define o limite do campo, limit < 0 para deixar livre (default) Ignora os
     * pontos e virgulas do formato, conta* somente com os números** @param
     * limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
