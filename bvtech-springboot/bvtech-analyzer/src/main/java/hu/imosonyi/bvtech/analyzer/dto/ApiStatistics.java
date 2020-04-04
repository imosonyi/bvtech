package hu.imosonyi.bvtech.analyzer.dto;

import java.util.HashMap;
import java.util.Map;

public class ApiStatistics {

    private final Map<String, Integer> wordCounts = new HashMap<>();

    private long timeSum;

    private int timeCount;

    private int sizeSum;

    private int sizeCount;

    private int mostFrequentCount;

    private String mostFrequentWord;

    private Long start;

    private Long end;
    
    public String getMostFrequentWord () {
        return mostFrequentWord;
    }

    public void setStart (Long start) {
        this.start = start;
    }

    public void setEnd (Long end) {
        this.end = end;
    }

    public synchronized void addTime (Long start) {
        timeSum += System.currentTimeMillis() - start;
        ++timeCount;
    }

    public synchronized void addSize (Integer size) {
        sizeSum += size;
        ++sizeCount;
    }

    /**
     * TODO.
     * @param word TODO.
     */
    public synchronized void addWord (String word) {
        Integer newCount = wordCounts.getOrDefault(word, 0) + 1;
        wordCounts.put(word, newCount);
        if (newCount > mostFrequentCount && !word.equals(mostFrequentWord)) {
            mostFrequentWord = word;
            mostFrequentCount = newCount;
        }
    }
    
    public double getAverageTime () {
        return (double) timeSum / timeCount;
    }

    public double getAverageSize () {
        return (double) sizeSum / sizeCount;
    }

    public long getTotalTime () {
        return end - start;
    }

}
