package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] newArray = new String[0];
        Integer nextUniqueInt = 0;
        for (int i = 0; i < array.length; i+=nextUniqueInt){
            Integer elementCounter = 1;
            for(int j = i+1; j<array.length; j++ ){
                if(array[i].equals(array[j])){
                    elementCounter++;
                    nextUniqueInt = elementCounter;
                }
                if ((!array[i].equals(array[j])) || j == array.length-1){
                    nextUniqueInt = elementCounter; //append to where to jump in i-loop next
                    if(elementCounter<maxNumberOfDuplications){ //counted elements less than allowable amount; keep the elements
                        for(int k = i; k<i+elementCounter; k++){
                            newArray = addArray(newArray,array[k]);
                        }
                        break;
                    }
                    break;
                }
            }
        }
        return newArray;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] newArray = new String[0];
        Integer nextUniqueInt = 0;
        for (int i = 0; i < array.length; i+=nextUniqueInt){
            Integer elementCounter = 1;
            for(int j = i+1; j<array.length; j++ ){
                if(array[i] == array[j]){
                    elementCounter++;
                    nextUniqueInt = elementCounter;
                }
                if ((!array[i].equals(array[j])) || j == array.length-1){
                    nextUniqueInt = elementCounter; //append to where to jump in i-loop next
                    if(elementCounter!=exactNumberOfDuplications){ //counted elements less than allowable amount; keep the elements
                        for(int k = i; k<i+elementCounter; k++){ //add everything counted into new array
                            newArray = addArray(newArray,array[k]);
                        }
                        break;
                    }
                    break;
                }
            }
        }
        return newArray;
    }

    public String[] addArray(String[] existingArray, String valueToAdd){
        String[] newerArray = new String[existingArray.length+1];
        System.arraycopy(existingArray,0,newerArray,0,existingArray.length);
        newerArray[existingArray.length] = valueToAdd;
        return newerArray;
    }
}
