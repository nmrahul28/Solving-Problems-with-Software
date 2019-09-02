
public class Part1 {
	public String findSimpleGene(String dna) {
		int startCodon=dna.indexOf("ATG");
		if(startCodon==-1) {
			return "";
		}
		int stopCodon =dna.indexOf("TAA", startCodon+3);
		if(stopCodon==-1) {
			return "";
		}
		if((stopCodon-startCodon)%3==0) {
			return dna.substring(startCodon, stopCodon+3);
		}
		else {
			return "";
		}
	}
	public void testSimpleGene() {
		System.out.println(findSimpleGene("CCTAGTAA"));
		System.out.println(findSimpleGene("AATGACCCCTATAA"));
		System.out.println(findSimpleGene("AATGCCTACCTAAATC"));
		System.out.println(findSimpleGene("AATGACCACGACTAA"));
//		System.out.println(findSimpleGene("A"))
	
	}
	

}
