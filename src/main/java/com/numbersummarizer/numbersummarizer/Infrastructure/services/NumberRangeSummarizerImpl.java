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

        if(input.isEmpty()) return "Type in a valid Sequence";
        Set<Integer> uniqueNumberSequence = input
            .stream()
            .collect(Collectors.toCollection(HashSet::new));
        int[] sequence = new int[uniqueNumberSequence.size()];
        int i= 0;
        for(Integer num: uniqueNumberSequence){
            if(i < sequence.length)
            sequence[i++] = num;
        }
        Arrays.sort(sequence);
        int j = 0, k = 0;
        String buildSequenceString = "";
        while(j < sequence.length-1){
            if(sequence[j]+1 != sequence[j+1]){
                 buildSequenceString += j-k != 0? sequence[k] + "-" + sequence[j] + "," : sequence[j] + ",";  
                 k = j+1;      
            }
            j++;
        }
        buildSequenceString+= j-k !=0?  sequence[k] + "-" + sequence[j] : sequence[j];

        return buildSequenceString;
    }
    

}
