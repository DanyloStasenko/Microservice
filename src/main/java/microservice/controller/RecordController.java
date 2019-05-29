package microservice.controller;

import microservice.model.Record;
import microservice.service.RecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RecordController {

    private static final Logger log = LogManager.getLogger(RecordController.class);

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PutMapping("/records")
    public @ResponseBody ResponseEntity<Object> addRecord (@RequestBody Record record) {
        log.info("Adding new record: " + record);
        Record addedRecord = recordService.addRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRecord);
    }
}
