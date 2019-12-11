package by.bsuir.carrental.service;

import by.bsuir.carrental.entity.Car;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car a, Car b){

        return a.getModel().compareTo(b.getModel());
    }
}
