package com.lifemiles.boot.interfaces.impl;

import com.lifemiles.boot.interfaces.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Binary implements Encoder {
    private static Logger LOG = LoggerFactory.getLogger(Binary.class);

    @Override
    public void encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char s : text.toCharArray()) {
            String padding = String.format("%8s", Integer.toBinaryString(s)).replace(' ', '0');
            result.append(padding);
            result.append(" ");
        }
        LOG.info(result.toString());
    }
}