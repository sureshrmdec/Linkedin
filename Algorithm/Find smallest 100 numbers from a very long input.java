

1 
use priorityQueue (nlogk);

2 
use quickSelect(nk);

a1(1 - q^n) / 1 - q; 

n + 1/2n + 1/4n + 1/8n + ..... < 2n


array={...the billion numbers...} 
result[100];

pivot=QuickSelect(array,billion-101);//O(N)

for(i=0;i<billion;i++)//O(N)
   if(array[i]>=pivot)
      result.add(array[i]);



3 
If this is asked in an interview, I think the interviewer probably wants to see your problem solving process, 
not just your knowledge of algorithms.

The description is quite general so maybe you can ask him the range or meaning of these numbers to make the problem clear. 
Doing this may impress an interviewer. If, for example, these numbers stands for people's age of within a country (e.g. China),
then it's a much easier problem. With a reasonable assumption that nobody alive is older than 200, 
you can use an int array of size 200(maybe 201) to count the number of people with the same age in just one iteration. 
Here the index means the age. After this it's a piece of cake to find 100 largest number. By the way this algo is called counting sort.

Anyway, making the question more specific and clearer is good for you in an interview.
