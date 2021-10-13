package com.ecommerce.shop.data.model;

public enum Currency {
    NGN("Naira"), USD("Dollar"), SGD("Singapore"),GBP("British Pound"),FRC("Franc"),GHC("Ghana Cedis");

    private String name;
    Currency(String s){
        this.name = s;
    }

    public String getName(){
        return name;
    }
}
