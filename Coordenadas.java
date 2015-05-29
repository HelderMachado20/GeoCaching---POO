
/**
 * Write a description of class Coordenadas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.Serializable;

public class  Coordenadas implements Serializable
{
    private Coord latitude;
    private Coord longitude;
    
    /*
     * CONSTRUTORES
     */
    
    //Construtor vazio
    public Coordenadas(){
        this.latitude = null;
        this.longitude = null;
    }
    
    //Construtor parametrizado
    public Coordenadas(Coord lat, Coord lon){
        this.latitude = lat;
        this.longitude = lon;
    }
    
    //Construtor de cópia
    public Coordenadas(Coordenadas c){
        this.latitude = c.getLat();
        this.longitude = c.getLon();
    }
    
    /*
     * GETTERS
     */
    public Coord getLat() { return this.latitude; }
    public Coord getLon() { return this.longitude; }
    
    /*
     * SETTERS
     */
    public void setLat(Coord lat) { this.latitude = lat; }
    public void setLon(Coord lon) { this.longitude = lon;}
    
    /*
     * MÉTODOS
     */
    
    /**
     *  Método para validar latitude. Este método recebe os quatro argumentos da latitude e valida os mesmos retornando "true" para valores válidos e "false"
     *  para valores inválidos.
     *  Os argumentos são o grau, que tem se estar entre 0 e 90, os minutos e segundos, entre 0 e 60, e a direção que pode ser 'N' para norte e 'S' para sul.
     */
    public boolean validaLat(int g, int m, int s, char d){
        boolean res = true;
        d = Character.toUpperCase(d); //passa para maiúscula
        
        if(g < 0 || g > 90) { res = false; }
        if(m < 0 || m > 59 ) { res = false; }
        if(s < 0 || m > 59) { res = false; }  
        if( d != 'N' && d != 'S' ) { res = false; }
        
        return res;
    }
    
    
    /**
     *  Método para validar longitude. Este método recebe os quatro argumentos da longitude e valida os mesmos retornando "true" para valores válidos e "false"
     *  para valores inválidos.
     *  Os argumentos são o grau, que tem se estar entre 0 e 180, os minutos e segundos, entre 0 e 60, e a direção que pode ser 'E' para este e 'W' para oeste.
     */
    public boolean validaLon(int g, int m, int s, int d){
        boolean res = true;
        d = Character.toUpperCase(d); //passa para maiúscula
        
        if(g < 0 || g > 180) { res = false; }
        if(m < 0 || m > 59 ) { res = false; }
        if(s < 0 || m > 59) { res = false; }        
        if( d != 'E' && d != 'W' ) { res = false; }
        
        return res;
    }    
    
    
    public Coordenadas clone(){
        return new Coordenadas(this);
    }
    
    
    public String toString(){
        StringBuilder s = new StringBuilder();        
        String la = latitude.toString();
        String lo = longitude.toString();
        
        s.append("Latitude: ").append(la);
        s.append(" | ");
        s.append("Longitude: ").append(lo);
        
        return s.toString();
        
    }

}
