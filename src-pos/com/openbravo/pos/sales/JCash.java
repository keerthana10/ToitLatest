/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.UUID;
import javax.swing.*;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.sales.restaurant.JRetailTicketsBagRestaurantMap;
import com.openbravo.pos.sales.PaymentInfo;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import com.openbravo.pos.sales.DataLogicReceipts;
import com.openbravo.pos.sales.PaymentInfo;
import java.util.ArrayList;

/**
 *
 * @author Keerthana
 */
public class JCash extends javax.swing.JDialog {
    public javax.swing.JDialog dEdior = null;
    private Properties dbp = new Properties();  
          public String[] strings = {""};
    public DefaultListModel model = null;   
    static JRetailTicketsBagRestaurantMap restaurantMap;       
    public JRetailPanelTicket JRetailPanelTicket;
  
    //Must code
    int x = 450;
    int y = 100;
    int width = 500;
    int height = 200;
    public static boolean isNewTable1;
    public static String splitTableId1;
    Logger logger = Logger.getLogger("MyLog");
    protected AppView m_App;
     public String role;
     public  String loginUserId;
     public String roleName;
     public javax.swing.table.TableModel cashtablemodel;
     public javax.swing.table.DefaultTableModel cashtabmodel;
      public javax.swing.table.JTableHeader cashheader;
      
    public String[ ][ ] datacell=new String[10][10];
    public int rows;
    public int cols;
     public String[ ] datastring=new String[100];
     private String modenam;
      public String modename;
     
       private java.util.List<PaymentInfo> paymInfo=null;
       protected PaymentInfo pinfo;
      // public DataLogicReceipts dlReceipts1;
         static DataLogicReceipts dlReceipts;
    //private PaymentInfo setpayment_mode;

    
     
     //Toit Latest   
   
//public jTableHeader jcashtable.tableHeader;
    /**
     * Creates new form JCash
     */
    
   
    /**
     * Creates new form JRetailBufferWindow
     */
       private void init(DataLogicReceipts dlReceipt) {
        initComponents();
        this.setResizable(false);       
        setVisible(true);
        
    }
       
    public JCash(java.awt.Frame frame, boolean modal) {
       //  System.out.println("11"); //- triggers this also
       super(frame, true);
        setBounds(x, y, width, height);
    }

     private JCash(Dialog dialog, boolean b) {
        //  System.out.println("12");
        super(dialog, true);
        setBounds(x, y, width, height);
    }
    
 
     public static void showMessage(Component parent,String cashloginid,DataLogicReceipts dlReceipt) {
          //System.out.println("13"+cashloginid);//-Triggers  here        
        Window window = getWindow(parent);
        JCash myMsg;
        dlReceipts=dlReceipt;
        if (window instanceof Frame) {
            myMsg = new JCash((Frame) window, true);
        } else {
            myMsg = new JCash((Dialog) window, true);
        }
       // System.out.println("13-1");
        myMsg.loadContent(cashloginid,dlReceipts);
        
    }
     
  
      public  void loadContent(String cashloginid,DataLogicReceipts dlReceipt) {
           // System.out.println("13-2");
          initComponents();
         System.out.println("13-3");  
        // dlReceipts=dlReceipt;
          String loginUserId=cashloginid;
          jcashtext.setText(loginUserId);           
          System.out.println("Cash Header color set");
          printDebugData(jcashtable,dlReceipts);
          setVisible(true);                     
          
      }
      
      
      private void printDebugData(JTable table,DataLogicReceipts dlReceipt) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        System.out.println("Rows:"+numRows+"Columns:"+numCols);
        javax.swing.table.TableModel model = table.getModel();
           dlReceipts=dlReceipt;
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
      
      //TPR Release
      private static Window getWindow(Component parent) {
          // System.out.println("14");
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
          
    }
     
       public String getModenam() {
        return modename;
    }

    public void setModenam(String modenam1) {
        this.modename = modenam1;
    }        
   
     
       
           

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        panel1 = new java.awt.Panel();
        UserA = new javax.swing.JLabel();
        jcashtext = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jcashtable = new javax.swing.JTable();
        button1 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        UserA.setBackground(new java.awt.Color(153, 153, 0));
        UserA.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        UserA.setText("User Name");

