package org.example;

import java.util.ArrayList;
import com.google.gson.Gson;
public class Elaborazione_Arraylist {
    Gson gson=new Gson();
    ArrayList<Piatti> arr;
    Elaborazione_Arraylist(){
        arr=new ArrayList<Piatti>();
    }

    void add_Prodotti(int id,int qta,String nomeProdotto,String descrizione,double costo){
        Piatti a=new Piatti(id,nomeProdotto,descrizione,costo);
        arr.add(a);
    }


    void crea_lista(){
        add_Prodotti(1,50,"risotto alla milanese","asfgdgs",16.32);
        add_Prodotti(2,20,"cotoletta","gragssas",448.35);
        add_Prodotti(3,30,"pasta","grsadgsd",948.22);
        add_Prodotti(4,18,"pizza","gsdgdsag",963.22);
        add_Prodotti(5,99,"asefewf","sgdagd",33.52);
        add_Prodotti(6,2,"fesadfdsafsa","sadgdsg",116.85);
    }
    String all(){
        String msg="";
        return gson.toJson(arr);

    }

    String moreExpensive(){
        arr.sort((Piatti p1, Piatti p2)->(int) (p2.costo-p1.costo));
        return gson.toJson(arr.get(0));
    }

    String sort_crescente(){
        arr.sort((Piatti p1, Piatti p2)->(int) (p1.costo-p2.costo));
        return gson.toJson(arr);
    }
    String sort_decrescente(){
        arr.sort((Piatti p1, Piatti p2)->(int) (p2.costo-p1.costo));
        return gson.toJson(arr);
    }

}