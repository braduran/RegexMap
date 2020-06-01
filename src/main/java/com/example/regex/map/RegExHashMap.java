package com.example.regex.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class RegExHashMap<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	
	// list of regular expression patterns
    private ArrayList<Pattern> regExPatterns = new ArrayList<Pattern>();
    
    // list of regular expression values which match patterns
    private ArrayList<V> regExValues = new ArrayList<V>();
    /**
     * Compile regular expression and add it to the regexp list as key.
     */
    @Override
    public V put(K key, V value) {
       
        regExPatterns.add(Pattern.compile(key.toString()));
        regExValues.add(value);
        return value;
    }
    /**
     * If requested value matches with a regular expression,
     * returns it from regexp lists.
     */
    @Override
    public V get(Object key) {
        CharSequence cs = new String(key.toString());
       
        for (int i = 0; i < regExPatterns.size(); i++) {
            if (regExPatterns.get(i).matcher(cs).matches()) {
                return regExValues.get(i);
            }
        }
        return super.get(key);
    }
}
