import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");
        var testBean = context.getBean("myBean", MyBean.class);
        System.out.println(testBean.getName());
        context.close();
    }
}