package com.numbersummarizer.numbersummarizer.Infrastructure.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;

@Component
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

        Set<Integer> uniqueNumberSequence = input
            .stream()
            .collect(Collectors.toCollection(HashSet::new));
        int[] sequence = new int[uniqueNumberSequence.size()];
        int i= 0;
        for(Integer num: uniqueNumberSequence){
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
                 strBuild += j-k != 0? sequence[k] + "-" + sequence[j] + "," : sequence[j] + ",";  
                 k = j+1;      
            }
            j++;
        }
        strBuild+= j-k !=0?  sequence[k] + "-" + sequence[j] : sequence[j];

        return strBuild;
    }
    

}
