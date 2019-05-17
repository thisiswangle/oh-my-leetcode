import os

path = 'src'
dirs = os.listdir(path)

dirs.sort()
for f in dirs:
    subdirs = os.listdir("%s/%s" % (path, f))
    print("* [%s](%s/%s/%s)" % (f, path, f, subdirs[0]))
