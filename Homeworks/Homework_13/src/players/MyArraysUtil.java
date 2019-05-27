package players;

class MyArraysUtil {
	private MyArraysUtil() {}
	
	public static int addElement(Object objects[], Object object, int currentCountElements) {
		if (objects.length == currentCountElements) {
			//System.err.println("Massive is fulled!");
			return -1;
		} else {
			objects[currentCountElements++] = object;	
			//System.out.println("Element is added!");
			return currentCountElements;					
		} 
	} 
	
	public static int getIndex(Object objects[], Object object, int currentCountElements) {
		for (int i = 0; i < currentCountElements; i++) {
			if (objects[i] == object) {
				return i;
			}
		} 		
		return -1;
	}
	
	private static int removeByIndex(Object objects[], Object object, int currentCountElements, int removeIndex) {
		if ((removeIndex < currentCountElements) && (removeIndex >= 0)) {
			for (int i = removeIndex; i < (currentCountElements - 1); i++) {
				objects[i] = objects[i + 1];	
			} 				
			currentCountElements--;			
			return currentCountElements;
		}
		return -1;
	}	
	
	public static int removeElement(Object objects[], Object object, int currentCountElements) {
		int index = getIndex(objects, object, currentCountElements);
		if (index >= 0) {
			while (index >= 0) {
				currentCountElements = removeByIndex(objects, object, currentCountElements, index);
				index = getIndex(objects, object, currentCountElements);
				//System.out.println("Element is removed!");			
			}
			return currentCountElements;
		} else {
			return -1;
		}	
	} 
}