package cinema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public Cinema cinema(){
        return new Cinema();
    }
    @Bean
    public MyException myException(){
        return new MyException();
    }
    @Bean
    public Statistic statistic(){
        return new Statistic();
    }
}
