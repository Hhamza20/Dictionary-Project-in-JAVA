import java.util.*;

public class SpellChecker {
    DictReader Dict = new DictReader("C:\\Users\\DELL\\OneDrive - Higher Education Commission\\Desktop\\Semester 2 Material\\OOP\\Assignment No.2\\oop assignment\\spelling\\src\\words.txt");


    //Level 1
    public int noOfWords() {
        return Dict.getDictionary().size();
    }

    public boolean isKnownWord(String word) {
        for (String words : Dict.getDictionary()) {
            if (words.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean allKnown(ArrayList<String> words) {
        int k = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < Dict.getDictionary().size(); j++) {
                if (words.get(i).equals(Dict.getDictionary().get(j))) {
                    k++;
                }
            }
        }
        if (k == words.size()) {
            return true;
        } else {
            return false;
        }
    }


    //Level 2
    public ArrayList<String> wordsStartingWith(String prefix) {
        ArrayList<String> al = new ArrayList<>();
        for (String word : Dict.getDictionary()) {
            if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
                al.add(word);
            }
        }
        return al;
    }

    public ArrayList<String> wordsContaining(String text) {
        ArrayList<String> al = new ArrayList<>();
        for (String check : Dict.getDictionary()) {
            if (check.toLowerCase().contains(text.toLowerCase())) {
                al.add(check);
            }
        }
        return al;
    }

    //Level 3

    public void insert(String newWord) {
        for (String word : Dict.getDictionary()) {
            if (newWord.equals(word)) {
                return;
            }
        }
        Dict.getDictionary().add(newWord);
        Collections.sort(Dict.getDictionary(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        System.out.println(newWord + " inserted Successfully");
    }

    public boolean remove(String newWord) {
        Iterator<String> it = Dict.getDictionary().iterator();
        while (it.hasNext()) {
            if (it.next().equals(newWord)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void save() {
        Dict.save(Dict.getDictionary());
    }


    //Challenge Tasks:
    public boolean isPalindrome(String word) {
        for (String i : Dict.getDictionary()) {
            if (i.toLowerCase().equals(word.toLowerCase())) {
                char[] newWord = new char[i.length()];
                int j = 0;
                int k = i.length() - 1;
                while (j < i.length() && k >= 0) {
                    newWord[j] = i.charAt(k);
                    j++;
                    k--;
                }
                String reversedWord = new String(newWord);
                if (i.toLowerCase().equals(reversedWord.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> anagrams(String word) {
        ArrayList<String> al = new ArrayList<>();
        char[] arr1 = word.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        String sor1 = new String(arr1);

        for (int i = 0; i < Dict.getDictionary().size(); i++) {
            char[] arr = Dict.getDictionary().get(i).toLowerCase().toCharArray();
            Arrays.sort(arr);
            String sor2 = new String(arr);
            if (sor2.equals(sor1)) {
                al.add(Dict.getDictionary().get(i));
            }
        }
        if (al.size() != 0) {
            al.remove(0);
        }
        return al;
    }

    public ArrayList<String> difference(ArrayList<String> dictionary) {
        ArrayList<String> al = new ArrayList<>();
        for (String a : Dict.getDictionary()) {
            if (!(dictionary.contains(a))) {
                al.add(a);
            }
        }
        for (String a : dictionary) {
            if (!(Dict.getDictionary().contains(a))) {
                al.add(a);
            }
        }
        return al;
    }


    public static void main(String[] args) {
        SpellChecker S1 = new SpellChecker();

        //Test Cases:

        System.out.println("public int numberOfWords()");
        System.out.println("Test Case 1:");
        System.out.println("Number of words in the dictionary are: "+ S1.noOfWords());
        System.out.println("Test Case 2:");
        S1.insert("oop");
        System.out.println("Number of words after addition of new word \"oop\" are: "+ S1.noOfWords());


        System.out.println("\npublic boolean isKnownWord(String word)");
        System.out.println("Test Case 1:");
        System.out.println("Is \"oop\" an known word? "+ S1.isKnownWord("oop"));
        System.out.println("Test Case 2:");
        System.out.println("Is \"OOP\" an known word? "+ S1.isKnownWord("OOP"));


        System.out.println("\npublic boolean allKnown(ArrayList<String> words)");
        System.out.println("Test Case 1:");
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("oop");
        al1.add("aam");
        System.out.println("Are \"oop\" and \"aam\" known words? "+S1.allKnown(al1));
        System.out.println("Test Case 2:");
        al1.add("Aam");
        System.out.println("Is \"Aam\" a known word? "+S1.allKnown(al1));


        System.out.println("\npublic ArrayList<String> wordsStartingWith(String prefix)");
        System.out.println("Test Case 1:");
        System.out.println("Words starting with \"photo\" are: "+S1.wordsStartingWith("photo"));
        System.out.println("Test Case 2:");
        System.out.println("Words starting with \"PHOTO\" are: "+S1.wordsStartingWith("PHOTO"));


        System.out.println("\npublic ArrayList<String> wordsContaining(String text)");
        System.out.println("Test Case 1:");
        System.out.println("Words containing word \"photo\" are: "+S1.wordsContaining("photo"));
        System.out.println("Test Case 2:");
        System.out.println("Words containing word \"PHOTO\" are: "+S1.wordsContaining("PHOTO"));


        System.out.println("\npublic void insert(String newWord)");
        System.out.println("Test Case 1:");
        S1.insert("aan");


        System.out.println("\npublic boolean remove(String newWord)");
        System.out.println("Test Case 1:");
        System.out.println("Removing word \"aan\": "+S1.remove("aan"));
        System.out.println("Test Case 2:");
        System.out.println("Removing word \"lolopopoyokohama\": "+S1.remove("lolopopoyokohama"));


        System.out.println("\npublic boolean isPalindrome(String word)");
        System.out.println("Test Case 1:");
        System.out.println("Is the word \"rotator\" in the dictionary and palindrome? : "+S1.isPalindrome("rotator"));
        System.out.println("Test Case 2:");
        System.out.println("Is the word \"navan\" in the dictionary and palindrome? : "+S1.isPalindrome("navan"));


        System.out.println("\npublic ArrayList<String> anagrams(String word)");
        System.out.println("Test Case 1:");
        S1.insert("opo");
        S1.insert("poo");
        System.out.println("Anagrams of word \"oop\" in the dictionary are: "+S1.anagrams("oop"));
        System.out.println("Test Case 2:");
        System.out.println("Anagrams of word \"ooop\" in the dictionary are: "+S1.anagrams("ooop"));
    }
}
