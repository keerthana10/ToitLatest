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
package com.openbravo.pos.reports;

import com.openbravo.pos.forms.AppView;
import java.awt.Component;
import java.util.Date;
import com.openbravo.beans.JCalendarDialog;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.SerializerWrite;
import com.openbravo.data.loader.SerializerWriteBasic;
import com.openbravo.mailsending.ReportAccessMail;
import static com.openbravo.pos.reports.JParamsMandtoryDates.DATE_FORMAT_NOW;
import com.openbravo.pos.sales.JRetailPanelTicket;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JParamsDatesAfterJune extends javax.swing.JPanel implements ReportEditorCreator {
  Logger logger = Logger.getLogger("MyLog");
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
     AppView m_app;

    /**
     * Creates new form JParamsClosedPos
     */
    public JParamsDatesAfterJune() {
        initComponents();
           logger.info("Accessing Sales Reports");
    }

    public void setStartDate(Date d) {
        jTxtStartDate.setText(Formats.TIMESTAMP.formatValue(d));
    }

    public void setEndDate(Date d) {

        jTxtEndDate.setText(Formats.TIMESTAMP.formatValue(d));
    }

    public void init(AppView app) {
       m_app=app;
     //    ReportAccessMail.sendMail(app,logger);
    }

    public void activate() throws BasicException {
        jTxtStartDate.setText("");
        jTxtEndDate.setText("");
    }

    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(new Datas[]{Datas.OBJECT, Datas.TIMESTAMP, Datas.OBJECT, Datas.TIMESTAMP});
    }

    public Component getComponent() {
        return this;
    }

    public Object createValue() throws BasicException {
        Object startdate = Formats.TIMESTAMP.parseValue(jTxtStartDate.getText());
        Object enddate = Formats.TIMESTAMP.parseValue(jTxtEndDate.getText());
        Date erpTaxDate = (Date) Formats.TIMESTAMP.parseValue("1 Jun, 2016 12:00:00 PM");;
       
       if ((jTxtStartDate.getText().equals("") || jTxtEndDate.getText().equals("")) ) { 
            showMessage(this, "Start date and End date are mandatory"); 
           return "";
        } else if (erpTaxDate.after((Date) startdate)&& !m_app.getProperties().getStoreName().equals("TPR") ) {
            showMessage(this, "Please Refer Older Report"); 
            return "";
        }else if (erpTaxDate.after((Date) enddate)&& !m_app.getProperties().getStoreName().equals("TPR") ) { 
            showMessage(this, "Please Refer Older Report"); 
            return "";
         } else {
            return new Object[]{
                startdate == null ? QBFCompareEnum.COMP_NONE : QBFCompareEnum.COMP_GREATEROREQUALS,
                startdate,
                enddate == null ? QBFCompareEnum.COMP_NONE : QBFCompareEnum.COMP_LESS,
                enddate,};
        }


    }

    private void showMessage(JParamsDatesAfterJune aThis, String msg) {
        JOptionPane.showMessageDialog(aThis, getLabelPanel(msg), "Message",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private JPanel getLabelPanel(String msg) {
        JPanel panel = new JPanel();
        Font font = new Font("Verdana", Font.BOLD, 12);
        panel.setFont(font);
        panel.setOpaque(true);
        // panel.setBackground(Color.BLUE);
        JLabel label = new JLabel(msg, JLabel.LEFT);
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel.add(label);

        return panel;
    }

    public String now() {
        return sdf.format(cal.getTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtStartDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtEndDate = new javax.swing.JTextField();
        btnDateStart = new javax.swing.JButton();
        btnDateEnd = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(AppLocal.getIntString("label.bydates"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(0, 100));
        setLayout(null);

        jLabel1.setText(AppLocal.getIntString("Label.StartDate")); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 20, 120, 18);
        add(jTxtStartDate);
        jTxtStartDate.setBounds(140, 20, 200, 28);

        jLabel2.setText(AppLocal.getIntString("Label.EndDate")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(20, 50, 120, 18);
        add(jTxtEndDate);
        jTxtEndDate.setBounds(140, 50, 200, 28);

        btnDateStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/date.png"))); // NOI18N
        btnDateStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateStartActionPerformed(evt);
            }
        });
        add(btnDateStart);
        btnDateStart.setBounds(350, 20, 28, 28);

        btnDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/date.png"))); // NOI18N
        btnDateEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateEndActionPerformed(evt);
            }
        });
        add(btnDateEnd);
        btnDateEnd.setBounds(350, 50, 28, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateStartActionPerformed

        Date date;
        try {
            date = (Date) Formats.TIMESTAMP.parseValue(jTxtStartDate.getText());
        } catch (BasicException e) {
            date = null;
        }
        date = JCalendarDialog.showCalendarTimeHours(this, date);
        if (date != null) {
            jTxtStartDate.setText(Formats.TIMESTAMP.formatValue(date));
        }
    }//GEN-LAST:event_btnDateStartActionPerformed

    private void btnDateEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateEndActionPerformed

        Date date;
        try {
            date = (Date) Formats.TIMESTAMP.parseValue(jTxtEndDate.getText());
        } catch (BasicException e) {
            date = null;
        }
        date = JCalendarDialog.showCalendarTimeHours(this, date);
        if (date != null) {
            jTxtEndDate.setText(Formats.TIMESTAMP.formatValue(date));
        }
    }//GEN-LAST:event_btnDateEndActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDateEnd;
    private javax.swing.JButton btnDateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTxtEndDate;
    private javax.swing.JTextField jTxtStartDate;
    // End of variables declaration//GEN-END:variables
}
