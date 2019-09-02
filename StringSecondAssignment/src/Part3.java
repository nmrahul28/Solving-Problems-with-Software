
public class Part3 {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        startIndex = dnaStr.indexOf("ATG");
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }
        }
        return dnaStr.length();
    }
    
    public String findGene(String dna, int where){
        int atgCodon = dna.indexOf("ATG", where);
        
        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int minCodon = 0;
        if (taaCodon == -1 ||
            (tgaCodon != -1 && tgaCodon < taaCodon)) {
                minCodon = tgaCodon;
            }
            else {
                minCodon = taaCodon;
            }
        if (minCodon == -1 ||
           (tagCodon != -1 && tagCodon < minCodon)){
               minCodon = tagCodon;
            }
        if (minCodon == -1) {
                return "No ending codon found";
            }
            
        return dna.substring(atgCodon, minCodon+3);
    }
    
    public void countGenes2(String dna){
        int startIndex = 0;
        while (true){
            String wholeGene = findGene(dna, startIndex);
            if (wholeGene.isEmpty()){
                break;
            }
            System.out.println("Gene found: " + wholeGene);
            startIndex = dna.indexOf(wholeGene,startIndex)+wholeGene.length();
        }
    }
      
    public void testCountGenes(){
        String dna= "aaaATGTAAGATGCCCTAGT";
        countGenes2(dna);
        
        dna= "ATGTAGATGTAAATGTAA";
        countGenes2(dna);
    }
}
