package com.lifemiles.boot;

import com.lifemiles.boot.interfaces.Encoder;
import com.lifemiles.boot.interfaces.impl.Binary;
import com.lifemiles.boot.interfaces.impl.Morse;
import com.lifemiles.boot.interfaces.impl.Murcielago;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootConsoleApplication
        implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
    @Autowired
    private List<Encoder> encoders;

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
        for (Encoder e : encoders) {
            e.encode("Kennia");
        }
    }
}