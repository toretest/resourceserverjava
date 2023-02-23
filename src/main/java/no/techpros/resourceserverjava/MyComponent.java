package no.techpros.resourceserverjava;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MyComponent {
    public MyComponent(@Value("${toregard.verdi}") String verdi2) {
        System.out.println("MyComponent Value is "+verdi2);
    }

}
