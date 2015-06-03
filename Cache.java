
/**
 * Write a description of class Cache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;

public abstract class Cache implements Serializable
{
    private String codigo;                // Nome/codigo identificador da cache
    private GregorianCalendar data;
    private String descricao_extra;      //descrição extra com informação que o utilizador-criador considere util sobre a cache
    private Coordenadas coord;
    private String criador; //email do criador
    
    /*
     * CONSTRUTORES
     */
    //Construtor vazio
    public Cache(){
        this.codigo = "default";
        this.data = new GregorianCalendar();
        this.descricao_extra = "";
        this.coord = new Coordenadas();
        this.criador = "";
    }
    
    //Construtor parametrizado
    public Cache(String codigo, GregorianCalendar data, String descricao_extra, Coordenadas coord, String criador){
        this.codigo = codigo;
        this.data = data;
        this.descricao_extra = descricao_extra;
        this.coord = coord;
        this.criador = criador;
    }
    
    //Construtor de cópia
    public Cache(Cache c){
        this.codigo = c.getCodigo();
        this.data = c.getData();
        this.descricao_extra = c.getDescricao();
        this.coord = c.getCoordenadas();
        this.criador = c.getCriador();
    }
    
    
    /*
     * GETTERS
     */
    public String getCodigo()          { return this.codigo;          }
    public GregorianCalendar getData() { return this.data;            }
    public String getDescricao()       { return this.descricao_extra; }
    public Coordenadas getCoordenadas(){ return this.coord;           }
    public String getCriador()         { return this.criador;         }
    public int getAno()                { return this.data.get(Calendar.YEAR); }
    public int getMes()                { return this.data.get(Calendar.MONTH); }
    /*
     * SETTERS
     */
    public void setCodigo(String cod)           { this.codigo = cod;           }
    public void setData(GregorianCalendar data) { this.data = data;            }
    public void setDescricao(String desc)       { this.descricao_extra = desc; }
    public void setCoordenadas(Coordenadas c)   { this.coord = c;              }
    public void setCriador(String criador)      { this.criador = criador;      }
    
}
