package com.numbersummarizer.numbersummarizer.Infrastructure.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// Class to configure the input value
@ConfigurationProperties(prefix = "seq")
@Component
public class InputSetting {
    
    private String sequenceString;


    public String getSequenceString() {
        return sequenceString;
    }

    public void setSequenceString(String sequenceString) {
            this.sequenceString = sequenceString;
    }
}
