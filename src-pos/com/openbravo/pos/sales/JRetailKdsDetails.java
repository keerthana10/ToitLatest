/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.inventory.RoleUserInfo;
import com.openbravo.pos.ticket.RetailTicketInfo;
import com.openbravo.pos.ticket.RetailTicketLineInfo;
import com.openbravo.util.date.DateFormats;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shilpa
 */
public class JRetailKdsDetails extends JDialog {
    
    int x = 500;
    int y = 300;
    int width = 350;
    int height = 250;
    static RetailTicketLineInfo lineInfo = null;
    DefaultTableModel totalTableModel;
    DefaultTableModel itemsTableModel;
    List productTypeList=new ArrayList();
   static DataLogicReceipts dlReceipts;
   static ServedTransactInfo slist=null;
    static Map<String,String> userMap;
  
    
    private void init(DataLogicReceipts dlReceipts) {
        initComponents();
        this.setResizable(false);
         setDataToItemsTable(jItemsTable);
        setVisible(true);
        
    }

    /**
     * Creates new form JRetailLucidDialogue
     */
    public JRetailKdsDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setBounds(x, y, width, height);
    }
    
    private JRetailKdsDetails(Dialog dialog, boolean b) {
        super(dialog, true);
        setBounds(x, y, width, height);
        
    }
    
    public static void showItemsScreen(Component parent, RetailTicketLineInfo Info, DataLogicReceipts dlReceipt,Map map) {
        
            lineInfo = Info;
            userMap=map;
             Window window = getWindow(parent);
             dlReceipts=dlReceipt;
             JRetailKdsDetails myMsg;
             
             
             if (window instanceof Frame) {
                 myMsg = new JRetailKdsDetails((Frame) window, true);
             } else {
                 myMsg = new JRetailKdsDetails((Dialog) window, true);
             }
             myMsg.init(dlReceipts);
        
    }
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    

    private void setDataToItemsTable(JTable table) {
        itemsTableModel = (DefaultTableModel) jItemsTable.getModel();
        jItemsTable.getTableHeader().setBackground(Color.YELLOW);
        jItemsTable.getTableHeader().setPreferredSize(new Dimension(20, 25));
        //jItemsTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        jItemsTable.setRowHeight(40);
        String orderTime="";
        String servedTime="";
        orderTime=DateFormats.DateToString(lineInfo.getKotdate());
        if(lineInfo.getServedTime()!=null){
        servedTime=DateFormats.DateToString(lineInfo.getServedTime());
        }
        
         //NewKDS Mar20,2017
                        System.out.println("New KDS March 20,2017");                 
                                        
                         System.out.println(lineInfo.getTbl_orderId());
                   //  java.util.List<ServedTransactInfo> slist=dlReceipts.getServedTransactTicketList(m_oTicket.getLine(i).getTbl_orderId());
                               java.util.List<ServedTransactInfo> slist;
        try {
            slist= dlReceipts.getServedTransactTicketList(lineInfo.getTbl_orderId());
            for(ServedTransactInfo rline:slist)
                              {
                                   //System.out.println(rline.getId());
                                        System.out.println(rline.getServedtransactBy());
                                        String servedUserName=dlReceipts.getUserName(rline.getServedtransactBy());
                                         System.out.println(servedUserName);
                                           String servedtransTime= rline.getServedtransactTime();
                                           itemsTableModel.addRow(new Object[]{orderTime,userMap.get(lineInfo.getKotuser()),servedtransTime,servedUserName}); 
                              }
        } catch (BasicException ex) {
            Logger.getLogger(JRetailKdsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
                              
             
           //old code
      // itemsTableModel.addRow(new Object[]{orderTime,userMap.get(lineInfo.getKotuser()),servedTime,userMap.get(lineInfo.getServedBy())}); 
        //Ne KDS Mar 20,2017
 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDetailedPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jItemsTable = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                WindowClosingEvent(evt);
            }
        });

        jDetailedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jItemsTable.setBackground(new java.awt.Color(83, 223, 99));
        jItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Time", "Ordered By", "Served Time", "Served By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jItemsTable);
        jItemsTable.getColumnModel().getColumn(0).setMinWidth(40);
        jItemsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        jItemsTable.getColumnModel().getColumn(1).setResizable(false);
        jItemsTable.getColumnModel().getColumn(2).setResizable(false);
        jItemsTable.getColumnModel().getColumn(3).setResizable(false);

        jDetailedPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        getContentPane().add(jDetailedPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WindowClosingEvent(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosingEvent
        dispose();
    }//GEN-LAST:event_WindowClosingEvent
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDetailedPanel;
    private javax.swing.JTable jItemsTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 

   

  

  


    
   

    
    

}
