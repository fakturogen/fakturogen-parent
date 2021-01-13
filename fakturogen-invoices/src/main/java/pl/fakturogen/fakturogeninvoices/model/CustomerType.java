package pl.fakturogen.fakturogeninvoices.model;

public enum CustomerType {
    C0("osoba fizyczna"), C1("podmiot gospodarczy");

    private CustomerType(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public String toString() {
        return "CustomerType{" +
                "description='" + description + '\'' +
                '}';
    }
}
