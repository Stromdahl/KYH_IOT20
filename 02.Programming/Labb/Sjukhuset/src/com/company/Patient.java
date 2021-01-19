package com.company;

public class Patient{
    private String name;
    private String sickness = null;

    Patient(String name){
        this.name=name;
    }

    Patient(String name, String sickness){
        this(name);
        if(sickness != null){
            this.sickness = sickness;
        }
    }

    String getName(){
        return name;
    }

    boolean isSick(){
        return sickness != null;
    }

    String getSickness(){
        return sickness;
    }

    void takeMedication(Medicine medicine) {
        String treatment = medicine.getTreatmentName();
        if (sickness != null && sickness.equals(treatment)) {
            sickness = null;
        }
    }
}