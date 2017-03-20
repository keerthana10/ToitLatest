/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;

/**
 *
 * @author sysfore
 */
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.DataWrite;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.data.loader.SerializableWrite;

public class ServedTransactInfo implements SerializableRead, SerializableWrite{
    private static final long serialVersionUID = 7640633837719L;
    private String id;
        private String servedtransactBy;
      private String servedtransactTime;
      
public  ServedTransactInfo ()
{
    
}
 public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        servedtransactBy = dr.getString(2);
        servedtransactTime=dr.getString(3);
        
    }   
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, servedtransactBy);
        dp.setString(3, servedtransactTime);
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServedtransactBy() {
        return servedtransactBy;
    }

    public void setServedtransactBy(String servedtransactBy) {
        this.servedtransactBy = servedtransactBy;
    }

    public String getServedtransactTime() {
        return servedtransactTime;
    }

    public void setServedtransactTime(String servedtransactTime) {
        this.servedtransactTime = servedtransactTime;
    }

   

}