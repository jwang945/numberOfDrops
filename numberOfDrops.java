public class test{
    private static String numberOfDrops(String label, int limit) {
        int[] possChars = new int[26];
        for(int i = 0; i < label.length(); i++){
            possChars[label.charAt(i) - 97]++;
        }
        //now have array of num chars
        String retString = "";
        //want to start at 'largest' so from back
        for(int i = possChars.length-1; i >= 0; i--){
            int limitCounter = 0;
            while(possChars[i] > 0){
                retString += (char)(i+97);
                possChars[i]--;
                limitCounter++;
                if(possChars[i] > 0 && limitCounter == limit){
                    boolean found = false;
                    //want to find new next largest char and reset limitCounter
                    for(int j = i - 1; j >= 0; j--){
                        if(possChars[j] > 0){
                            limitCounter = 0;
                            possChars[j]--;
                            retString+= (char)(j+97);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        return retString;
                    }
                }
            }
        }
        return retString;
    }
    
    public static void main(String[] args) {
        String originalLabel = "abgddcllmzzpozzz";
        int charLimit = 2;
        System.out.println(numberOfDrops(originalLabel, charLimit));
    }
}