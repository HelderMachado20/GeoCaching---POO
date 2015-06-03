
/**
 * Write a description of class MicroCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MicroCache extends Cache implements Serializable
{
        public MicroCache(){
            super();
        }
    
        public MicroCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador){
            super(cod, data, descricao, cor, criador);
        }
        
        public MicroCache(MicroCache mc){
            super(mc);
        }
        
        public String toString(){
            StringBuilder s = new StringBuilder();         
            GregorianCalendar d = this.getData();
            
            s.append("Código: "+getCodigo()+"\n");
            s.append("Criador: "+getCriador()+"\n");
            s.append("Data criação: "+d.get(Calendar.YEAR)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.DAY_OF_MONTH)+"\n");     
            s.append("Descrição: "+getDescricao()+"\n");    
            s.append("Coordenadas: "+getCoordenadas().toString()+"\n");
            
            return s.toString();
        }
        
    public MicroCache clone(){
        return new MicroCache(this);
    }
}
