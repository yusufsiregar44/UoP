def recursive( depth ):
    depth+=1
    while (depth < 5):
        ret = recursive(depth)
    return depth

ret = recursive( 0 )
print ("the recursive depth is ", ret)
