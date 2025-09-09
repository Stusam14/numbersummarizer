package com.numbersummarizer.numbersummarizer.common;


import java.util.Collection;

import org.springframework.stereotype.Component;

import com.numbersummarizer.numbersummarizer.Infrastructure.settings.InputSetting;
import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;


@Component
public class NumberRange {
    
    private NumberRangeSummarizer nSummarizer;
    private InputSetting input;

     public NumberRange(InputSetting input,NumberRangeSummarizer nSummarizer){
        this.input = input;
        this.nSummarizer = nSummarizer;
    }

    /*
     *  returns returns the collected string
     * @param sequenceCollection
     * @return Collection
     */
    public Collection<Integer> collect(){
        return nSummarizer.collect(input.getSequenceString());
    }

    /*
     *  returns the summarised string
     * @param sequenceCollection
     * @return String
     */
    public String summarizeCollection(Collection<Integer> sequenceCollection){
        return nSummarizer.summarizeCollection(sequenceCollection);
    }

    public String getInput() {
        return input.getSequenceString();
    }

    public void setInput(InputSetting input) {
        this.input = input;
    }
}
