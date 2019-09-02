
public class Part2 {
	public String findSimpleGene(String dna, String start_Codon, String stop_Codon) {
		dna=dna.toLowerCase();
		start_Codon=start_Codon.toLowerCase();
		stop_Codon=stop_Codon.toLowerCase();
		int startCodon=dna.indexOf(start_Codon);
		if(startCodon==-1) {
			return "";
		}
		int stopCodon =dna.indexOf(stop_Codon, startCodon+3);
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
		System.out.println(findSimpleGene("CCTAGTAA","ATG", "TAA"));
		System.out.println(findSimpleGene("AATGACCCCTATAA","ATG", "TAA"));
		System.out.println(findSimpleGene("AATGCCTACCTAAATC","ATG", "TAA"));
		System.out.println(findSimpleGene("AATGACCACGACTAA","ATG", "TAA"));
//		System.out.println(findSimpleGene("A"))
	
	}
}
