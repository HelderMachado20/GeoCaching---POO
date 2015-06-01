
/**
 * Write a description of class Atividade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Atividade implements Serializable
{
    private String nome;    //nome ou código desta atividade
    private String cod_cache;
    private String descricao; //descricao da atividade por parte do utilizador que a descobriu
    private Meteo meteo;   //meteorologia no decorrer desta atividade
    private String obj_retirado;
    private String obj_colocado; 
    private GregorianCalendar data;
    
    /*
     * CONSTRUTORES
     */
    public Atividade(){
        this.nome = "";
        this.cod_cache = "";
        this.descricao = "";
        this.meteo = null;
        this.obj_retirado = "";
        this.obj_colocado = "";
        this.data = new GregorianCalendar();
    }
    
    public Atividade(String no, String co, String d, Meteo met, String obr, String obc, GregorianCalendar data){
        this.nome = no;
        this.cod_cache = co;
        this.descricao = d;
        this.meteo = met;
        this. obj_retirado = obr;
        this. obj_colocado = obc;
        this.data = data;
    }
    
    public Atividade(Atividade at){
        this.nome = at.getNome();
        this.cod_cache = at.getCodCache();
        this.descricao = at.getDescricao();
        this.meteo = at.getMeteo();
        this. obj_retirado = at.getObjRet();
        this. obj_colocado = at.getObjCol();
        this.data = at.getData();
    }
    
    /*
     * GETTERS
     */
    public String getNome()         { return this.nome;         }
    public String getCodCache()     { return this.cod_cache;    }
    public String getDescricao()    { return this.descricao;    }
    public Meteo getMeteo()         { return this.meteo;        }
    public String getObjRet()       { return this.obj_retirado; }
    public String getObjCol()       { return this.obj_colocado; }
    public GregorianCalendar getData() { return this.data;      }
    
    /*
     * SETTERS
     */
    public void setNome(String no)          { this.nome = no;        }
    public void setCodCache(String cc)      { this.cod_cache = cc;   }
    public void setDescricao(String d)      { this.descricao = d;    }
    public void setMeteo(Meteo met)         { this.meteo = met;      }
    public void setObjRet(String or)        { this.obj_retirado = or;}
    public void setObjCol(String oc)        { this.obj_colocado = oc;}
    public void setData(GregorianCalendar data) { this.data = data;  }
    
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("Nome: "+nome+"\n");
        s.append("Código da cache descoberta: "+cod_cache+"\n");
        s.append("Meteorologia: "+meteo.toString()+"\n");
        s.append("Obj retirado: "+obj_retirado+"\n");
        s.append("Obj colocado: "+obj_colocado+"\n");       
        s.append("Data: "+data.get(Calendar.YEAR)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.DAY_OF_MONTH)+"\n");  

        return s.toString();
    }
    
    public String dataString(){        
        return (data.get(Calendar.YEAR)+"/"+(data.get(Calendar.MONTH)+1)+"/"+data.get(Calendar.DAY_OF_MONTH)+"\n");  
    }
    
    public Atividade clone(){
        return new Atividade(this);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
