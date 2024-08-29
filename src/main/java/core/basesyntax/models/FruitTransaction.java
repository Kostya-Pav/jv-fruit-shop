package core.basesyntax.models;

public class FruitTransaction {
    private Operation activity;
    private String fruitName;
    private int quantity;

    public FruitTransaction(Operation activity, String fruitName, int quantity) {
        this.activity = activity;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public Operation getActivity() {
        return activity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String shortName;

        Operation(String shortName) {
            this.shortName = shortName;
        }

        public static Operation fromCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getShortName().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("Unknown code: " + code);
        }

        public String getShortName() {
            return shortName;
        }
    }
}
