package poly.edu.duantotnghiep.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
public class HomeController {

    @GetMapping("")
    public ResponseEntity<?> show(){

        return null;
    }
}
