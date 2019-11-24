Insertion Sort

https://www.youtube.com/watch?v=OGzPmgsI-pQ

array of size n starting with index 0.

for 1..n <br>
&nbsp;&nbsp;j = i -1 <br>
&nbsp;&nbsp;while j>=0 and array[j] > array[i] //Move elements greater than current element to the right. <br>
&nbsp;&nbsp;&nbsp;&nbsp;array[j+1] = array[j] <br>
&nbsp;&nbsp;&nbsp;&nbsp;j = j - 1 <br>
&nbsp;&nbsp;array[j+1] = array[i] // Move the current element to the right position <br>
