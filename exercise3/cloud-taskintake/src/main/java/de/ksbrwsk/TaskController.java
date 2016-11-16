package de.ksbrwsk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskProcessor taskProcessor;

    @PostMapping("/tasks")
    public @ResponseBody String publishRequest(@RequestBody String payload) {
        this.taskProcessor.publishRequest(payload);
        return "success";
    }
}
