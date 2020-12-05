import java.util.ArrayList;

//Java library created by google that enables you to get a JSON representation of a Java Object
import com.google.gson.*;

/*

    William Gale / December 4th, 2020

    Created my own Blockchain in java using hashing
    and array lists to create blocks of data with
    unique digital signatures that chain each block
    together. The Blockchain objects are then displayed 
    in JSON format.

*/

public class BlockChain {
    
    //Store created blocks in this array list, 
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); //Refresh knowledge on array lists

    public static void main(String[] args) {
        
        //add our blocks to the blockchain ArrayList:
		blockchain.add(new Block("Added 1st block", "0"));		
		blockchain.add(new Block("Added 2nd block", blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("Added 3rd block", blockchain.get(blockchain.size()-1).hash));

        //Converting the block object to JSON format using the GSON library
        String bcJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(bcJSON);

    }

    public static void blockHashTest(){

        //Three quick tests to see if the hashing is working
        Block testBlock1 = new Block("First Block test", "0");
        System.out.println("First Test Block : " + testBlock1.hash);

        Block testBlock2 = new Block("Second Block test", "1");
        System.out.println("Second Test Block: " + testBlock2.hash);

        Block testBlock3 = new Block("Third Block test", "2");
        System.out.println("Third Test Block : " + testBlock3.hash);

    }

}
