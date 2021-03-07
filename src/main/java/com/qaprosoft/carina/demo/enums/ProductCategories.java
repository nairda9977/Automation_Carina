package com.qaprosoft.carina.demo.enums;

public enum ProductCategories {

    LAPTOPS_PC("Ноутбуки та комп’ютери "),
    PHONES_TV_ELECTRONIC("Смартфони, ТВ і електроніка "),
    GAMERS_PROD("Товари для геймерів "),
    HOUSE_TECHNIC("Побутова техніка "),
    HOUSEHOLD_PRODUCT("Товари для дому "),
    TOOLS_CAR_PRODUCTS("Інструменти та автотовари "),
    PLUMBING_REPAIR("Сантехніка та ремонт "),
    HOUSE_GARDEN("Дача, сад і город "),
    SPORT("Спорт і захоплення "),
    CLOTHES_SHOES_JEWELRY("Одяг, взуття та прикраси "),
    BEAUTY_HEALTH("Краса та здоров’я "),
    KIDS_PROD("Дитячі товари "),
    STATIONERY_BOOKS("Канцтовари та книги "),
    ALCOHOL_AND_PRODUCTS("Алкогольні напої та продукти "),
    GOODS_BUSINESS("Товари для бізнесу "),
    SERVICES("Послуги та сервіси ");

    private final String productCategories;

    ProductCategories(String prodCat){
        this.productCategories=prodCat;
    }

    public String getValue () {
        return productCategories;
    }
}
