/**
 * Author: Siyabonga Samuel
 * Date: September 2025
 * Description: Number range summarizer implementation
 */

package com.numbersummarizer.numbersummarizer.Infrastructure.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.numbersummarizer.numbersummarizer.application.interfaces.NumberRangeSummarizer;

@Component
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /*
     * collect the input
     * @param input
     * @return Type Collection
     */
    @Override
    public Collection<Integer> collect(String input) {

        Optional<String> str = Optional.ofNullable(input);
        String strValue = str.orElseThrow(()-> new NullPointerException("Input cannot be null!"));
        if(strValue.isEmpty()) throw new IllegalArgumentException("input cannot be empty!");
         
        return  Arrays
                .stream(input.split(","))
                .map(String::trim)
                .map(num -> {
                    try{ 
                        return Integer.parseInt(num);
                    }catch(NumberFormatException e){
                        throw new IllegalArgumentException("Invalid String");
                    }})
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /*
     * get the summarized string
     * @param input (Type Collection)
     * @return Type String
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // Collects the input to the ArrayList and stores it in an int array
        List<Integer> uniqueNumberSequence = input
            .stream()
            .collect(Collectors.toCollection(ArrayList::new));
        int[] sequence = uniqueNumberSequence.stream().mapToInt(Integer::intValue).toArray();
        int j = 0, k = 0;

        // creates the range summariser
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
