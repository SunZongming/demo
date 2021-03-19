package com.sunzm.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author SunZm
 */
@RestController
public class Controller {
    @GetMapping("/ask/{operation}")
    public Map<String, Object> ask(@PathVariable String operation) {
        Map<String, Object> map = new HashMap<>();
        String filename = "error";
        String description = "error";
        int answer = 0;
        int firstNum = 0;
        int secondNum = 0;
        Random random = new Random();
        switch (operation) {
            case "1":
                firstNum = random.nextInt(9) + 1;
                secondNum = random.nextInt(9) + 1;
                answer = firstNum + secondNum;
                filename = "" + firstNum + 'p' + secondNum;
                description = firstNum + " + " + secondNum + " = ";
                break;
            case "2":
                firstNum = random.nextInt(9) + 1;
                secondNum = random.nextInt(9) + 1;
                answer = firstNum + secondNum;
                filename = "" + answer + 'm' + firstNum;
                description = answer + " - " + firstNum + " = ";
                answer = secondNum;
                break;
            case "3":
                firstNum = random.nextInt(9) + 1;
                secondNum = random.nextInt(9) + 1;
                answer = firstNum * secondNum;
                filename = "" + firstNum + 't' + secondNum;
                description = firstNum + " * " + secondNum + " = ";
                break;
            case "4":
                firstNum = random.nextInt(9) + 1;
                secondNum = random.nextInt(9) + 1;
                answer = firstNum * secondNum;
                filename = "" + answer + 'd' + firstNum;
                description = answer + " / " + firstNum + " = ";
                answer = secondNum;
                break;
            default:
                break;
        }
        map.put("filename", filename);
        map.put("description", description);
        map.put("answer", answer);
        return map;
    }
}
