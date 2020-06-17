package br.com.mhbp.ood.interview.parkinglot.groking_solution;

import br.com.mhbp.ood.interview.parkinglot.groking_solution.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck() {
        super(VehicleType.TRUCK);
    }

    @Override
    public VehicleType getType() {
        return null;
    }
}