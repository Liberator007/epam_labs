package by.bsuir.carrental.service;

import by.bsuir.carrental.entity.Car;

import java.util.Comparator;

public class CarYearIssueComparator implements Comparator<Car> {
    @Override
    public int compare(Car a, Car b){

        if(a.getYearIssue()> b.getYearIssue())
            return 1;
        else if(a.getYearIssue()< b.getYearIssue())
            return -1;
        else
            return 0;
    }
}
