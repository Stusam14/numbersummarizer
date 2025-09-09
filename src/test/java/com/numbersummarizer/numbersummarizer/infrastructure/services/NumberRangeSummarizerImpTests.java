package com.numbersummarizer.numbersummarizer.infrastructure.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.numbersummarizer.numbersummarizer.Infrastructure.services.NumberRangeSummarizerImpl;
import com.numbersummarizer.numbersummarizer.Infrastructure.settings.InputSetting;
import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;
import com.numbersummarizer.numbersummarizer.common.NumberRange;


/*
 * The tests ran here assume the constraints 0 < n < max (Integer), n is an input
 * The String must not be empty
 * The value must not be negative
 * The value can be written in any order
 * The String must always be integers not any other characters
 */
public class NumberRangeSummarizerImpTests {
    
    InputSetting inputSetting = new InputSetting();
    NumberRangeSummarizer nSummarizer = new NumberRangeSummarizerImpl();
    NumberRange numberRange = new NumberRange(null, nSummarizer);

     @Test
    public void NumberRangeSummarizerWithEmptyInputValue(){
        
		inputSetting.setSequenceString("");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertNotNull(numberRange.summarizeCollection(collected));
		
    }

    @Test
    public void NumberRangeSummarizer_WithOneValue(){
        
		inputSetting.setSequenceString("1");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("1",  numberRange.summarizeCollection(collected));
    }

    @Test
    public void NumberRangeSummarizer_WithTwoValues(){
        
		inputSetting.setSequenceString("1,2");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("1-2",  numberRange.summarizeCollection(collected));
    }

    @Test
    public void NumberRangeSummarizer_WithRepeatedValues(){
        
		inputSetting.setSequenceString("0,0,1,1,2,2,2,3,3,3");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("0-3",  numberRange.summarizeCollection(collected));
		
    }

     @Test
    public void NumberRangeSummarizer_WithUnorderedRepeatedValues(){
        
		inputSetting.setSequenceString("0,2,2,5,6,6,7,1,1,1,3,3,4,4,4,4,5,3,1");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("0-7",  numberRange.summarizeCollection(collected));
		
    }

    @Test
    public void NumberRangeSummarizer_WithUnorderedRepeatedValuesAndNumberGaps(){
        
		inputSetting.setSequenceString("0,2,2,5,7,1,1,1,3,3,4,4,4,4,5,3,1,11,12,15,16,15,17,17,15,16,20");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("0-5,7,11-12,15-17,20",  numberRange.summarizeCollection(collected));
		
    }

    @Test
    public void NumberRangeSummarizer_WithUnorderedRepeatedLargeValuesAndNumberGaps(){
        
		inputSetting.setSequenceString("0,20020,20021,5,70000000,1000001,1000002,1000003,20022,300200,300201,400000,400001,400002,4000000,5000,300,320,321,321,321,13949,1199,1211,1588,1600,150,1700,1700000,15,16,20");
		numberRange.setInput(inputSetting);
		Collection<Integer> collected = numberRange.collect();
        assertEquals("0,5,15-16,20,150,300,320-321,1199,1211,1588,1600,1700,5000,13949,20020-20022,300200-300201,400000-400002,1000001-1000003,1700000,4000000,70000000",  numberRange.summarizeCollection(collected));
		
    }

}
