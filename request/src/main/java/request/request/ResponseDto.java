package request.request;

import lombok.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class ResponseDto {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "ResponseDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
