package com.numbersummarizer.numbersummarizer.common;


import java.util.Collection;

import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;

public class NumberRange {
    
    private NumberRangeSummarizer nSummarizer;
    private String input;

    public Collection<Integer> collect(){
        return nSummarizer.collect(input);
    }

    public String summarizeCollection(Collection<Integer> sequenceCollection){
        return nSummarizer.summarizeCollection(sequenceCollection);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public NumberRange(String input,NumberRangeSummarizer nSummarizer){
        this.input = input;
        this.nSummarizer = nSummarizer;
    }


}
