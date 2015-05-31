
/**
 * Write a description of class Rede here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Rede implements Serializable
{
    private HashMap<String,Utilizador> users; //<email,utilizador>
    private HashMap<String,Cache> caches;       //<codigo da cache, cache>
    private ArrayList<Report> reports;     //lista de reports feitos a caches
    private Utilizador admin;
    
    public Rede(){
        this.users = new HashMap<String,Utilizador>();
        this.caches = new HashMap<String,Cache>();
        this.admin = new Utilizador("admin@geocachingpoo.pt","admin","admin","","",1990,0,1);
    }
    
    public Utilizador getAdmin()        { return this.admin; }
    public HashMap<String,Cache> getCaches() { return this.caches; }
    public HashMap<String,Utilizador> getUtilizadores() { return this.users; }
    
    public Utilizador getUtilizador(String email){
        return users.get(email);
    }
    
    public String getListaUsers(){
        StringBuilder s = new StringBuilder();
        Utilizador ut;
        s.append("*** Lista de utilizadores ***\n\n");
        s.append("        NOME        |       EMAIL        \n"); 
        s.append("-----------------------------------------\n");
        for(String email : users.keySet()){
            ut = users.get(email);
            s.append(ut.getNome());
            s.append(" - ");
            s.append(ut.getEmail());
            s.append("\n");
        }
        s.append("------------------------------------------\n");
        return s.toString();
    }
    
    public void insereNovo(String e, Utilizador ut) throws Excepcoes{
        if(ut == null){
            throw new Excepcoes("Erro ao criar novo utilizador! Tente outra vez.");
        }
        else{
            users.put(e,ut);
        }
    }
    
    public boolean validaMail(String email){
        if(!users.containsKey(email)){
            return true;
        }
        return false;
    }
    
    public boolean emailExiste(String mail){
        return users.containsKey(mail);
    }
    
    public Utilizador getUser(String email) throws Excepcoes{
        Utilizador u = users.get(email);
        if (u==null){
            throw new Excepcoes("Utilizador não existe");
        }
        else{
            return u;
        }
    }
    
    public void removeAmigo(String email_amigo, String email) throws Excepcoes {
        Utilizador amigo = users.get(email_amigo);
        Utilizador proprio = users.get(email);
        
        try{
            proprio.removeAmigo(email_amigo);
            amigo.removeAmigo(email); //remove tb no sentido inverso
        }
        catch( Excepcoes e ) {
            throw e;
        }
        
    }
    
    public void aceitaPedido(String email_amigo, String email) throws Excepcoes {
        Utilizador amigo = users.get(email_amigo);
        Utilizador proprio = users.get(email);
        
        try{
            proprio.adicionaAmigo(email_amigo);
            amigo.inserePedido(email); //adiciona pedido de amizade para poder adicionar amigo
            amigo.adicionaAmigo(email);
        }
        catch( Excepcoes e ) {
            throw e;
        }
        
    }
    
    public void removePedido(String email_amigo, String email) throws Excepcoes {
        
        Utilizador proprio = users.get(email);
        
        try{
            proprio.removePedido(email_amigo);
        }
        catch( Excepcoes e ){
             throw e;
        }
        
    }
    
     public int enviarPedido(String email_amigo, String email) throws Excepcoes{
        Utilizador amigo = users.get(email_amigo);
        Utilizador proprio = users.get(email);
        
        if(!emailExiste(email_amigo)){ return 1; }   //verifica se o email existe na rede
        
        if(proprio.pedidoExiste(email_amigo)){ return 2; } //verifica se o utilizador a quem se quer enviar pedido já enviou pedido antes
        
        if(proprio.amigoExiste(email)) { return 3; } //verifica se o utilizador a enviar pedido já está na lista de amigos
                
        try{
            amigo.inserePedido(email);
        }
        catch( Excepcoes e ){
            throw e;
        }
        
        return 0;
    }
    
    public boolean existeAmigo(String email_amigo, String email){
        Utilizador ut = users.get(email);
        return ut.amigoExiste(email_amigo);
    }
    
    public void criaMicroCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador) throws Excepcoes{
        MicroCache mc = new MicroCache(cod, data, descricao, cor, criador);
        if(mc!=null) { 
            caches.put(cod,mc); 
        }
        else {
            throw new Excepcoes("Erro ao adicionar cache! Por favor tente mais tarde.\n");
        }
    }
    
    public void criaMisteryCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador, String obj, String tipo, String charada) throws Excepcoes {
        MisteryCache mc = new MisteryCache(cod, data, descricao, cor, criador, obj, tipo, charada);
        if(mc!=null) { 
            caches.put(cod,mc); 
        }
        else {
            throw new Excepcoes("Erro ao adicionar cache! Por favor tente mais tarde.\n");
        }
    }
    
    public void criaMultiCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador, String obj, ArrayList<Coordenadas> lista) throws Excepcoes {
        MultiCache mc = new MultiCache(cod, data, descricao, cor, criador, obj, lista);
        if(mc!=null) { 
            caches.put(cod,mc); 
        }
        else {
            throw new Excepcoes("Erro ao adicionar cache! Por favor tente mais tarde.\n");
        }
    }
    
    public void criaVirtualCache(String cod, GregorianCalendar data, String descricao, Coordenadas cor, String criador) throws Excepcoes {
        VirtualCache mc = new VirtualCache(cod, data, descricao, cor, criador);
        if(mc!=null) { 
            caches.put(cod,mc); 
        }
        else {
            throw new Excepcoes("Erro ao adicionar cache! Por favor tente mais tarde.\n");
        }
    }
    
    public boolean cacheExiste(String c){
        return caches.containsKey(c);
    }
    
    public Cache getCache(String cod){
       return caches.get(cod);
    }
    
    
    public ArrayList<Atividade> getDezAtividades(String email){
        Utilizador ut = users.get(email);
        return ut.ultimasDez();
    }
    
    
    public void insereAtividade(String email, String nome, String cod, String desc, Meteo met, String obr, String obc, GregorianCalendar data) throws Excepcoes{
        Atividade at = new Atividade(nome, cod, desc, met, obr, obc, data);
        Utilizador ut = users.get(email);
        try{
            ut.insereAtiv(at);
        }
        catch( Excepcoes e ){
           throw e; 
        }
    }
    
    public void insereReport(String email, String cod, String motivo)   {
        Report rep = new Report(email, motivo, cod);
        this.reports.add(rep);     
        
    }
    
    public ArrayList<Report> getReports(){ return this.reports; }
    
    public void setReports(ArrayList<Report> rep) { this.reports = new ArrayList<>(rep); }
    
    public void removeCache(String email, String cod) throws Excepcoes{
        Cache ca = caches.get(cod);
        
        if(ca==null){ throw new Excepcoes("Cache não existe"); }
       
        if(!ca.getCriador().equals(email) && !email.equals("admin@geocachingpoo.pt")) { //Se não for o criador da cache nem o admin
            throw new Excepcoes("Não tem permissão para remover esta cache!");
        }
           
        caches.remove(cod);        
    }
    
    public ArrayList<Atividade> getAtividades(String email){
        Utilizador ut = users.get(email);
        return ut.ordenaAtividades();
    }
    
}
