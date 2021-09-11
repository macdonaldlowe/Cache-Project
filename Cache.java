import java.util.*;

//Use import linked list
//This will be a generic type file 
public class Cache<T> {

    private Boolean isSecond = false;
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
    this.isSecond = true;
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

public void addObjectSecond(T object){
    if(secondCache.size() >= size){
        secondCache.removeLast();
    }
    secondCache.addFirst(object);
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

//removeObject
public void removeObjectFirst(T object){
    for(T item : firstCache){
        if(item.equals(object)){
            firstCache.remove(item);
        }
    }
}

public void removeObjectSecond(T object){
    for(T item : firstCache){
        if(item.equals(object)){
            firstCache.remove(item);
        }
    }
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


}

