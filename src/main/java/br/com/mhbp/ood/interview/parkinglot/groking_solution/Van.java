package br.com.mhbp.ood.interview.parkinglot.groking_solution;

import br.com.mhbp.ood.interview.parkinglot.groking_solution.enums.VehicleType;

public class Van extends Vehicle {
    public Van() {
        super(VehicleType.VAN);
    }

    @Override
    public VehicleType getType() {
        return null;
    }
}