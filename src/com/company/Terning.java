package com.company;

import java.util.Random;

public class Terning {
    public int tall;

    public Terning(){
        tall = new Random().nextInt(5) + 1;
    }
}
