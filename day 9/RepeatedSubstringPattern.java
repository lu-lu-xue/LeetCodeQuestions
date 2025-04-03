
class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // remove the first and the last
        String sub = doubled.substring(1, doubled.length() - 1);

        // this way is more efficient ???
        return sub.contains(s);

        // return isSub(sub, s);
    }
}
