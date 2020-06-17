package br.com.mhbp.ood.interview.parkinglot.groking_solution;

import br.com.mhbp.ood.interview.parkinglot.groking_solution.enums.AccountStatus;

public abstract class Account {

    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword(){ return false; }
}
