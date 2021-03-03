package com.qaprosoft.carina.demo.enums;

public enum LaptopPcSubcategory {

        LAPTOPS("Ноутбуки"),
        MONITORS(" Монітори ");

private final String laptPcSub;

    LaptopPcSubcategory (String laptPcSub){
        this.laptPcSub=laptPcSub;
    }

    public String getLaptPcSub(){
        return laptPcSub;
    }
}
