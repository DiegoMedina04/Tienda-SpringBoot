package store.demostore.services.handleErrors;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class HandleErrorsService {

    public ResponseEntity<?> vaidateErrors(BindingResult bindingResult) {
        HashMap<String, String> errorsMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(err -> {
            errorsMap.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errorsMap);
    }
}
