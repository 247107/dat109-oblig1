package com.company;

public class Main {

    public static void main(String[] args) {

        // hello
        Spiller spiller1 = new Spiller();
        Spiller spiller2 = new Spiller();
        Spiller spiller3 = new Spiller();
        Spiller spiller4 = new Spiller();

        Spill spill = new Spill(spiller1, spiller2, spiller3, spiller4);
        spill.setBrett();

        for(int i = 0; i < 100; i++){
            spill.runde(new Terning());

        }
    }
}
