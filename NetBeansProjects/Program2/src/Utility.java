/**
 *  Find largest maximal clique
 *  CS146
 *  Section 4
 *  Eric Tam
 */
public class Utility {

    static boolean[] findMaximalClique(Graph g){
        boolean[] answers = new boolean[g.size()];
        int i;
        int count = 0;
        Graph temp;
        for(i = answers.length; i > 0; i--){
            if(g.hasClique(i)) break;
        }
        for(int j = 0; j<answers.length; j++){
            temp = g.removeVertex(j-count);
            if(temp.hasClique(i)) {
                g = temp;
                count++;
            }
            else answers[j] = true;
            if(g.size()<i) break;
        }
        return answers;
    }

}
