package app;

import shop.Product;

public class Discounted extends Product {
    public Discounted(long priceCents) {
        super(priceCents);
    }

    long ownPrice() {
        return this.priceCents;            // OK: доступ через власний об'єкт підкласу
    }

    long priceOf(Discounted other) {
        return other.priceCents;           // OK: посилання має тип Discounted
    }

    long priceOf(Product other) {
        if (other instanceof Discounted d)
            return d.priceCents;           // помилка компіляції
        return 0L;
    }
}