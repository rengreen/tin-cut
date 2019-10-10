# Minimum Cost to of cutting tin into squares
Altrnative solution to problem from www.geeksforgeeks.org/minimum-cost-cut-board-squares/

A board (tin) of length m and width n is given, we need to break it into m*n squares such that cost of breaking is minimum. Cutting cost for each edge will be given for the board. In short we need to choose such a sequence of cutting that toatal cost is minimized.

![step 0](images/step0.png)
Cuts are made starting from the most expensive, with the vertical and horizontal cuts being mixed up.
# 
![step 1](images/step1.png)  
# 
![step 2](images/step2.png)
# 
![step 3](images/step3.png)
# 
![step 4](images/step4.png)
# 
![step 5](images/step5.png)
# 
![step 6](images/step6.png)
# 
![step 7](images/step7.png)
# 
![step 8](images/step8.png)

## total cost=42

# Cutting
Fragment before cutting:  
```Fragment(startX, startY, dimX, dimY));```

Two fragments after vertical cutting at cutPosition:  
```Fragment(startX, startY, cutPosition, dimY));```  
```Fragment(cutPosition + 1, startY, endX - cutPosition, dimY));``` 

![before cutting](images/cut0.png)
#  
![after cutting - fragment 1](images/cut1.png)
```startX = startX = 1;```  
```startY = startY = 1;```  
```dimX = cutPosition = 5;```  
```dimY = dimY = 4;```
# 
![after cutting - fragment 2](images/cut2.png)
```startX = cutPosition + 1 = 5+1 = 6;```  
```startY = startY = 1;```  
```dimX = endX - cutPosition = 6-5 = 1;```  
```dimY = dimY = 4;```






