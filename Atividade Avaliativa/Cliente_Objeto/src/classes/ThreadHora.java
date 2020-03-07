/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Madianita
 */
public class ThreadHora extends Thread
{
        javax.swing.JLabel lbHora;
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        
        public ThreadHora(javax.swing.JLabel lbHora)
        {
            this.lbHora = lbHora;
        }

        @Override
       public void run() {

           for(;;){
               lbHora.setText(formatoHora.format(new Date()));
               try{
                   Thread.sleep(1000);                    
               }
               catch (InterruptedException ex){
                   System.out.println("thread ainda n chegou ao fim"+ex);
               }

           }

       }
}

