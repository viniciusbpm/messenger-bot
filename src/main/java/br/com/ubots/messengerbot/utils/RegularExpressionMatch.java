package br.com.ubots.messengerbot.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

public class RegularExpressionMatch {
    private static final String SUBSTRING_ERROR_MESSAGE = "Regular expression doesn't match value";
    public static boolean doesRegularExpressionMatchValue(String regex, String value){
        Pattern pattern = compile(regex, CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static String getValueSubstringFromRegularExpression(String value, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if(matcher.find()){
            return matcher.group(0);
        } else throw new IllegalArgumentException(SUBSTRING_ERROR_MESSAGE);
    }
}
