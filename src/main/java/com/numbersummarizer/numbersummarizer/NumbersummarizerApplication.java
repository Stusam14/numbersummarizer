package com.numbersummarizer.numbersummarizer;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.numbersummarizer.numbersummarizer.Infrastructure.settings.InputSetting;
import com.numbersummarizer.numbersummarizer.common.NumberRange;

@SpringBootApplication
public class NumbersummarizerApplication {
	private static Logger log = LoggerFactory.getLogger(NumbersummarizerApplication.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(NumbersummarizerApplication.class, args);
		NumberRange numberRange = context.getBean(NumberRange.class);
		InputSetting inputSetting = new InputSetting();
		Collection<Integer> collected = numberRange.collect();
		inputSetting.setSequenceString("1,2,2,2,3,3,3,5,5,6,7,10,11,12,13,14,15,16,20,21,22,23");
		numberRange.setInput(inputSetting);
		Collection<Integer> collection2 = numberRange.collect();
		log.info("================================================================================================================================================================");
		log.info("Summarised Range: {}" , numberRange.summarizeCollection(collected));
		log.info("Summarised Range: {}" , numberRange.summarizeCollection(collection2));
		log.info("================================================================================================================================================================");


	}

}
