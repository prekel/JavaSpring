import org.springframework.web.client.RestTemplate;

public class App {
    public static void main(String[] args) {
        var ret = retrieveFurniture(15);
        System.out.println(ret);
    }

    public static String retrieveFurniture(int id) {
        return new RestTemplate().getForObject("http://localhost:8888/furniture/{id}", String.class, id);
    }
}
