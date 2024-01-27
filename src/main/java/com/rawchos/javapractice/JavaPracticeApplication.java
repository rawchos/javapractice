package com.rawchos.javapractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rawchos.javapractice.aoc23.AoC23Runner;

import java.util.List;

@SpringBootApplication
public class JavaPracticeApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(JavaPracticeApplication.class);

	// TODO: Probably move this to it's own AoC23Driver or something like that
	@Autowired private List<AoC23Runner> aoc23Runners;

	public static void main(String[] args) {
		SpringApplication.run(JavaPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Executing : command line runner");

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("aoc23")) {
				runAoc23();
			}
		}
	}

	private void runAoc23() {
		log.info("Running AoC 23 Solutions");

		for (AoC23Runner aoc23Runner : aoc23Runners) {
			aoc23Runner.processSolution();
		}

	}

}
