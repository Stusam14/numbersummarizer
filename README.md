# Number Range Summarizer

- Implement code which has the ability to produce a comma delimited list of numbers, grouping the numbers into a range when they are sequential.

## Description
- Collects numbers from a comma-separated string.
- Summarizes consecutive numbers into ranges (e.g., 1-3,5,7-9).

## Features
- Strict input validation (throws exception for invalid entries)
- Removes duplicates and sorts numbers
- requires sl4j for logging

## Requirements
- Java 8+
- Maven for building
- Spring Boot 

## Usage
1. Clone the repository:
```bash
git clone https://github.com/Stusam14/numbersummarizer.git
```
2. or Download the Zip File
```
2. use : mvn spring-boot:run

Here is a log for where the output is shown, after the equal sign line the output is shown.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::       (v4.0.0-SNAPSHOT)

2025-09-10T00:32:28.962+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : Starting NumbersummarizerApplication using Java 23.0.2 with PID 4080 (C:\Users\Siyabonga\Desktop\Impact\numbersummarizer\target\classes started by Siyabonga in C:\Users\Siyabonga\Desktop\Impact\numbersummarizer)
2025-09-10T00:32:28.971+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : No active profile set, falling back to 1 default profile: "default"
2025-09-10T00:32:29.917+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : Started NumbersummarizerApplication in 1.748 seconds (process running for 2.694)
2025-09-10T00:32:29.928+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : ================================================================================================================================================================
2025-09-10T00:32:29.933+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : Summarised Range: 1,40-41,55-57,100,1000,12001-12004,20000
2025-09-10T00:32:29.936+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication     
   : Summarised Range: 0,5,15-16,20,150,300,320-321,1199,1211,1588,1600,1700,5000,13949,20020-20022,300200-300201,400000-400002,1000001-1000003,1700000,4000000,70000000
2025-09-10T00:32:29.937+02:00  INFO 4080 --- [numbersummarizer] [           main] c.n.n.NumbersummarizerApplication 
