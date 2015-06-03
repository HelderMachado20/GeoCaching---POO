
/**
 * Write a description of class Utilizador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.Serializable;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Utilizador implements Serializable
{
    private String email;
    private String password;
    private String nome;
    private String genero;
    private String morada;
    private GregorianCalendar data_nasc;
    private GregorianCalendar data_reg;
    private TreeSet<String> amigos;  //lista de emails dos amigos
    private TreeSet<String> pedido_amizade;     //pedidos de amizade pendentes
    private HashMap<String,Atividade> atividades;    //lista de caches descobertas <código da atividade,atividade>
    private TreeSet<String> eventos;          //nome dos eventos em que participou, sem repetidos
    
    /*
     * CONSTRUTORES
     */
    
    //Construtor vazio
    public Utilizador(){
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.morada = "";
        this.data_nasc = new GregorianCalendar();
        this.data_reg = new GregorianCalendar();
        this.amigos = new TreeSet<>();
        this.pedido_amizade = new TreeSet<>();
        this.atividades = new HashMap<>();
        this.eventos = new TreeSet<>();
    }
    
    //Construtor parametrizado
    public Utilizador(String e, String p, String n, String g, String m, GregorianCalendar dn, GregorianCalendar dr){
        this.email = e;
        this.password = p;
        this.nome = n;
        this.genero = g;
        this.morada = m;
        this.data_nasc = dn;
        this.data_reg = dr;
        this.amigos = new TreeSet<>();
        this.pedido_amizade = new TreeSet<>();
        this.atividades = new HashMap<>();
        this.eventos = new TreeSet<>();
    }
    
     //Construtor de cópia
    public Utilizador(Utilizador ut){
        this.email = ut.getEmail();
        this.password = ut.getPassword();
        this.nome = ut.getNome();
        this.genero = ut.getGenero();
        this.morada = ut.getMorada();
        this.data_nasc = ut.getDataNasc();
        this.data_reg = ut.getDataReg();
        this.amigos = ut.getAmigos();
        this.pedido_amizade = ut.getPedidos();
        this.atividades = ut.getAtividades();
        this.eventos = ut.getEventos();
    }
    
    /*
     * GETTERS
     */
    
    public String getEmail()                      { return this.email;          }
    public String getPassword()                   { return this.password;       }
    public String getNome()                       { return this.nome;           }
    public String getGenero()                     { return this.genero;         }
    public String getMorada()                     { return this.morada;         }
    public GregorianCalendar getDataNasc()        { return this.data_nasc;      }
    public GregorianCalendar getDataReg()         { return this.data_reg;       }
    public TreeSet<String> getAmigos()            { return this.amigos;         }        //return da lista? uma devemos retornar uma cópia da lista?
    public TreeSet<String> getPedidos()           { return this.pedido_amizade; }
    public HashMap<String,Atividade> getAtividades()   { return this.atividades;     }
    public TreeSet<String> getEventos()         { return this.eventos;        }
    
    /*
     * SETTERS
     */
    
    public void setEmail(String e)                       { this.email = e;            }
    public void setPassword(String p)                    { this.password = p;         }
    public void setNome(String n)                        { this.nome = n;             }
    public void setGenero(String g)                      { this.genero = g;           }
    public void setMorada(String m)                      { this.morada = m;           }
    public void setDataNasc(GregorianCalendar d)         { this.data_nasc = d;        }
    public void setDataReg(GregorianCalendar d)          { this.data_reg = d;         }
    public void setAmigos(TreeSet<String> am)            { this.amigos = am;          }        
    public void setPedidos(TreeSet<String> ped)          { this.pedido_amizade = ped; }
    public void setAtividades(HashMap<String,Atividade> at){ this.atividades = at; }
    public void setEventos(TreeSet<String> ev)           { this.eventos = ev;         }
    
    
    
    /*
     * MÉTODOS
     */
    
    
    /**
     * Este método verifica se a String recebida é igual à password deste utilizador
     */
    public boolean validaLogin(String p){
        return (this.password.equals(p));        
    }
    
    /**
     * Método que recebe uma atividade e que a insere na hashtable ( com o código da atividade e a própria atividade )
     */
    public void insereAtiv(Atividade at) throws Excepcoes {
        if(this.atividades.containsKey(at.getNome())){
            throw new Excepcoes("Já existe uma atividade com este nome/código");            
        }        
        else{
            atividades.put(at.getNome(),at);
        }
    }
    
    /**
     * Dado o código de uma atividade este método verifica se esse mesmo código existe na lista de atividades e caso exista remove a atividade da hashtable
     */
    public void removeAtiv(String codigo) throws Excepcoes{
       if (!atividades.containsKey(codigo)){
           atividades.remove(codigo);
        }
       else{
           throw new Excepcoes("Código da atividade não existe");
        }
    }
    
    /**
     * Método que recebe um mail e adiciona esse user aos pedidos de amizade
     */
    public void inserePedido(String email) throws Excepcoes{
        if(amigos.contains(email)){
            throw new Excepcoes("Este email já se encontra na sua lista de amigos");
        }
        else if(this.email.equals(email)) {      //Caso já seja amigo ou seja o próprio email
            throw new Excepcoes("Não pode adicionar o seu próprio email");
        }
            else {
                pedido_amizade.add(email);      //Se ainda não for amigo insere na lista de pedidos
            }
    }
    
    /**
     * Método que recebe um mail e remove pedido de amizade
     */
    public void removePedido(String email) throws Excepcoes{        
        if(!pedido_amizade.contains(email)){
            throw new Excepcoes("Não existe nenhum email com este pedido");
        }
        else {
            pedido_amizade.remove(email);
        }
    }
    
    /**
     * Método que recebe um mail, verifica se está nos pedidos de amizade
     */
    public boolean pedidoExiste(String email){
        return pedido_amizade.contains(email);
    }
    
    
    public boolean amigoExiste(String email){
        return this.amigos.contains(email);
    }
    
    
    /**
     * Método que recebe um user e adiciona-o à lista de amigos caso ainda não exista nessa lista. Se adicionar retorna true, caso já exista retorna false
     */
    public void adicionaAmigo(String email) throws Excepcoes{
        
        if(amigos.contains(email)){
            throw new Excepcoes("Este email já se encontra na sua lista de amigos");
        }
        else if(!pedido_amizade.contains(email)){
            throw new Excepcoes("Não tem nenhum pedido de amizade com este email");
        }
        else{
            amigos.add(email);            
            pedido_amizade.remove(email);
        }
        
    }
  
        /**
     * Método que recebe um user e adiciona-o à lista de amigos caso ainda não exista nessa lista. Se adicionar retorna true, caso já exista retorna false
     */
    public void removeAmigo(String email) throws Excepcoes{
       
        if(!amigos.contains(email)){
            throw new Excepcoes("Este email não se encontra na sua lista de amigos");
        }
        else{
            amigos.remove(email);      
        }
        
    }
    
    /*public void ImprimeAtividades(){
        for(String c : atividades.keySet()){
            Atividade at = atividades.get(c);
            System.out.println(at.toString());
        }
    }*/
    
    public ArrayList<Atividade> ultimasDez(){
        ArrayList<Atividade> ultimas = new ArrayList<>(10);
        Atividade at;
        int i;
        for(String c : atividades.keySet()){
            
            at = atividades.get(c).clone();
            
            if(ultimas.size()==0){
                ultimas.add(at);
            }
            else{
                
                for(i=0 ; i<ultimas.size() ; i++){
                    if(   comparaData(  at.getData() , ultimas.get(i).getData()  ) == true   ) {
                        Atividade aux = ultimas.get(i).clone();
                        ultimas.set(i,at.clone());  //põe at na posição i;
                        at = aux; //
                    }
                }
                
                if(i<10){
                    ultimas.add(at);
                }
                
            }
        }
        
        return ultimas;
    }
    
     public ArrayList<Atividade> ordenaAtividades(){
        ArrayList<Atividade> listaAts = new ArrayList<>(atividades.size());
        Atividade at;
        int i;
        for(String c : atividades.keySet()){
            
            at = atividades.get(c).clone();
            
            if(listaAts.size()==0){
                listaAts.add(at);
            }
            else{
                
                for(i=0 ; i<listaAts.size() ; i++){
                    if(   comparaData(  at.getData() , listaAts.get(i).getData()  ) == true   ) {
                        Atividade aux = listaAts.get(i).clone();
                        listaAts.set(i,at.clone());  //põe at na posição i;
                        at = aux; //
                    }
                }
                
                if(i<10){
                    listaAts.add(at);
                }
                
            }
        }
        
        return listaAts;
    }
    
    public Utilizador clone(){
        return new Utilizador(this);
    }
    
    
    public ArrayList<ArrayList<Atividade>> statsMensais(int year) throws Excepcoes{
        if (atividades.size()==0) { throw new Excepcoes("Não tem nenhuma atividade registada"); }
        else {
            ArrayList<ArrayList<Atividade>> stats = new ArrayList<>(12);
            for(int i = 0 ; i<12 ; i++){                
                ArrayList<Atividade> l = new ArrayList<>();
                stats.add(l);
            }
            
            int ano, mes;
            Atividade at;
           
            for(String cod : atividades.keySet()){
                at = atividades.get(cod).clone();
                ano = at.getAno();
                mes = at.getMes();
                if(ano == year){ stats.get(mes).add(at); }
            }
        
            return stats;
        }
    }
    
     public HashMap<Integer,ArrayList<Atividade>> statsAnuais() throws Excepcoes{
         
        if (atividades.size()==0) { throw new Excepcoes("Não tem nenhuma atividade registada"); }
        else {
            HashMap<Integer,ArrayList<Atividade>> stats = new HashMap<>();
            
            int ano, mes;
            Atividade at;
            
                        
            for(String cod : atividades.keySet()){
                at = atividades.get(cod).clone();
                ano = at.getAno();
                mes = at.getMes();
                
                if( stats.get(ano) != null ){
                    stats.get(ano).add(at);
                }
                else {  
                    ArrayList<Atividade> a = new ArrayList<>();
                    stats.put(ano,a);
                    stats.get(ano).add(at);
                }            
            }
            return stats;
        }
        
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("DADOS DO UTILIZADOR "+nome+"\n_____________________________________\n");
        s.append("Nome: "+nome+"\n");
        s.append("Email: "+email+"\n");
        s.append("Género: "+genero+"\n");
        s.append("Morada: "+morada+"\n");
        s.append("Data Nascimento: "+data_nasc.get(Calendar.YEAR)+"/"+(data_nasc.get(Calendar.MONTH)+1)+"/"+data_nasc.get(Calendar.DAY_OF_MONTH)+"\n");
        s.append("Data Registo: "+data_reg.get(Calendar.YEAR)+"/"+(data_reg.get(Calendar.MONTH)+1)+"/"+data_reg.get(Calendar.DAY_OF_MONTH)+"\n");
        s.append("Lista de Amigos: ");
        for(String email : amigos){
            s.append(email+" - ");
        }
        s.append("\n");
        /*s.append("Lista caches descobertas: ");
        for(String cod : atividades.keySet()){
            s.append(cod+" - ");
        }
        s.append("\n");
        s.append("Lista de eventos em que participou: ");
        for(String cod : eventos){
            s.append(cod+" - ");
        }*/ 
        s.append("_____________________________________");
        return s.toString();
    }
    
    private boolean comparaData(GregorianCalendar d1, GregorianCalendar d2){ //verifica se d1 é mais recente que d2
        boolean res = false;
        int ano1 = d1.get(Calendar.YEAR), mes1 = d1.get(Calendar.MONTH), dia1 = d1.get(Calendar.DAY_OF_MONTH);        
        int ano2 = d2.get(Calendar.YEAR), mes2 = d2.get(Calendar.MONTH), dia2 = d2.get(Calendar.DAY_OF_MONTH);
        
        if(ano1 > ano2) { res = true; }
        else if(ano1 == ano2){
                    if(mes1 > mes2) { res = true; }            
                    else if(mes1 == mes2){
                        if(dia1 > dia2) { res = true; }                
            }            
        }
        
        
        return res;
    }
}
