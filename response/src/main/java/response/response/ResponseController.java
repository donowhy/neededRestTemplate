package response.response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ResponseController {

    private final ResponseService responseService;
    private final ResponseRespository responseRespository;

    @GetMapping("/getResponse")
    public String response(@RequestParam String name, @RequestParam int age){
        ResponseDto responseDto = new ResponseDto(name, age);
        return responseDto.getName() + " " + responseDto.getAge();
    }

    @PostMapping("/postResponse")
    public String save(@RequestBody ResponseDto responseDto){
        responseService.save(responseDto);
        return responseDto.getName() + " " + responseDto.getAge();
    }

    @GetMapping("/get-info")
    public List<Response> responseList (){
        return responseRespository.findAll();
    }

}
