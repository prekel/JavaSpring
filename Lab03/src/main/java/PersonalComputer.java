public class PersonalComputer {
    private final Cpu cpu;
    private String name = "Default PC name";

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "cpu=" + cpu +
                ", name='" + name + '\'' +
                '}';
    }

    public PersonalComputer(Cpu cpu) {
        this.cpu = cpu;
    }

    public PersonalComputer(Cpu cpu, String name) {
        this.cpu = cpu;
        this.name = name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
