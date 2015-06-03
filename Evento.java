/**
 * Write a description of class Eventos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class Evento implements Serializable
{
    private String info;         //Informação/Descrição do evento
    private String nome;         //Nome do evento
    private int maxp;            //Máximo de participantes
    private ArrayList<Cache> caches;
    private HashMap<String,Integer> participantes;      
    private GregorianCalendar prazo_insc;
    private GregorianCalendar data;
    private String vencedor;
    
    /*
     * CONSTRUTORES
     */
    
    // Construtor vazio
    public Evento(){
        this.info = "";
        this.nome = "";
        this.maxp = 0;
        this.caches = new ArrayList<>();
        this.participantes = new HashMap<>();
        this.prazo_insc = new GregorianCalendar();
        this.data = new GregorianCalendar();
        this.vencedor = "";
    }
    
    //Construtor parametrizado
    public Evento(String inf, String n, int mx, int a1, int m1, int d1, int a2, int m2, int d2, String venc){
        this.info = inf;
        this.nome = n;
        this.maxp = mx;
        this.caches = new ArrayList<>();
        this.participantes = new HashMap<>();
        this.prazo_insc = new GregorianCalendar(a1, m1, d1);
        this.data = new GregorianCalendar(a2, m2, d2);
        this.vencedor = venc;
    }
    
    //Construtor de copia
    public Evento(Evento ev){
        this.info = ev.getInfo();
        this.nome = ev.getNome();
        this.maxp = ev.getMaxp();
        this.caches = ev.getCaches();
        this.participantes = ev.getParticipantes();
        this.prazo_insc = ev.getPrazo_insc();
        this.data = ev.getData();
        this.vencedor = ev.getVencedor();
    }
    
    /*
     * GETTERS
     */
    
    public String getInfo()                             { return this.info;}
    public String getNome()                             { return this.nome;}
    public int getMaxp()                                { return this.maxp;}
    public ArrayList<Cache> getCaches()                 { return this.caches;}
    public HashMap<String, Integer> getParticipantes()  { return this.participantes;}
    public GregorianCalendar getPrazo_insc()            { return this.prazo_insc;}
    public GregorianCalendar getData()                  { return this.data;}
    public String getVencedor()                         { return this.vencedor;}
    
    /*
     * SETTERS
     */
    
    public void setInfo(String inf)                                 { this.info = inf;}
    public void setNome(String n)                                   { this.nome = n;}
    public void setMaxp(int mx)                                     { this.maxp = mx;}
    public void setCaches(ArrayList<Cache> ca)                      { this.caches = ca;}
    public void setParticipantes(HashMap<String, Integer> pa)       { this.participantes = pa;}
    public void setPrazo_insc(GregorianCalendar d)                  { this.prazo_insc =d;}
    public void setData(GregorianCalendar d)                        { this.data = d;}
    public void setVencedor(String venc)                            { this.vencedor = venc;}
}