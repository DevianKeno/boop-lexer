
import os
from boop.cmp import Compiler

# Setup file path
cwd = os.getcwd()
filename = 'code/io.boop'
filepath = os.path.join(cwd, filename)

if __name__ == '__main__':    
    cmp = Compiler()
    cmp.parse(filepath)
    