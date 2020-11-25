package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] newArray = new Integer[0];
        Integer nextUniqueInt = 0;
        for (int i = 0; i < array.length; i+=nextUniqueInt){
            Integer elementCounter = 1;
            for(int j = i+1; j<array.length; j++ ){
                if(array[i] == array[j]){
                    elementCounter++;
                    nextUniqueInt = elementCounter;
                }
                if (array[i] != array[j] || j == array.length-1){
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

    public Integer[] addArray(Integer[] existingArray, Integer valueToAdd){
        Integer[] newerArray = new Integer[existingArray.length+1];
        System.arraycopy(existingArray,0,newerArray,0,existingArray.length);
        newerArray[existingArray.length] = valueToAdd;
        return newerArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] newArray = new Integer[0];
        Integer nextUniqueInt = 0;
        for (int i = 0; i < array.length; i+=nextUniqueInt){
            Integer elementCounter = 1;
            for(int j = i+1; j<array.length; j++ ){
                if(array[i] == array[j]){
                    elementCounter++;
                    nextUniqueInt = elementCounter;
                }
                if (array[i] != array[j] || j == array.length-1){
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
}
