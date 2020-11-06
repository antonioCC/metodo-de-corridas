
package tema2_simulacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author amton
 */
public class procesoMedia {
    public static double media(double []arreglo,int op){
        int x;
        boolean var=false,var2=false;
        double cont=0,MC0,vari,Z,limite;
        limite=media.cantidad();
        
        for(x=0;x<limite;x++){
            if(x>0){
                if(arreglo[x]<=arreglo[x-1]){
                    var=true;
                }
                else{
                    var=false;
                }  
            }
            
            if(x>1){
                if(var2!=var){  
                    cont++;
                }
            }
            var2=var;
        }
        
        //mui de las corridad
        MC0=(((2*limite)-1)/3);//7.66
        vari=((16*limite)-29)/90;//1.81
        Z=Math.abs((cont-MC0)/Math.sqrt(vari));
        
        JOptionPane.showMessageDialog(null,"el numero de corridas es: "+cont+"\n"+"mui de C0: "+MC0+"\n"+"la varianza es: "+vari+"\n"+
                "el estadistico Z es: "+Z);
        
        
        
        //limites
        switch(op){
            case 99:
                if(Z<2.57){
                JOptionPane.showMessageDialog(null,"se acepta la hipotesis de independencia");
                }else
                JOptionPane.showMessageDialog(null,"se rechaza la hipotesis de independencia");
                break;
            case 95:
                if(Z<1.96){
                JOptionPane.showMessageDialog(null,"se acepta la hipotesis de independencia");
                }else
                JOptionPane.showMessageDialog(null,"se rechaza la hipotesis de independencia");
                break;
            case 90:
                if(Z<1.64){
                JOptionPane.showMessageDialog(null,"se acepta la hipotesis de independencia");
                }else
                JOptionPane.showMessageDialog(null,"se rechaza la hipotesis de independencia");
                break;
            default:
                JOptionPane.showMessageDialog(null,"ingresa el porcentaje de confianza");     
        }
        

        return cont;
    }
    
}


