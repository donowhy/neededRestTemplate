package response.response;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRespository responseRespository;

    @Transactional
    public String save(ResponseDto responseDto){
        responseRespository.save(Response.builder()
                .name(responseDto.getName())
                .age(responseDto.getAge())
                .build());

        return "save";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseService that = (ResponseService) o;
        return Objects.equals(responseRespository, that.responseRespository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseRespository);
    }
}
