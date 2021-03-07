package com.qaprosoft.carina.demo.enums;

public enum KidsProdSubcategory {
    TOYS("Іграшки"),
    LEGO(" Конструктори LEGO ");

    private final String kidsProd;
     KidsProdSubcategory (String kidsProd){
        this.kidsProd=kidsProd;
    }

    public String  getValue () {
         return kidsProd;
    }
}
