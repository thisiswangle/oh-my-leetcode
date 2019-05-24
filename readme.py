import os

path = 'src'
dirs = os.listdir(path)

def name(f):
    words = f.split('_')
    sentence = []
    sentence.append('#' + words[0][1:])
    for word in words[1:]:
        #sentence.append(word[0].upper() + word[1:])
        if word in set(['i', 'ii', 'iii']):
            sentence.append(word.upper())
        else:
            sentence.append(word.capitalize())
    return " ".join(sentence)

dirs.sort()
print("# Solutions for Leetcode\n")
for f in dirs:
    subdirs = os.listdir("%s/%s" % (path, f))
    for subdir in subdirs:
        if subdir.endswith('.java'):
            #os.system('touch %s/%s/README.md' % (path, f))
            print("* %s [解题思路](%s/%s/README.md) [代码实现](%s/%s/%s)" % (name(f), path, f, path, f, subdir))
