package com.company;


import java.util.ArrayList;

public class Spill {
    ArrayList<Spiller> spillerListe = new ArrayList<>(4);
    Data[][] brett = new Data[10][10];
    int tall = 0;


    public Spill(Spiller ... spillere){
        if (spillere.length > 1 && spillere.length < 5){
            for(Spiller spiller : spillere){
                spillerListe.add(spiller);
            }
        }
    }

    public void setBrett() {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                brett[i][j] = new Data("-1 -1");
            }
        }

        brett[0][1] = new Data("3 2");
        brett[0][3] = new Data("1 6");
        brett[0][7] = new Data("3 9");
        brett[2][0] = new Data("4 1");
        brett[2][7] = new Data("8 3");
    }

    public void runde(Terning terning){
        Spiller nåSpiller;

        nåSpiller = spillerListe.get(tall);
        String temp = nåSpiller.plassering;

        spillerListe.get(tall).plassering = setSpillerPlassering(nåSpiller, terning);

        System.out.println(temp + " --> " +  terning.tall+ " --> " + nåSpiller.plassering);

        tall++;
        if(tall > spillerListe.size()-1) { // spillerListe er alltid size 4
            tall = 0;
        }

    }


    public String setSpillerPlassering(Spiller spiller, Terning terning) {
        String [] nåværendePlasser = spiller.plassering.split(" ");

        int x =  Integer.parseInt(nåværendePlasser[0]);
        int y = Integer.parseInt(nåværendePlasser[1]);
        int pluss = terning.tall;
        int nyX;
        int nyY = y;

        nyX = x + pluss;

        if(nyX > 9){
            nyX = nyX - 9;
            nyY++;

            if (nyY > 9) System.out.println("this guy won");
        }

        Data data = brett[nyX][nyY];
        String nyPlasseringX = data.plassering.split(" ")[0];
        String nyPlasseringY = data.plassering.split(" ")[1];

        if (!nyPlasseringX.equals("-1")){
            nyX = Integer.parseInt(nyPlasseringX);
            nyY = Integer.parseInt(nyPlasseringY);
        }
        spiller.plassering = nyX + " " + nyY;

        return spiller.plassering;
    }

}
