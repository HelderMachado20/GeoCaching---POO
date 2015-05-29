
/**
 * Classe para guardar dados relativos a uma coordenada (latitude ou longitude)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coord
{
    private int grau;
    private int min;
    private int seg;
    private char direcao;
    
    /*
     *  CONSTRUTORES 
     */
    
    //Construtor vazio
    public Coord(){
        this.grau = 0;
        this.min = 0;
        this.seg = 0;
        this.direcao = 'Z';
    }
    
    //Construtor parametrizado
    public Coord(int g, int m, int s, char d){
        this.grau = g;
        this.min = m;
        this.seg = s;
        this.direcao = d;
    }
    
    //Construtor de cópia
    public Coord(Coord c){
        this.grau = c.getGrau();
        this.min = c.getMin();
        this.seg = c.getSeg();
        this.direcao = c.getDir();
    }
    
    /*
     * GETTERS
     */
    public void setGrau(int g) { this.grau = g; }
    public void setMin(int m) { this.min = m; }
    public void setSeg(int s) { this.seg = s; }
    public void setDir(char d) { this.direcao = d; }
    
    /*
     * SETTERS
     */
    public int getGrau() { return this.grau; }
    public int getMin() { return this.min; }
    public int getSeg() { return this.seg; }
    public char getDir() { return this.direcao; }
    
    /*
     * MÉTODOS
     */
    
    public Coord clone(){
        return new Coord(this);
    }   
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append(grau).append("\u00B0");    // \u00B0 para escrever o símbolo dos graus
        s.append(min).append("'");
        s.append(seg).append("\"");
        s.append(direcao);
        
        return s.toString();
    }        
}
