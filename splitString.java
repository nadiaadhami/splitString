//Goal: split a string into dictionary words.
//1. The entire string must be consumed.
//2. Break the string into exactly two words.
//3. If more than one split is possible, return any one (or all) of the valid splits.
//4. If no split is possible, return something that distinguishes it from the case where there is a valid split.

//dictionary: a rock rocks star stars tar


//rock => rock
//rockstar    => "rock" "star" OR "rocks" "tar"
//zebra       => no valid split
//rockstartar => no valid split  “rock” star tar | rocks tar tar
aa


public class NadiaWordFinder {

    private final List<String> myDictionary = getDictionary();

    public static void main(String[] args) {

        String[] testWords = {"","a","rockstar","arockstar","rockstartar","arockstartarzebra","google","googlerockstar","googlerocks","good"};

        NadiaWordFinder wordFinder = new NadiaWordFinder();

        // my first solution
        for (String word : testWords) {
            Set<String> words = wordFinder.splitToTwoWords(word);
            //print the dictionary words found
            System.out.println(word + " =>");
            if (words == null) {
                System.out.println("no match found in the dictionary");
            } else
                for (String w : words) {
                    System.out.println(w);
                }
        }

        System.out.println("\n\n****** RECURSIVE ******");

        // my recursive solution
        for (String word : testWords) {
            Set<String> words2 = wordFinder.recursiveSplitWords(word);
            System.out.println(word+" =>");
            if (words2 == null) {
                System.out.println("no match found in the dictionary");
            } else {
                for (String w : words2) {
                    System.out.println(w);
                }
            }
        }
    }

    public Set<String> splitToTwoWords(String word) {
        Set<String> set= new HashSet<String>();
        List<String> myDictionary = getDictionary();
        String s1,s2;

        if (word == null || word.length() == 0) {
            return set;
        }
        if (word.length() == 1) {
            if (myDictionary.contains(word)) {
                set.add(word);
                return set;
            }
        }
        for (int i = 0;  i < word.length() - 1 ; i++) {
            s1 = word.substring(0,i+1);
            s2 = word.substring(i + 1);
            if (myDictionary.contains(s1) &&
                    myDictionary.contains(s2)) {
                set.add(s1);
                set.add(s2);
                break;
            }
        }
        return set;
    }
    public Set<String> recursiveSplitWords(String word) {
        if (word == null) {
            return null;
        }
        if (myDictionary.contains(word)) {
            Set<String> set = new HashSet<String>();
            set.add(word);
            return set;
        }
        for (int i = 0;  i < word.length() - 1 ; i++) {
            String s1 = word.substring(0,i+1);
            String s2 = word.substring(i + 1);
            Set<String> set1 = recursiveSplitWords(s1);
            Set<String> set2 = recursiveSplitWords(s2);

            if (set1 != null && !set1.isEmpty() && set2 != null && !set2.isEmpty()) {
                //join the sets
                set1.addAll(set2);
                return set1;
            }
        }
        return null;
    }
    public List<String> getDictionary() {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("a");
        dictionary.add("rock");
        dictionary.add("star");
        dictionary.add("tar");
        dictionary.add("zebra");
        dictionary.add("google");
        return dictionary;
    }

}



