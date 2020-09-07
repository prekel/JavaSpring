package entities;

public class PersonalComputer extends Computer {
    private int Field2;

    private String Name2;

    public PersonalComputer() {
        super(1, "PersonalComputerName");
        Field2 = 2;
        Name2 = "PersonalComputerName2";
    }

    public PersonalComputer(int field1, int field2, String name, String name2) {
        super(field1, name);
        setField2(field2);
        setName2(name2);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getField2();
        result = 31 * result + (getName2() != null ? getName2().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalComputer)) return false;
        if (!super.equals(o)) return false;

        PersonalComputer that = (PersonalComputer) o;

        if (getField2() != that.getField2()) return false;
        return getName2() != null ? getName2().equals(that.getName2()) : that.getName2() == null;
    }

    public int getField2() {
        return Field2;
    }

    public void setField2(int field2) {
        Field2 = field2;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "Field2=" + Field2 +
                ", Name2='" + Name2 + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
