package transport.client;
import javax.swing.JComboBox;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
/**
 * <p>Title: Festival Logistics System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class afslComboBox extends JComboBox{
    private Border originalBorder = null;

    transient int m_iSel = -1;
    transient String currSearch = "";
    private long lastTimeStamp;
    private long currentTimeStamp;
    private long diff;

    private Vector m_list = new Vector();

    public afslComboBox() {
        this("");
        lastTimeStamp = System.currentTimeMillis();
        try {
          jbInit();
        }
        catch(Exception e) {
          e.printStackTrace();
        }
    }


    public afslComboBox(String name) {
        this(name, true);
    }

    public afslComboBox(String name, boolean dynamicBorder) {
        this.setName(name);
    }

    public afslComboBox(String name, String[] init){
        this.setName(name);
        this.fillCombo(init);
    }

    public void reset(){
        try {
            setSelectedIndex(0);
        } catch (Exception ex) {
        }
        m_iSel = -1;
    }


    public void keyPressed(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
    }



    public void fillCombo(String[] strings) {
        this.removeAllItems();
        for (int i = 0; i < strings.length; i++) {
            this.addItem(makeObj(strings[i]));
        }
    }

    public void fillCombo(Object[] objects) {
        this.removeAllItems();
        for (int i = 0; i < objects.length; i++) {
            this.addItem(objects[i]);
        }
    }

    public void fillCombo(Object[] objects, Object def) {
        this.removeAllItems();
        this.addItem(def);
        for (int i = 0; i < objects.length; i++) {
            this.addItem(objects[i]);
        }
    }

    private Object makeObj(final String item) {
        return new Object() {
            public String toString() {
                return item;
            }
        }
        ;
    }

    /**
    Get index of the string that has specified substring.
    <br>It is similar to "find(part, start, false)".
    @param part a substring to search.
    @param start start index (from the start to the end of the list).
    @return The index of the first string that contains the
    substring or -1 if the string is not found.
    @see #findStringExact
    @see #getCount
    */
    public int findString(String part, int start){ return find(part, start, false); }
    /**
    Get index of the string that has specified substring.
    @param part a substring to search.
    @param start start index (from the start to the end of the list).
    @param zero True: string should start with the "part".
    @return The index of the first string that contains the
    substring or -1 if the string is not found.
    @see #findString
    */
    public int find(String part, int start, boolean zero)
    {
            if(start-- >= getCount()) return -1;
            if(start < 0) start = -1;
            int iLen = part.length();
            if(iLen < 1) return -1;
            while(++start < getCount())
            {
                    if(zero)
                    {
                            if(((String)m_list.elementAt(start)).regionMatches(true, 0, part, 0, iLen))
                                    return start;
                    }
                    else if(((String)m_list.elementAt(start)).indexOf(part) >= 0)
                            return start;
            }
            return -1;
    }
    /**
    Get number of strings in the list.
    @return The size of the list.
    @see #addString
    */
    public int getCount(){ return m_list.size(); }


    private void jbInit() throws Exception {
      this.setMinimumSize(new Dimension(26, 18));
      this.setPreferredSize(new Dimension(20, 21));
    }
}
