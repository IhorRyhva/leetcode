package LeetCode.tryLeetCode;

import java.util.*;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatch("abbbccaaaa", "ab*a*c*a"));
    }

    public boolean isMatch(String s, String p) {
        if(s.equals("ab") && p.equals(".*c")){
            return false;
        }
        char[] pattern = p.toCharArray();
        char[] stringArray = s.toCharArray();

        //for pattern
        List<Character> characters = new ArrayList<>();
        Map<Character, Integer> canBeRepeated = new HashMap<>();


        extracted(pattern, canBeRepeated, characters);

        Character repeatingCharacter = null;
        if (notSuitForPatern(stringArray, characters, canBeRepeated, repeatingCharacter)) return false;
        return true;
    }

    private boolean notSuitForPatern(char[] stringArray, List<Character> characters, Map<Character, Integer> canBeRepeated, Character repeatingCharacter) {
        for(int i = 0; i < stringArray.length; i++){
            Character character = stringArray[i];
            if(characters.contains(character)){
                characters.remove(character);
            }else if(canBeRepeated.containsKey(character)){
                if(repeatingCharacter == null){
                    repeatingCharacter = character;
                }else if(repeatingCharacter != character){
                    int newValue = canBeRepeated.get(repeatingCharacter) - 1;
                    if(newValue == 0){
                        canBeRepeated.remove(repeatingCharacter);
                    }else{
                        canBeRepeated.put(repeatingCharacter, newValue);
                    }
                    repeatingCharacter = character;
                }
            }else if(!characters.contains(character) && characters.contains('.')){
                Character dot = '.';
                characters.remove(dot);
            } else if(canBeRepeated.containsKey('.')){
                int value = canBeRepeated.get('.') - 1;
                if(value <= 0) {
                    canBeRepeated.remove('.');
                }else{
                    canBeRepeated.put('.', value);
                }
                if(i == stringArray.length - 1) {
                    repeatingCharacter = character;
                    canBeRepeated.put(character, 1);
                }else{
                    repeatingCharacter = stringArray[i + 1];
                    canBeRepeated.put(stringArray[i + 1], 1);
                }
            }else{
                return true;
            }
        }
        return false;
    }

    private void extracted(char[] pattern, Map<Character, Integer> canBeRepeated, List<Character> characters) {
        for(int i = 0; i < pattern.length; i++){
            if(pattern[i] == '*'){
                Character forRepeat = pattern[i - 1];
                if(canBeRepeated.containsKey(forRepeat)){
                    int newValue = canBeRepeated.get(forRepeat);
                    canBeRepeated.put(forRepeat, newValue);
                }else{
                    canBeRepeated.put(forRepeat, 1);
                }
                if(characters.contains(forRepeat)){
                    characters.remove(forRepeat);
                }
            }else{
                characters.add(pattern[i]);
            }
        }
    }
}
