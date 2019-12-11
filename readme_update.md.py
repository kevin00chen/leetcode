#cnt=`grep -o '\[\d\{1,\}\](src/main/resources/\w\{1,\}.md)' README.md | wc -l`
#sed -ig "s/累计总数: *[0-9]*$/累计总数: $cnt/" README.md

import os
import datetime

def update_resolve_num():
    cmd = "grep -o '\[\d\{1,\}\](src/main/resources/\w\{1,\}.md)' README.md | wc -l"
    resolve_num = os.popen(cmd).readlines()[0].replace(' ', '').replace('\n', '')
    cmd = "sed -ig \"s/累计总数: [0-9]*$/累计总数: " + resolve_num + "/\" README.md"
    os.system(cmd)


def add_solutions():
    today=str(datetime.date.today())
    cmd = "grep -o '^| \d\{4\}-\d\{2\}-\d\{2\} | .* |$' README.md"
    events = os.popen(cmd).readlines()
    already_content = ""
    for event in events:
        day = event.split('|')[1].strip()
        content = event.split('|')[2].strip()
        if day == today:
            already_content = content

    cmd = "git ls-files . --exclude-standard --others | grep -v \"out\" | grep \"Solution\""
    files = os.popen(cmd).readlines()

    new_files = {}
    if new_files:
        print('xx')
    for file in files:
        type = file.split('/')[5]
        num = int(file.split('/')[6].split('.java')[0].replace('Solution', ''))
        new_files[num] = type

    if new_files: # 如果有新文件，则更新README.md
        content = ""
        for key in sorted(new_files.keys()):
            content += "[" + str(key) + "](src/main/resources/" + new_files[key] + ".md), "

        content = content[:-2]
        if already_content != "": # 如果已有则替换
            content = already_content + ", " + content
            cmd = "sed -ig \"s/" + already_content.replace('/', '\/') + "/" + content.replace('/', '\/') + "/\" README.md"
            cmd = cmd.replace('[', '\[').replace(']', '\]')
        else: # 否则新增
            content = "| " + today + " | " + content + " |"
            cmd = "echo \"" + content + "\" >> README.md"
        os.system(cmd)

if __name__=="__main__":
    add_solutions()
    update_resolve_num()