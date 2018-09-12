package pl.sdacademy.citizens.model;

public class Animal {
    private Long id;
    private String name;
    private String race;

    private Animal (Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.race = builder.race;
    }

    public static Builder builder(CsvLine line) {
        return new Builder()
                .id(Long.parseLong(line.getElementAt(0)))
                .name(line.getElementAt(1))
                .race(line.getElementAt(2));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String race;

        private Builder() {
        }

        private Builder id(Long id) {
            this.id = id;
            return this;
        }

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder race(String race) {
            this.race = race;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
