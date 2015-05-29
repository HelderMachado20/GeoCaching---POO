
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

public class Eventos implements Serializable
{
    private String info;         //Informação/Descrição do evento
    private String nome;         //Nome do evento
    private int maxp;            //Máximo de participantes
    private ArrayList<Cache> caches;
    private HashMap<Utilizador,Integer> participantes;      //HashMap com os participantes e tempo médio (em minutos) inferido segundo o seu historial
    private GregorianCalendar prazo_insc;
    private GregorianCalendar data;
    private Simulacao resultados;
}
