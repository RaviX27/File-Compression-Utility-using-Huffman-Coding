import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private PriorityQueue <HuffmanNode> minHeap;

    public HuffmanTree(){
        minHeap = new PriorityQueue<>((a,b) -> a.frequency - b.frequency);
    }

    public void BuildHuffmanTree(String data){
        Map <Character , Integer> freqMap = countFrequencies(data);

        buildPriorityQueue(freqMap);

        return buildTree;
    }


    
}
