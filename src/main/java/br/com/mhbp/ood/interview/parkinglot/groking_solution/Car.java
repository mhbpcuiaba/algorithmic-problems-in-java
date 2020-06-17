package br.com.mhbp.ood.interview.parkinglot.groking_solution;

import br.com.mhbp.ood.interview.parkinglot.groking_solution.enums.VehicleType;

public class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR);
    }

    @Override
    public VehicleType getType() {
        return null;
    }
}