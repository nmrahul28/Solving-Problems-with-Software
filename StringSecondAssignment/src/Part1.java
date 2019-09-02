
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
        }
        return dna.length();
    }
    public String findGene(String dna){
        int atgCodon = dna.indexOf("ATG");
        
        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int tempCodon = Math.min(taaCodon, tagCodon);
        int dnaFin = Math.min(tempCodon, tgaCodon);
        if (dnaFin == dna.length()) {
            return "NO GENE FOUND";
        }
        return dna.substring(atgCodon, dnaFin+3);
    }
    public void testFindGene(){
        String dna= "AGDEGAASZZATAAGG";
        System.out.println("The dna string is :" + dna);
        String gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "AACGSATGAAGCATTAGAACTA";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "AACGTAATGAACTBATAGTTATGAACG";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
        
        dna= "AAGTAATGAATACAAAAGTTT";
        System.out.println("The dna string is :" + dna);
        gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
    }
    public void prrintAllGenes(){
       String dna = "AGDEGAASZZATAAAAA";
        while (true) {
            System.out.println("printing genes" + findGene(dna));
            if (findGene(dna)=="NO ATG CODON FOUND" || findGene(dna)=="NO GENE FOUND") {
                break;
            }
        }   
    }
}