        jcashtext.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        jcashtable.setBackground(new java.awt.Color(153, 204, 0));
        jcashtable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jcashtable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcashtable.setForeground(new java.awt.Color(0, 0, 204));
        jcashtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cash", null, null, null, null},
                {"Card", null, null, null, null},
                {"Cheque", null, null, null, null},
                {"Voucher", null, null, null, null},
                {"Complementary", null, null, null, null},
                {"Mobile", null,  new Double(0.0), null, null}
            },
            new String [] {
                "Mode", "Opening Cash (A)", "Txn Cash (B)", "Closing Cash (C)", "Difference"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jcashtable.setToolTipText("");
        jcashtable.setGridColor(new java.awt.Color(0, 153, 0));
        jcashtable.setPreferredSize(new java.awt.Dimension(375, 200));
        jcashtable.setRowHeight(25);
        jcashtable.setSelectionBackground(new java.awt.Color(204, 0, 204));
        jcashtable.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jScrollPane5.setViewportView(jcashtable);
        jcashtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jcashtable.getColumnModel().getColumn(1).setMinWidth(100);
        jcashtable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jcashtable.getColumnModel().getColumn(1).setMaxWidth(100);

        button1.setBackground(new java.awt.Color(153, 0, 153));
        button1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(204, 204, 0));
        button1.setLabel("Calculate Difference");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 51));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(UserA, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcashtext, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 259, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserA, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jcashtext)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        UserA.getAccessibleContext().setAccessibleName("  User Name");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
         printDebugData(jcashtable,dlReceipts);
          jcashtable.setBorder(BorderFactory.createEmptyBorder(2, 3, 2, 3));
         jcashtable.setIntercellSpacing(new java.awt.Dimension(10, 10));
         jcashtable.getTableHeader().setBackground(Color.GRAY);          
           jcashtable.getTableHeader().setSize(20, 20);
           
         printCalculateDifferenceData(jcashtable,dlReceipts);
            
    }
    
   
    private void printCalculateDifferenceData(JTable table,DataLogicReceipts dlReceipt) {
        System.out.println("From Difference Calculation Function");
        double A,B,C,expr;
        String mod_nam;   
        dlReceipts=dlReceipt;
      paymInfo = new ArrayList<PaymentInfo>();   

        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        System.out.println("Rows:"+numRows+"Columns:"+numCols);
        javax.swing.table.TableModel model = table.getModel();
       
        table.getColumnModel().getColumn(4).setMinWidth(0);
         table.getColumnModel().getColumn(4).setMaxWidth(0);
            table.getColumnModel().getColumn(4).setWidth(0);
 
        System.out.println("Value of data: ");
        for (int i=0 ; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0 ; j < numCols ; j++) {                
                 System.out.print("    Column " + j + ":"+ model.getValueAt(i,j).toString());                 
                  setModenam(model.getValueAt(i,j).toString());             
                      modename=getModenam();
                       // pinfo.setPayment_mode(modename);            
             //        System.out.print("    mode  " + modename);
                        
                Object x=model.getValueAt(i, ++j);    
                A = new Double( x .toString());
                
               Object y = model.getValueAt(i, ++j);              
                B= new Double( y .toString());
                
                Object z=model.getValueAt(i, ++j);  
                C = new Double ( z.toString());
                
                try{
                 expr = A + B - C;
               //  pinfo.setTotal(expr);
                System.out.print("  " +modename+expr);
               //  paymInfo.add(pinfo);                          
                dlReceipts.insertShiftCollection(modename,expr);             
                                                     
               model.setValueAt(0000 , i , ++j);
                }catch (ArithmeticException ex) {
                       logger.info("exception in JCash" + ex.getMessage());
                      Logger.getLogger(JCash.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    
    public String[][] getTableData()
    {
        //String[][] data = new String[this.getRowCount()][this.getColumnCount()];
        String[][] data = new String[3][3];
       // for (int r = 0; r  <  getRowCount(); r++)
        for (int r = 0; r  <  6; r++)
        {
            //for (int c = 0; c  <  getColumnCount(); c++)
                 for (int c = 0; c  <  5; c++)
            {
                data[r][c] =(String)jcashtable.getValueAt(rows, cols);
                System.out.println("Cell value of 3 column and 3 row :" + data[r][c]);
                   //  data[r][c] = jcashtable.getValueforCell(r, c);
            }
        }
        return data;
    }
         public String getValueforCell(int row, int col)
    {
        return (String) jcashtable.getModel().getValueAt(row, col).toString();
    }

public String[] getTableData(String delim)
    {
        String[] data = new String[jcashtable.getRowCount()];

        int colCount = jcashtable.getColumnCount();
        int rowCount = jcashtable.getRowCount();

        //get the row data
        StringBuffer currRow = new StringBuffer();
        for (int row = 0; row  <  rowCount; row++)
        {
            for (int col = 0; col  <  colCount; col++)
            {
                currRow.append(jcashtable.getValueAt(row, col));
                currRow.append(delim);
            }
            data[row] = currRow.toString();
            currRow = new StringBuffer();
        }
        return data;
    }
     
    public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
  } 
        
  private void WindowClosingEvent(java.awt.event.WindowEvent evt) {                                    
        dispose();
  
  
  
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
            
  
  
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JCash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JCash dialog = new JCash(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
                                      
    
     
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserA;
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTable jcashtable;
    private javax.swing.JTextField jcashtext;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

 

}