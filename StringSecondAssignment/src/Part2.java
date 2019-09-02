
public class Part2 {
	public int howMany(String stringa, String stringb){
        int count = 0;
        int firstOccur = stringb.indexOf(stringa);
        if (firstOccur > -1) {
            count = count+1;
        
        
        while (stringb.indexOf(stringa, firstOccur) != -1 && firstOccur != -1) {
            count = count +1;
            firstOccur = stringb.indexOf(stringa, firstOccur+stringa.length());
        }
        count = count -1;
        }
        else {
            count=0;
        }
        return count;
    }
    public void testHowMany(){
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Count is: " + howMany(stringa,stringb));
        }
        stringa = "AA";
        stringb = "ATABABAB";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Count is: " + howMany(stringa,stringb));
        }

        }
}
