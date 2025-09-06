package com.numbersummarizer.numbersummarizer.Infrastructure.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sequence")
@Component
public class InputSetting {
    
    String sequenceString;

    public String getSequenceString() {
        return sequenceString;
    }

    public void setSequenceString(String sequenceString) {
        this.sequenceString = sequenceString;
    }
    
}
