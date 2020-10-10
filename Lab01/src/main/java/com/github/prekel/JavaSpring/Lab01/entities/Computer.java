package com.github.prekel.JavaSpring.Lab01.entities;

public class Computer {

    protected String Name;
    private int Field1;

    public Computer() {
        Field1 = 1;
        Name = "ComputerName";
    }

    public Computer(int field1, String name) {
        Field1 = field1;
        Name = name;
    }

    @Override
    public int hashCode() {
        int result = getField1();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;

        Computer computer = (Computer) o;

        if (getField1() != computer.getField1()) return false;
        return getName() != null ? getName().equals(computer.getName()) : computer.getName() == null;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Name='" + Name + '\'' +
                ", Field1=" + Field1 +
                '}';
    }

    public int getField1() {
        return Field1;
    }

    public String getName() {
        return Name;
    }

    public void setField1(int field1) {
        Field1 = field1;
    }
}
