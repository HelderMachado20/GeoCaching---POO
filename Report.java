
/**
 * Write a description of class Reports here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Report
{
    String email_user;
    String motivo;
    String cod_cache;
    
    public Report(){
        this.email_user = "";
        this.motivo = "";
        this.cod_cache="";
    }
    
    public Report(String em, String mot, String c){
        this.email_user = em;
        this.motivo = mot;
        this.cod_cache = c;
    }
    
    public Report(Report r){
        this.email_user = getEmail();
        this.motivo = r.getMotivo();
        this.cod_cache = r.getCodCache();
    }
    
    public String getEmail() { return this.email_user; }
    public String getMotivo() { return this.motivo; }
    public String getCodCache() { return this.cod_cache; }
    
    public void setEmail(String em) { this.email_user = em; }
    public void setMotivo(String m) { this.motivo = m; }
    public void setCodCache(String c){ this.cod_cache = c; }
    
    public Report clone(){
        return new Report(this);
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        
        s.append("User que fez este report: "+email_user);        
        s.append("Código da cache: "+cod_cache);
        s.append("Motivo do report: "+motivo);
        
        return s.toString();
    }
}
