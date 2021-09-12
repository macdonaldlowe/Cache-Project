import java.util.*;
import java.text.DecimalFormat;

//Use import linked list
//This will be a generic type file 
public class Cache<T> {

    private static DecimalFormat df = new DecimalFormat("0.0000");
    private int size;
    private int secondSize;
    private LinkedList<T> firstCache;
    private LinkedList<T> secondCache;
    private int firstCacheHits = 0;
    private int firstCacheReferences = 0;
    private int secondCacheHits = 0;
    private int secondCacheReferences = 0;

//Constructor for single cache - takes in size 
public Cache(int size){
    firstCache = new LinkedList<T>();
    this.size = size;
}
//Constructor for double cache - takes in size
public Cache(int size, int secondSize){
    firstCache = new LinkedList<T>();
    secondCache = new LinkedList<T>();
    this.size = size;
    this.secondSize = secondSize;
}

//addObject
public void addObjectFirst(T object){
    if(firstCache.size() >= size){
        firstCache.removeLast();
    }
    firstCache.addFirst(object);
}

public void moveToTop(T object){
    removeObjectFirst(object);
    addObjectFirst(object);
}

public void addObjectSecond(T object){
    if(secondCache.size() >= secondSize){
        secondCache.removeLast();
    }
    secondCache.addFirst(object);
}

public boolean hasObjectFirst(T object){
    return firstCache.contains(object);
}

public boolean hasObjectSecond(T object){
    return secondCache.contains(object);
}

//getObject - returns null if not found
public T getObjectFirst(T object){
    for(T item : firstCache){
        if(item.equals(object)){
            return object;
        }
    }
    return null;
}

//getObjectSecond - returns null if not found
public T getObjectSecond(T object){
    for(T item : secondCache){
        if(item.equals(object)){
            return object;
        }
    }
    return null;
}

public void removeObjectFirst(T object){
    firstCache.remove(object);
}

public void removeObjectSecond(T object){
    secondCache.remove(object);
}
//clearCache
public void clearCacheFirst(){
    firstCache.clear();
}

public void clearCacheSecond(){
    secondCache.clear();
}

public String toStringFirst(){
    String outputString = "";
    for(T item : firstCache){
        outputString += item.toString() + " ";
    }
    return outputString;
}

public String toStringSecond(){
    String outputString = "";
    for(T item : secondCache){
        outputString += item.toString() + " ";
    }
    return outputString;
}

//methods for hit ratios getting and setting

public void incrementFirstCacheHits(){
    firstCacheHits++;
}

public int getFirstCacheHits(){
    return firstCacheHits;
}

public void incrementFirstCacheReferences(){
    firstCacheReferences++;
}

public int getFirstCacheReferences(){
    return firstCacheReferences;
}

public void incrementSecondCacheHits(){
    secondCacheHits++;
}

public int getSecondCacheHits(){
    return secondCacheHits;
}

public void incrementSecondCacheReferences(){
    secondCacheReferences++;
}

public int getSecondCacheReferences(){
    return secondCacheReferences;
}

public void toStringFirst(Cache<T> cache, String args1, Long startTime){
    int totalReferences = cache.getFirstCacheReferences() + cache.getSecondCacheReferences();
    int totalHits = cache.getFirstCacheHits() + cache.getSecondCacheHits();
    double globalHitRatio = (double)totalHits / totalReferences;

    

    System.out.println("First level cache with " + args1 + "entries has been created" );
    System.out.println("................................");
    System.out.println("Total number of references:        " + totalReferences);
    System.out.println("Total number of cache hits:        " + cache.getFirstCacheHits()); //used to be totalHits
    System.out.println("The global hit ratio:              " + df.format(globalHitRatio));
   
    Long timeTaken = System.currentTimeMillis() - startTime;
    System.out.println("Time elapsed: " + timeTaken + " milliseconds");
}

public void toStringBoth(Cache<T> cache, String args1, String args2, Long startTime){
    int totalReferences = cache.getFirstCacheReferences();
    int totalHits = cache.getFirstCacheHits() + cache.getSecondCacheHits();
    double globalHitRatio = (double)totalHits / totalReferences;

    double firstCacheHitRatio = (double)cache.getFirstCacheHits() / cache.getFirstCacheReferences();
    double secondCacheHitRatio = (double)cache.getSecondCacheHits() / cache.getSecondCacheReferences();

    System.out.println("First level cache with " + args1 + "entries has been created" );
    System.out.println("Second level cache with " + args2 + "entries has been created" );
    System.out.println("................................");
    System.out.println("Total number of references:        " + totalReferences);
    System.out.println("Total number of cache hits:        \n" + totalHits);
    System.out.println("The global hit ratio:              \n" + df.format(globalHitRatio));
    System.out.println("");
    System.out.println("Number of 1st-level cache references:" + cache.getFirstCacheReferences());
    System.out.println("Number of 1st-level cache hits:    " + cache.getFirstCacheHits());
    System.out.println("1st-level cache hit ratio:         " + df.format(firstCacheHitRatio));
    System.out.println("");
    System.out.println("Number of 2nd-level cache references:" + cache.getSecondCacheReferences());
    System.out.println("Number of 2nd-level cache hits:     " + cache.getSecondCacheHits());
    System.out.println("2nd-level cache hit ratio:         " + df.format(secondCacheHitRatio));
    
    Long timeTaken = System.currentTimeMillis() - startTime;
    System.out.println("Time elapsed: " + timeTaken + " milliseconds");
}

}

