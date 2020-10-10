package com.github.prekel.JavaSpring.Lab01.entities;

public class Tablet extends PersonalComputer {

    private int Field4;

    private String Name4;

    public Tablet() {
        super(1, 2, "TabletName", "TabletName2");
        Field4 = 4;
        Name4 = "TabletName4";
    }

    public Tablet(int field1, int field2, int field4, String name, String name2, String name4) {
        super(field1, field2, name, name2);
        setField4(field4);
        setName4(name4);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getField4();
        result = 31 * result + (getName4() != null ? getName4().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tablet)) return false;
        if (!super.equals(o)) return false;

        Tablet tablet = (Tablet) o;

        if (getField4() != tablet.getField4()) return false;
        return getName4() != null ? getName4().equals(tablet.getName4()) : tablet.getName4() == null;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "Field4=" + Field4 +
                ", Name4='" + Name4 + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public int getField4() {
        return Field4;
    }

    public void setField4(int field4) {
        Field4 = field4;
    }

    public String getName4() {
        return Name4;
    }

    public void setName4(String name4) {
        Name4 = name4;
    }
}
