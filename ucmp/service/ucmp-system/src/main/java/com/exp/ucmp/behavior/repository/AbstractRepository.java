package com.exp.ucmp.behavior.repository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRepository implements IRepository {
	
	protected String emojiFilter(String str) {
		String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
		Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
 
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(sb, "[[EMOJI:" + URLEncoder.encode(matcher.group(1),"UTF-8") + "]]");
            } catch (UnsupportedEncodingException e) {
            }
        }
        matcher.appendTail(sb);
        try {
        	return sb.toString();
        } finally {
        	patternString = null;
    		pattern = null;
            matcher = null;
            sb = null;
        }
	}
}
