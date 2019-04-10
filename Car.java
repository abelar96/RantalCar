package edu.txstate.d_a204.carrental_diegoabelarmorales;
import java.io.Serializable;

public class Car implements Serializable {

    private int id;
    private String name;
    private String brand;
    private Double rentalCost;
    private String carUrl;
    private int carPic;


    public int getCarPic() {
        return carPic;
    }

    public void setCarPic(int carPic) {
        this.carPic = carPic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(Double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public String getCarUrl() {
        return carUrl;
    }

    public void setCarUrl(String carUrl) {
        this.carUrl = carUrl;
    }

    public double carRentalTotal (int days){

        return this.rentalCost * days;
    }

    public Car() {
    }

    public Car(int id, String name, String brand, Double rentalCost, String carUrl, int carPic) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.rentalCost = rentalCost;
        this.carUrl = carUrl;
        this.carPic = carPic;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.name;
    }


}
