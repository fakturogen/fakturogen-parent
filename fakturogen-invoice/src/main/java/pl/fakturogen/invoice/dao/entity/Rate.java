package pl.fakturogen.invoice.dao.entity;

/**
 * @author damian
 */

public enum Rate {
    R9("23%"),
    R8("8%"),
    R7("5%"),
    R6("4%"),
    R2("0%"),
    R1("zwolniony"),
    R0("nie podlega");

    Rate(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public String toString() {
        return "Rate{" +
                "description='" + description + '\'' +
                '}';
    }
}
