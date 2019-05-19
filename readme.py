import os

path = 'src'
dirs = os.listdir(path)

def name(f):
    words = f.split('_')
    sentence = []
    sentence.append('#' + words[0][1:])
    for word in words[1:]:
        #sentence.append(word[0].upper() + word[1:])
        sentence.append(word.capitalize())
    return " ".join(sentence)

dirs.sort()
print("# Solutions for Leetcode\n")
for f in dirs:
    subdirs = os.listdir("%s/%s" % (path, f))
    print("* [%s](%s/%s/%s)" % (name(f), path, f, subdirs[0]))
