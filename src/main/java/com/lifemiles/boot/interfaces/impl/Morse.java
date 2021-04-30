package com.lifemiles.boot.interfaces.impl;

import com.lifemiles.boot.interfaces.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Morse implements Encoder {
    private static Logger LOG = LoggerFactory.getLogger(Morse.class);

    @Override
    public void encode(String text) {
        StringBuilder result = new StringBuilder();
        List<String> alfa = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"});

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};
        for (String s : text.toLowerCase().split("")) {
            if (alfa.indexOf(s) >= 0) {
                result.append(morse[alfa.indexOf(s)]);
            } else {
                result.append(s);
            }
        }
        LOG.info(result.toString());
    }
}