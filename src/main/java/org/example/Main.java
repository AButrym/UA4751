package org.example;
class Document {
    private String header() {
        return "Document";
    }

    String render() {
        return header() + " | " + footer();
    }

    String footer() {
        return "Document footer";
    }
}

class Invoice extends Document {
    String header() {
        return "Invoice";
    }

    @Override
    String footer() {
        return "Invoice footer";
    }
}

class PrivateNo {
    public static void main(String[] args) {
        System.out.println(new Invoice().render());
        System.out.println(new Invoice().header());
    }
}