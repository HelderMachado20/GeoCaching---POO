
/**
 * Write a description of class MultiCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MultiCache extends Cache implements Serializable
{    
    private String obj;      //descrição do objeto que se encontra na cache
    private ArrayList<Coordenadas> lista_coord;
    
    public MultiCache(){
        super();
        this.obj = "";
        this.lista_coord = new ArrayList<>();
    }
    
    public MultiCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador, String obj, ArrayList<Coordenadas> lista){
        super(cod, data, descricao, cor, criador);
        this.obj = obj;
        this.lista_coord = new ArrayList<Coordenadas>(lista);
    }
    
    public MultiCache(MultiCache mc){
        this.setCodigo(mc.getCodigo());
        this.setData(mc.getData());
        this.setDescricao(mc.getDescricao());
        this.setCriador(mc.getCriador());
        this.obj = mc.getObjeto();
        this.lista_coord = mc.getListaCoord();
    }
    
    /*
     * GETTERS
     */
    public String getObjeto()        { return this.obj;    }
    public ArrayList<Coordenadas> getListaCoord()    { return this.lista_coord;   }
    
    /*
     * SETTERS
     */
    public void setObjeto(String o) { this.obj = o;    }
    public void setListaCoord(ArrayList<Coordenadas> lista)  { this.lista_coord = new ArrayList<Coordenadas>(lista);  }
    
    
    public String toString(){
            StringBuilder s = new StringBuilder();         
            GregorianCalendar d = this.getData();
            
            s.append("Código: "+getCodigo()+"\n");
            s.append("Criador: "+getCriador()+"\n");
            s.append("Data: "+d.get(Calendar.YEAR)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.DAY_OF_MONTH)+"\n");    
            s.append("Descrição: "+getDescricao()+"\n");    
            s.append("Objecto/conteúdo: "+obj+"\n");
            s.append("Coordenadas a visitar para encontrar localização desta cache: \n");
            for( int i = 0 ; i < lista_coord.size(); i++){
                s.append((i+1)+" - "+lista_coord.get(i).toString()+"\n");
            }
            return s.toString();
        }
}
