Insertion Sort

https://www.youtube.com/watch?v=OGzPmgsI-pQ

array of size n starting with index 0.

for 1..n
  j = i -1
  while j>=0 and array[j] > array[i] //Move elements greater than current element to the right.
    array[j+1] = array[j]
    j = j - 1
  array[j+1] = array[i] // Move the current element to the right position
