class Notes {
    private int quantityOnHand;
    private int denomination;

    public Notes(int denomination) {
        this.denomination = denomination;
        this.quantityOnHand = 0;
    }

    public int getTotalValue() {
        return denomination * quantityOnHand;
    }

    public void increaseQuantity(int quantity) {
        quantityOnHand += quantity;
    }

    public void decreaseQuantity(int quantity) {
        quantityOnHand = Math.max(0, quantityOnHand - quantity);
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public String printPretty(float amount) {
        return "$" + String.format("%4.2f", amount) + " in $" + denomination + " notes";
    }

    @Override
    public String toString() {
        return printPretty(getTotalValue());
    }
}
