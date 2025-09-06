package com.numbersummarizer.numbersummarizer.Infrastructure.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {

        return  Arrays
                .stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        int[] sequence = new int[input.size()];
        int i= 0;
        for(Integer num: input){
            if(i < sequence.length)
            sequence[i++] = num;
        }

        //have them go through a hashset to filter out any duplicates
        // order them
        // cover edge case (Extreme and Empty string)
        int j = 0, k = 0;
        String strBuild = "";
        while(j < sequence.length-1){
            if(sequence[j]+1 != sequence[j+1]){
                if( j-k != 0){
                    strBuild+= sequence[k] + "-" + sequence[j] + ",";
                }else{
                    strBuild+= sequence[j] + ",";
                 }
                 k = j+1;      
            }
            j++;
        }
        if (j-k != 0){
            strBuild+= sequence[k] + "-" + sequence[j];
        }else{
            strBuild+= sequence[j];
        }

        return strBuild;
    }
    

}
