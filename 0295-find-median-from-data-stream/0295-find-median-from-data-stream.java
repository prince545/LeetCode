import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
        PriorityQueue<Integer> upperHalf;


    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(lowerHalf.size()==0 || num<=lowerHalf.peek() ) lowerHalf.add(num);
        else upperHalf.add(num);


        if(lowerHalf.size()>upperHalf.size()+1) upperHalf.add(lowerHalf.remove());
        else if(upperHalf.size()>lowerHalf.size()) lowerHalf.add(upperHalf.remove());

        
    }
    
    public double findMedian() {
        if(lowerHalf.size()>upperHalf.size()) return lowerHalf.peek();
        return (lowerHalf.peek()+upperHalf.peek())/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */