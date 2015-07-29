/**
 * Eric Tam
 * 007989423
 * CS166
 * 2/12/2015
 */
public class RC4 {

    public static void main(String[] args) {
        int[] s = new int[256];
        int[] k = new int[256];
        byte[] key = new byte[] {0x1A, 0x2B, 0x3C, 0x4D, 0x5E, 0x6F, 0x77};
        int i = 0;
        //INITIALIZATION
        for(i = 0; i<256;i++){
            s[i] = i;
            k[i] = key[i%key.length];
        }
        int j = 0;
        for(i = 0; i<256; i++){
            j = (j + s[i] + k[i]) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        i=j=0;
        //*******************
        //PART A
        System.out.println("S after initialization, i="+i+", j="+j);
        for(int x = 0; x < 256; x = x+16){
            System.out.format("[0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, "
                    + "0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x]\n",s[x],s[x+1],s[x+2],s[x+3],s[x+4],s[x+5],s[x+6]
                    ,s[x+7],s[x+8],s[x+9],s[x+10],s[x+11],s[x+12],s[x+13],s[x+14],s[x+15]);
        }
        //*********************
        for(int x = 0; x<100;x++){
            i = (i+1)%256;
            j = (j+s[i])%256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        //PART B
        System.out.println("\nS after generating 100 bytes of keystream, i="+i+", j="+j);
        for(int x = 0; x < 256; x = x+16){
            System.out.format("[0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, "
                    + "0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x]\n",s[x],s[x+1],s[x+2],s[x+3],s[x+4],s[x+5],s[x+6]
                    ,s[x+7],s[x+8],s[x+9],s[x+10],s[x+11],s[x+12],s[x+13],s[x+14],s[x+15]);
        }
        //********************
        for(int x = 0; x<900;x++){
            i = (i+1)%256;
            j = (j+s[i])%256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        //PART B
        System.out.println("\nS after generating 1000 bytes of keystream, i="+i+", j="+j);
        for(int x = 0; x < 256; x = x+16){
            System.out.format("[0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, "
                    + "0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x]\n",s[x],s[x+1],s[x+2],s[x+3],s[x+4],s[x+5],s[x+6]
                    ,s[x+7],s[x+8],s[x+9],s[x+10],s[x+11],s[x+12],s[x+13],s[x+14],s[x+15]);
        }
        //********************

    }
}
