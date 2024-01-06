import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the file to compress: ");
        String filePath = scanner.nextLine();
        scanner.close();
        

        try{
            String originalData = MyFileReader.readFile(filePath);
            
            //Compressing data
            HuffmanTree huffmanTree = new HuffmanTree();
            HuffmanNode root = huffmanTree.buildHuffmanTree(originalData);
            
            HuffmanCoding huffmanCoding = new HuffmanCoding();
            huffmanCoding.generateHuffmanCode(root, "");

            String compressedData = huffmanCoding.compress(originalData);

            //Save compressed file
            String compressedFilePath = filePath + ".compressed";
            MyFileReader.writeFile(compressedFilePath, compressedData);
            System.out.println("Compressed data saved to: " + compressedFilePath);

            //Decompressing Data
            String decompressedData = huffmanCoding.decompress(compressedData, root);

            //Save decompressed file
            String decompressedFilePath = filePath + ".decompressed";
            MyFileReader.writeFile(decompressedFilePath, decompressedData);
            System.out.println("Decompressed data saved to: " + decompressedFilePath);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
