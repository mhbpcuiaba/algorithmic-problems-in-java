package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.dutchflagproblem;

public enum Color {
    RED("31"), BLUE("34"), WHITE("30");

    private String value;

    Color(String s) {

        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
