package by.epam.task3.entity;

    public enum GemColor {
        BLUE("blue"),
        YELLOW("yellow"),
        GREEN("green"),
        RED("red"),
        COLORLESS("colorless"),
        PURPLE("purple"),
        PINK("pink");

        private String value;

        GemColor(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


    }

