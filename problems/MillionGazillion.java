import java.util.HashMap;
import java.util.Map;

class MillionGazillion {
    private Map<Character,Map> visited;

    public MillionGazillion () {
        this.visited = new HashMap<Character,Map>();
    }

    public boolean hasURL (String url) {
        Map<Character,Map> currentMap = visited;

        for (int i = 0; i < url.length(); i++) {
            Character ch = new Character(url.charAt(i));
            Map<Character,Map> next = currentMap.get(ch);

            if (next != null) {
                currentMap = next;
            } else {
                String restOfURL = url.substring(i);
                addResetOfURL (restOfURL, currentMap);
                return false;
            }

        }

        return true;
    }

    private void addResetOfURL (String url, Map<Character,Map> map) {
        Map<Character,Map> currentMap = map;

        for (int i = 0; i < url.length(); i++) {
            Character ch = new Character(url.charAt(i));
            Map<Character, Map> newMap = new HashMap<Character, Map>();
            currentMap.put(ch, newMap);
            currentMap = newMap;
        }

    }


    public static void main(String[] args) {

        MillionGazillion crawler = new MillionGazillion();
        boolean hasHelloWorld = crawler.hasURL("helloworld");
        boolean hasHello = crawler.hasURL("hello");
        boolean hasHelloArthur = crawler.hasURL("helloarthur");
        boolean hasHelloWorld2 = crawler.hasURL("helloworld");


        System.out.println(hasHelloWorld);
        System.out.println(hasHello);
        System.out.println(hasHelloArthur);
        System.out.println(hasHelloWorld2);



    }
}