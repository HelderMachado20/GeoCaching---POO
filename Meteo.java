
/**
 * Write a description of class Meteo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Meteo
{
    CHFR{
        public String toString(){ return "Chuva fraca"; }
    },
    CH{
        public String toString(){ return "Chuva"; }
    },
    CHFT{
        public String toString(){ return "Chuva forte"; }
    },
    SOL{
        public String toString(){ return "Sol"; }
    },
    NEV{
        public String toString(){ return "Nevoeiro"; }
    },
    TEMP{
        public String toString(){ return "Tempestade"; }
    },
    NUB{
        public String toString(){ return "Nublado"; }
    };
}
