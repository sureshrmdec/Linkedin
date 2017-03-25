
/*

Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from A, B and C respectively such that max(abs(A[i] – B[j]), abs(B[j] – C[k]), abs(C[k] – A[i])) is minimized. Here abs() indicates absolute value.

Example :

Input: A[] = {1, 4, 10}
       B[] = {2, 15, 20}
       C[] = {10, 12}
Output: 10 15 10
10 from A, 15 from B and 10 from C

Input: A[] = {20, 24, 100}
       B[] = {2, 19, 22, 79, 800}
       C[] = {10, 12, 23, 24, 119}
Output: 24 22 23
24 from A, 22 from B and 23 from C


*/









public class Test {


	private static  int x;
	private static int y;
	private static int z;

	public static void main(String[] args) {
		int A[] = {20, 24, 100};
		int B[] = {2, 19, 22, 79, 800};
		int C[] = {10, 12, 23, 24, 119};

		getClose(A, B, C, 0, 0, 0);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}


	private static void getClose(int[] A, int[] B, int[] C, int i, int j, int k) {
		int min = Integer.MAX_VALUE;

		int max = Integer.MIN_VALUE;

		int diff = Integer.MAX_VALUE;

		while (i < A.length && j < B.length && k < C.length) {

			min = Math.min(A[i], Math.min(B[j], C[k]));

			max = Math.max(A[i], Math.max(B[j], C[k]));

			if (max - min < diff) {

				diff = max - min ;

				x = A[i];
				y = B[j];
				z = C[k];
			}

			if (A[i] == min) {
				i++;
			} else if (B[j] == min) {
				j++;
			} else {
				k++;
			}


		}

	}

}



void findClosest(int A[], int B[], int C[], int p, int q, int r)
{
 
    int diff = INT_MAX;  // Initialize min diff
 
    // Initialize result
    int res_i =0, res_j = 0, res_k = 0;
 
    // Traverse arrays
    int i=0,j=0,k=0;
    while (i < p && j < q && k < r)
    {
        // Find minimum and maximum of current three elements
        int minimum = min(A[i], min(B[j], C[k]));
        int maximum = max(A[i], max(B[j], C[k]));
 
        // Update result if current diff is less than the min
        // diff so far
        if (maximum-minimum < diff)
        {
             res_i = i, res_j = j, res_k = k;
             diff = maximum - minimum;
        }
 
        // We can't get less than 0 as values are absolute
        if (diff == 0) break;
 
        // Increment index of array with smallest value
        if (A[i] == minimum) i++;
        else if (B[j] == minimum) j++;
        else k++;
    }
 
    // Print result
    cout << A[res_i] << " " << B[res_j] << " " << C[res_k];
}
