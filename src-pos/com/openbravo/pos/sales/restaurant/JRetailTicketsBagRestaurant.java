//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.sales.restaurant;

import com.openbravo.basic.BasicException;
import javax.swing.*;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.sales.DataLogicReceipts;
import com.openbravo.pos.sales.JTableCover;
import com.openbravo.pos.sales.JRetailPanelTicket;
import com.openbravo.pos.ticket.RetailTicketInfo;
import com.openbravo.pos.ticket.RetailTicketLineInfo;
import com.sysfore.pos.panels.PosActionsInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JRetailTicketsBagRestaurant extends javax.swing.JPanel {
    
    private AppView m_App;
    private static JRetailTicketsBagRestaurantMap m_restaurant;
       
    private DataLogicReceipts dlReceipts;
      private java.util.ArrayList<PosActionsInfo> posActions;
     private DataLogicSales dlSales;

    Logger logger = Logger.getLogger("MyLog");  
         
    /** Creates new form JTicketsBagRestaurantMap */
    public JRetailTicketsBagRestaurant(AppView app, JRetailTicketsBagRestaurantMap restaurant) {
        
        m_App = app;
        m_restaurant = restaurant;

        
        initComponents();
         
    }

    public void activate(DataLogicReceipts dlReceipts) {
        
        // Authorization
         this.dlReceipts = dlReceipts;
      //m_jDelTicket.setVisible(m_App.getAppUserView().getUser().hasPermission("com.openbravo.pos.sales.JPanelTicketEdits"));
      m_jBtnCover.setVisible(false);
      m_jTxtTable.setVisible(false);
      m_jDelTicket.setVisible(false);
      dlSales = (DataLogicSales) m_App.getBean("com.openbravo.pos.forms.DataLogicSales");
      enablePosButtons();
    }
    public void setTableName(String tableId,String splitId) {
          m_jTxtTable.setText("TABLE: " + m_restaurant.getTable());
        int noOfCovers = 0;
        try {
            noOfCovers = dlReceipts.getTableCovers(tableId,splitId);
        } catch (Exception ex) {
            noOfCovers = 0;
            //Logger.getLogger(JTableCover.class.getName()).log(Level.SEVERE, null, ex);
        }
        m_restaurant.setNoOfCovers(noOfCovers);
  m_jBtnCover.setText("Covers("+m_restaurant.getNoOfCovers()+")");
    }
    public static void setFocusable(){
            m_jTxtTable.setFocusable(false);
            m_jDelTicket.setFocusable(false);
            jButton1.setFocusable(false);
            m_jBtnMoveTable.setFocusable(false);
            m_jBtnCover.setFocusable(false);
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jBtnCover = new javax.swing.JButton();
        m_jBtnMoveTable = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        m_jTxtTable = new javax.swing.JLabel();
        m_jDelTicket = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 232, 231));

        m_jBtnCover.setFocusPainted(false);
        m_jBtnCover.setFocusable(false);
        m_jBtnCover.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jBtnCover.setPreferredSize(new java.awt.Dimension(90, 40));
        m_jBtnCover.setRequestFocusEnabled(false);
        m_jBtnCover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnCoverActionPerformed(evt);
            }
        });

        m_jBtnMoveTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/1move-table.png"))); // NOI18N
        m_jBtnMoveTable.setFocusPainted(false);
        m_jBtnMoveTable.setFocusable(false);
        m_jBtnMoveTable.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jBtnMoveTable.setPreferredSize(new java.awt.Dimension(90, 40));
        m_jBtnMoveTable.setRequestFocusEnabled(false);
        m_jBtnMoveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnMoveTableActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/1table.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jButton1.setPreferredSize(new java.awt.Dimension(90, 40));
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        m_jDelTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/1Cancel.png"))); // NOI18N
        m_jDelTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jDelTicketActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(5, 5, 5)
                .add(m_jBtnCover, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(5, 5, 5)
                .add(m_jBtnMoveTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(5, 5, 5)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(9, 9, 9)
                .add(m_jTxtTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 135, Short.MAX_VALUE)
                .add(m_jDelTicket, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(5, 5, 5)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(m_jDelTicket, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(m_jBtnCover, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(m_jBtnMoveTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(m_jTxtTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void m_jBtnMoveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnMoveTableActionPerformed
       logger.info("Start Move-Table Button :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));    
        m_restaurant.moveTicket();
      // m_restaurant.loadTickets();  calling the same in map table and also starting timer
        logger.info("End Move-Table Button :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));    
    }//GEN-LAST:event_m_jBtnMoveTableActionPerformed

   public static void clickCancel(){
        m_jDelTicket.doClick();
    }
    private void m_jBtnCoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnCoverActionPerformed

           m_restaurant.updateCovers();
           setTableName(m_restaurant.getTableId(),m_restaurant.getSplitId());
        
    }//GEN-LAST:event_m_jBtnCoverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      logger.info("Start Table Button :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));
      
        m_restaurant.newTicket();
       m_restaurant.loadTickets();
       m_restaurant.startTimer(); 
       logger.info("End Table Button :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));    
    }//GEN-LAST:event_jButton1ActionPerformed
  public static void setNewTicket(){
     m_restaurant.newTicket();
   //  m_restaurant.loadTickets(); not required as we r exiting the table layout too
}
public static void setNewSplitTicket(RetailTicketInfo ticket1,RetailTicketInfo ticket2){
     m_restaurant.newsplitTicket(ticket1,ticket2);
     m_restaurant.loadTickets();
     m_restaurant.startTimer();
}

public static void stopReloadTimer(){
     m_restaurant.stopTimer();
 }
    private void m_jDelTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jDelTicketActionPerformed
      logger.info("Start cancel Button :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));    
        int res = JOptionPane.showConfirmDialog(this, AppLocal.getIntString("message.wannadeletereceipt"), AppLocal.getIntString("title.editor"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
             logger.info("allowing to cancel the bill");
            m_restaurant.deleteCancelTicket();
        }
           
           
    }//GEN-LAST:event_m_jDelTicketActionPerformed
      public void enablePosButtons(){

       try {
            posActions =  (ArrayList<PosActionsInfo>) dlSales.getPosActions(m_App.getAppUserView().getUser().getRole());
        } catch (BasicException ex) {
            Logger.getLogger(JRetailTicketsBagRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(posActions.size()!=0){
             if(posActions.get(0).getMoveTableAccess().equals("Y")){
                 m_jBtnMoveTable.setVisible(true);
             }else{
                 m_jBtnMoveTable.setVisible(false);
             }
         }else{
            m_jBtnMoveTable.setVisible(false);
         }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton m_jBtnCover;
    private static javax.swing.JButton m_jBtnMoveTable;
    private static javax.swing.JButton m_jDelTicket;
    private static javax.swing.JLabel m_jTxtTable;
    // End of variables declaration//GEN-END:variables
    
}

