package ConversorDeMoedas.Shared.Enums;

public enum CURRENCY_TYPE {
    USD(0),
    ARS(1),
    COP(2),
    BRL(3);

    CURRENCY_TYPE(int value) {
        this.type = value;
    }

    private int type;

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
