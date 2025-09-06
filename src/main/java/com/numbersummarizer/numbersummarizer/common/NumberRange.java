package com.numbersummarizer.numbersummarizer.common;


import java.util.Collection;

import org.springframework.stereotype.Component;

import com.numbersummarizer.numbersummarizer.Infrastructure.settings.InputSetting;
import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;

@Component
public class NumberRange {
    
    private NumberRangeSummarizer nSummarizer;
    private InputSetting input;

    public Collection<Integer> collect(){
        return nSummarizer.collect(input.getSequenceString());
    }

    public String summarizeCollection(Collection<Integer> sequenceCollection){
        return nSummarizer.summarizeCollection(sequenceCollection);
    }

    public String getInput() {
        return input.getSequenceString();
    }

    public void setInput(InputSetting input) {
        this.input = input;
    }

    public NumberRange(InputSetting input,NumberRangeSummarizer nSummarizer){
        this.input = input;
        this.nSummarizer = nSummarizer;
    }


}
