
/**
 * Write a description of class MisteryCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MisteryCache extends Cache implements Serializable
{
    private String obj;              //descrição do objeto que se encontra na cache
    private String tipo;               //Puzzle, Challenge....
    private String charada;
    
    public MisteryCache(){
        super();
        this.obj = "";
        this.tipo = "";
        this.charada = "";
    }
    
    public MisteryCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador, String obj, String tipo, String charada){
        super(cod, data, descricao, cor, criador);
        this.obj = obj;
        this.tipo = tipo;
        this.charada = charada;
    }
    
    public MisteryCache(MisteryCache mc){
        this.setCodigo(mc.getCodigo());
        this.setData(mc.getData());
        this.setDescricao(mc.getDescricao());
        this.setCoordenadas(mc.getCoordenadas());
        this.setCriador(mc.getCriador());
        this.obj = mc.getObjeto();
        this.tipo = mc.getTipo();
        this.charada = mc.getCharada();
    }
    
    /*
     * GETTERS
     */
    public String getObjeto()  { return this.obj;    }
    public String getTipo()    { return this.tipo;   }
    public String getCharada() { return this.charada;}
    
    /*
     * SETTERS
     */
    public void setObjeto(String o) { this.obj = o;    }
    public void setTipo(String tp)  { this.tipo = tp;  }
    public void setCharada(String c){ this.charada = c;}
    
    
    public String toString(){
            StringBuilder s = new StringBuilder();         
            GregorianCalendar d = this.getData();
            
            s.append("Código: "+getCodigo()+"\n");
            s.append("Criador: "+getCriador()+"\n");
            s.append("Data: "+d.get(Calendar.YEAR)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.DAY_OF_MONTH)+"\n"); 
            s.append("Descrição: "+getDescricao()+"\n");    
            s.append("Objecto/conteúdo: "+obj+"\n");
            s.append("Tipo de charada: "+tipo+"\n");
            s.append("Charada: "+charada+"\n");
            s.append("Coordenadas: "+getCoordenadas().toString()+"\n");
            
            return s.toString();
        }
}
