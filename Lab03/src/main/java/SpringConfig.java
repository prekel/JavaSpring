import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:pc4.properties")
public class SpringConfig {
    @Value("${pc4.name}")
    private String volume;

    @Bean("pc1")
    public PersonalComputer pc1() {
        return new PersonalComputer(cpu1(), "Pc with cpu1");
    }

    @Bean("cpu1")
    public Cpu cpu1() {
        return new LockedCpu(3600);
    }

    @Bean("pc2")
    public PersonalComputer pc2() {
        return new PersonalComputer(cpu2(), "Pc with cpu2");
    }

    @Bean("cpu2")
    public Cpu cpu2() {
        return new LockedCpu(2600);
    }

    @Bean("pc3")
    public PersonalComputer pc3() {
        var ret = new PersonalComputer(cpu3());
        ret.setName("Pc with cpu3");
        return ret;
    }

    @Bean("cpu3")
    public Cpu cpu3() {
        return new UnlockedCpu(100, 40);
    }

    @Bean("pc4")
    public PersonalComputer pc4() {
        var ret = new PersonalComputer(cpu4());
        ret.setName(volume);
        return ret;
    }

    @Bean("cpu4")
    public Cpu cpu4() {
        return new UnlockedCpu(110, 20);
    }
}
