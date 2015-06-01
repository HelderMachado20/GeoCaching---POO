
/**
 * Write a description of class VirtualCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class VirtualCache extends Cache implements Serializable
{    
        public VirtualCache(){
            super();
        }
        
        public VirtualCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador){
                super(cod, data, descricao, cor, criador);
            }
        
        public VirtualCache(VirtualCache mc){
            super(mc);
        }
            
        public String toString(){
            StringBuilder s = new StringBuilder();         
            GregorianCalendar d = this.getData();
            
            s.append("Código: "+getCodigo()+"\n");
            s.append("Criador: "+getCriador()+"\n");
            s.append("Data: "+d.get(Calendar.YEAR)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.DAY_OF_MONTH)+"\n");  
            s.append("Descrição: "+getDescricao()+"\n");    
            s.append("Coordenadas: "+getCoordenadas().toString()+"\n");
            
            return s.toString();
        }
}

