
def untilfindpeak(array,front,end,n):
  
  mid = (front + end)/2
  mid = int(mid)
  
  if (mid==0) or (mid == n-1):
    return mid
  if array[mid]>=array[mid-1] and array[mid] >= array[mid+1]:
    return mid 
  elif mid>0 and array[mid-1]>array[mid]:
    return untilfindpeak(array,front,mid-1,n)
  else:
    return untilfindpeak(array,mid+1,end,n)

def peakfinder(array,n):
  return untilfindpeak(array,0,n-1,n)

