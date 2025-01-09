a = input()
stack=0
piece=0
for i in range(len(a)):
    if a[i]=='(':
        stack+=1
    else: #a[i]==')'
        if a[i-1]=='(':
            stack-=1
            piece+=stack
        else: # a[i-1]==')':
            stack-=1
            piece+=1
print(piece)