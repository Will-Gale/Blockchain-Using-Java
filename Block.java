import java.util.Date;
import java.security.MessageDigest; //provides access to the SHA256 Algorithm


public class Block {
    
    public String hash;
	public String pHash;
	private String data; //The string data will contain a message
	private long timeStamp; //As number of milliseconds since 1/1/1970.

	//Block Constructor.
	public Block(String data, String previousHash) {
        
        this.data = data;
		this.pHash = previousHash;
        this.timeStamp = new Date().getTime();
        
        //calcHash method 
        this.hash = calcHash(); //Making sure we do this after we set the other values. 

    }
    
    public String calcHash() {

        int minRange = 1;
        int maxRange = 999999;

        StringUtility sUtil = new StringUtility();

        String numHash = String.valueOf(Math.random() * (maxRange - minRange + 1) + minRange); //Generating a "random" number between the range of 1 - 999999.

        //Creating each individual digital signature
        String calcHash = sUtil.shaAlgorithm(pHash + Long.toString(timeStamp) + data + numHash);

        return calcHash;

    }

}
