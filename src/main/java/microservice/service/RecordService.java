package microservice.service;

import microservice.model.Record;
import microservice.repository.RecordRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    private static final Logger log = LogManager.getLogger(RecordService.class);

    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository repository) {
        this.recordRepository = repository;
    }

    public Record addRecord(Record record){
        Record saved = recordRepository.save(record);
        log.info("Added: " + record);
        return saved;
    }
}
