package ca.intelliware.ag.blueconsoledb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blue-results")
public class BlueResults {

    @GetMapping("/calculate/{ranksetId}")
    public void calculate(@PathVariable Integer ranksetId) {
        System.out.println(String.format("[BlueResults.calculate] ranksetId: %s", ranksetId+100));
    }
}
