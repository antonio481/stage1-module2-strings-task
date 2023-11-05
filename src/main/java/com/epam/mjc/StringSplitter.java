package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        ArrayList<String> substrings= new ArrayList<>();
      StringBuilder delimitersString= new StringBuilder();
      for(String s : delimiters){
          delimitersString.append(s).append("|");
      }
      delimitersString = new StringBuilder(delimitersString.substring(0, delimitersString.length() - 1));
        Collections.addAll(substrings, source.split(delimitersString.toString()));
        substrings.removeAll(Arrays.asList("", null));
        return substrings;
}}
