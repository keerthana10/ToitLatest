/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.DataWrite;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.data.loader.SerializableWrite;
import java.io.Serializable;
import com.openbravo.pos.sales.DataLogicReceipts;

/**
 *
 * @author sysfore
 */
public class PaymentInfo implements SerializableRead, SerializableWrite ,Serializable{
    private static final long serialVersionUID = 7640633837719L;
    private String id;
    private String payment_mode;
    private double total;

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   

    
   
    public void readValues(DataRead dr) throws BasicException {
   id =dr.getString(1);
 payment_mode=dr.getString(2);
 

    total=dr.getDouble(4);
    

    
    }
    public PaymentInfo()
    {
        payment_mode="Cash";
        total=0;
    }
    public PaymentInfo copyTicket() {
          System.out.println("copyPayment");
        PaymentInfo t = new PaymentInfo();
        t.payment_mode=payment_mode;
        t.total=total;
        return t;
    }

    public PaymentInfo(String payment_mode,double total)
    {
        this.payment_mode=payment_mode;
        this.total=total;
    }
    
    public void writeValues(DataWrite dp) throws BasicException {
dp.setString(1,id);      
dp.setString(2,payment_mode);      
      
dp.setDouble(4,total);     


    }

  
    
}
