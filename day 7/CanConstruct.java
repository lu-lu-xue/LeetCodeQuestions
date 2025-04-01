import java.util.Map;
import java.util.HashMap;

class canConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || magazine.isEmpty() || magazine.length() < ransomNote.length()){
            return false;
        }

        int[] record = new int[26];
        for (char c: magazine.toCharArray()){
            record[c - 'a']++;
        }

        for (char c: ransomNote.toCharArray()){
            record[c - 'a']--;
        }

        for (int num: record){
            if (num < 0){
                return false;
            }
        }

        return true;
    }


    // method 2
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine == null || magazine.isEmpty() || magazine.length() < ransomNote.length()){
            return false;
        }

        Map<Character, Integer> mapOfMag = new HashMap<>();
        for (char c: magazine.toCharArray()){
            mapOfMag.put(c, mapOfMag.getOrDefault(c, 0) + 1);
        }

        for (char c: ransomNote.toCharArray()){
            if (!mapOfMag.containsKey(c)){
                return false;
            } else if (mapOfMag.get(c) == 0){
                return false;
            } else {
                mapOfMag.put(c, mapOfMag.get(c) - 1);
            }
        }

        return true;
    }
}