package com.lifemiles.boot.interfaces.impl;

import com.lifemiles.boot.interfaces.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Murcielago implements Encoder {
    private static Logger LOG = LoggerFactory.getLogger(Murcielago.class);

    @Override
    public void encode(String text) {
        StringBuilder result = new StringBuilder();
        List<String> alfa = Arrays.asList(new String[]{"m", "u", "r", "c", "i", "e", "l", "a", "g", "o"});

        String[] morse = {"o", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String s : text.toLowerCase().split("")
        ) {
            if (alfa.indexOf(s) >= 0) {
                result.append(morse[alfa.indexOf(s)]);
            } else {
                result.append(s);
            }
        }
        LOG.info(result.toString());
    }
}