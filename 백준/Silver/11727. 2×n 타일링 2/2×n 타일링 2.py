n = int(input())
count = [0]*1001

count[1] = 1
count[2] = 3

for i in range(3,n+1):
    count[i] = count[i-1] + 2*count[i-2]
    
print(count[n]%10007)