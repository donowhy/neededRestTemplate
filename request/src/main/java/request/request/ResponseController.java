package request.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResponseController {

    private final RequestService requestService;

    public ResponseController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/gr")
    public ResponseDto getResponse(@RequestParam String name, @RequestParam int age) {
        requestService.sendGetRequest(name, age);
        return ResponseDto.builder().name(name).age(age).build();
    }

    @PostMapping("/pr")
    public ResponseDto postResponse(@RequestBody ResponseDto responseDto) throws JsonProcessingException {
        requestService.sendPostRequest(responseDto);
        return responseDto;
    }
}
