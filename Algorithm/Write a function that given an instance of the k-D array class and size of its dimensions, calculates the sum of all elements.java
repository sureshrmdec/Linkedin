/** Suppose you are given a class that implements a k-dimensional array 
* interface and you want to perform an operation that requires you to 
* iterate over all elements of the array using its indices. To be 
* specific, let's assume we want to calculate the sum of all elements in 
* the array. The interface only provides you a get(int[]) method which
* allows one to fetch the element at that location given the indices along
* each dimension.
* 
* For e.g, suppose we are dealing with 4D arrays, given [2, 1, 3, 0], the 
* class will provide you array[2][1][3][0].
* Write a function that given an instance of the k-D array class and size 
* of its dimensions, calculates the sum of all elements.
*
* @param instance of MultiDimArray class that implements a k-D array of 
*        ints which provides a method x.get(int[]) to get the element
*        located at the indices in the array
* @param array of ints stating the size of each dimension of the k-D array
* @return an int which is the sum of all elements in the k-D array.
*
* example: Given object m that holds a 2x2x3 array .
* a=[[[3, 2, 2], [1, 5, 0]], [[2, 0, 1], [1, 1, -2]]] (Only for illustration
* purposes. This need not be the internal implementation of our k-D array) 
* the function call arraySum(m, [2, 2, 3]) should return 16 
* (=3+2+2+1+5+2+1+1+1-2)
*/

public List<int[]> getAllIndex (int[] dimensions) {-google 1point3acres
                List<int[]> result = new ArrayList<int[]>();
                int[] index = new int[dimensions.length];
                helper(result, index, 0, dimensions);
                return result;
        }
        private void helper(List<int[]> result, int[] index, int depth, int[] dimensions) {
                if (depth == dimensions.length) {
                        result.add(index.clone());
                        return;
                }
                int currentDimension = dimensions[depth];
                for (int i=0; i<currentDimension; i++) {
                        index[depth] = i;
                        helper(result, index, depth+1, dimensions);
                }
        }
