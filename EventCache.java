/**
 * Write a description of class EventCahce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class EventCache extends Cache implements Serializable
{
    private String nome;     //nome do evento
    private String descricao;      //descricao do evento
    private ArrayList<String> nomes; //lista dos participantes
    private GregorianCalendar data;  //dia do encontro
    
    /*
     * CONSTRUTORES
     */
    
    //Construtor vazio
    public EventCache(){
        this.nome = "";
        this.descricao = "";
        this.nomes = new ArrayList<>();
        this.data = new GregorianCalendar();
    }
    
    //Construtor parametrizado
    public EventCache(String n, String d, int ano, int mes, int dia){
        this.nome = n;
        this.descricao = d;
        this.nomes = new ArrayList<>();
        this.data = new GregorianCalendar(ano, mes, dia);
    }
    
    //Construtor de copia
    public EventCache(EventCache ev){
        this.nome = ev.getNome();
        this.descricao = ev.getDescricao();
        this.nomes = ev.getNomes();
        this.data = ev.getData();
    }
    
    /*
     * GETTERS
     */
        
    public String getNome()                 { return this.nome;}
    public String getDescricao()            { return this.descricao;}
    public ArrayList<String> getNomes()     { return this.nomes;}
    public GregorianCalendar getData()      { return this.data;}
    
    /*
     * SETTERS
     */
    
    public void setNome(String n)                   { this.nome = n;}
    public void setDescricao(String d)              { this.descricao = d;}
    public void setNomes(ArrayList<String> nom)     { this.nomes = nom;}
    public void setData(GregorianCalendar d)        { this.data = d;}
    

    
    public EventCache clone(){
        return new EventCache(this);
    }
}
