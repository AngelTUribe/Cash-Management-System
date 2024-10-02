class Coins {
    private int quantityOnHand;
    private float denomination;
    private float weight;

    public Coins(float denomination, float weight) {
        this.denomination = denomination;
        this.weight = weight;
        this.quantityOnHand = 0;
    }

    public float getTotalWeight() {
        return weight * quantityOnHand;
    }

    public float getTotalValue() {
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
        return "$" + String.format("%4.2f", amount) + " in $" + denomination + " coins";
    }

    @Override
    public String toString() {
        return printPretty(getTotalValue());
    }
}
