package com.clay;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class TheRansomLetter {
    public static void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.println(new TheRansomLetter().canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character magazineChar = magazine.charAt(i);
            if (i < ransomNote.length()){
                Character ransomNoteChar = ransomNote.charAt(i);
                if (!ransomNoteMap.containsKey(ransomNoteChar)){
                    ransomNoteMap.put(ransomNoteChar,1);
                }else {
                    Integer ransomNoteCount = ransomNoteMap.get(ransomNoteChar);
                    ransomNoteCount++;
                    ransomNoteMap.put(ransomNoteChar,ransomNoteCount);
                }
            }
            if (!magazineMap.containsKey(magazineChar)){
                magazineMap.put(magazineChar,1);
            }else {
                Integer magazineCount = magazineMap.get(magazineChar);
                magazineCount++;
                magazineMap.put(magazineChar,magazineCount);
            }
        }
        for (Character character : ransomNoteMap.keySet()) {
            if (!magazineMap.containsKey(character)){
                return false;
            }else {
                if (magazineMap.get(character) < ransomNoteMap.get(character)){
                    return false;
                }
            }
        }
        return true;
    }
}
