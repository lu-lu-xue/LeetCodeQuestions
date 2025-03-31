class IsAnagram {
    public static boolean isAnagram (String s, String t){
        // corner case
        if (s == null || t == null){
            return false;
        }

        if (s.length() != t.length()){
            return false;
        }

        // number of chars: 26
        int[] record = new int[26];
        for (char c: s.toCharArray()){
            record[c - 'a']++;
        }

        for (char c: t.toCharArray()){
            record[c - 'a']--;
        }

        // if they are the same, 
        // the diff in each cell would be 0s
        for (int diff: record){
            if (diff != 0){
                return false;
            }
        }

        return true;
    }
}