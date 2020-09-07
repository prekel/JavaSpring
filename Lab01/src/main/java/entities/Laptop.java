package entities;

public class Laptop extends PersonalComputer {
    private int Field3;
    private String Name3;

    public Laptop() {
        super(1, 2, "LaptopName", "LaptopName2");
        Field3 = 3;
        Name3 = "LaptopName3";
    }

    public Laptop(int field1, int field2, int field3, String name, String name2, String name3) {
        super(field1, field2, name, name2);
        setField3(field3);
        setName3(name3);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getField3();
        result = 31 * result + (getName3() != null ? getName3().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (getField3() != laptop.getField3()) return false;
        return getName3() != null ? getName3().equals(laptop.getName3()) : laptop.getName3() == null;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Field3=" + Field3 +
                ", Name3='" + Name3 + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public int getField3() {
        return Field3;
    }

    public void setField3(int field3) {
        Field3 = field3;
    }

    public String getName3() {
        return Name3;
    }

    public void setName3(String name3) {
        Name3 = name3;
    }

}
