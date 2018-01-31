package ca.intelliware.ag.blueconsoledb.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blue-results")
public class BlueResults {

    private static Logger logger = LogManager.getLogger(BlueResults.class);

    @GetMapping("/calculate/{ranksetId}")
    public void calculate(@PathVariable Integer ranksetId) {
        logger.info(String.format("[calculate] ranksetId: %s", ranksetId));
    }
}
