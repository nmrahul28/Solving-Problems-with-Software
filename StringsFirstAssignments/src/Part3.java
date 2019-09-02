
public class Part3 {
	public boolean twoOccurances(String stringa, String stringb) {
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

		    lastIndex = stringa.indexOf(stringb,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += stringb.length();
		    }
		}
		if(count>=2) {
			return true;
		}
		else {
			return false;
		}
	}
	public String lastPart(String stringa, String stringb) {
		int index=stringb.indexOf(stringa);
		if(index!=-1) {
			return stringb.substring(index+stringa.length());
		}
		else {
			return stringb;
		}
	}
	public void testing() {
		System.out.println(twoOccurances("aatgcctatgtaa", "atg"));
		System.out.println(twoOccurances("aatgaactgtaa","taa"));
		System.out.println(lastPart("an", "banana"));
		System.out.println(lastPart("zoo", "forest"));
	}

}
