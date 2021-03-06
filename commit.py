import os
import datetime

git_content = ""

new_q_template = """
### number [][]()
问题描述：

　　

示例：

\`\`\`

\`\`\`

解法：

　　"""

def update_resolve_num():
    cmd = "find src/main/java -type f | grep -E 'hard|easy|medium' |wc -l"
    resolve_num = os.popen(cmd).readlines()[0].replace(' ', '').replace('\n', '')
    cmd = "sed -ig \"s/累计总数: [0-9]*$/累计总数: " + resolve_num + "/\" README.md"
    os.system(cmd)

    cmd = "find src/main/java -type f | grep 'easy' |wc -l"
    resolve_num = os.popen(cmd).readlines()[0].replace(' ', '').replace('\n', '')
    cmd = "sed -ig \"s/| Easy | [0-9]* |$/| Easy | " + resolve_num + " |/\" README.md"
    os.system(cmd)

    cmd = "find src/main/java -type f | grep 'medium' |wc -l"
    resolve_num = os.popen(cmd).readlines()[0].replace(' ', '').replace('\n', '')
    cmd = "sed -ig \"s/| Medium | [0-9]* |$/| Medium | " + resolve_num + " |/\" README.md"
    os.system(cmd)

    cmd = "find src/main/java -type f | grep 'hard' |wc -l"
    resolve_num = os.popen(cmd).readlines()[0].replace(' ', '').replace('\n', '')
    cmd = "sed -ig \"s/| Hard | [0-9]* |$/| Hard | " + resolve_num + " |/\" README.md"
    os.system(cmd)


def add_solutions():
    today = str(datetime.date.today())
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
    update_md_files = []
    for file in files:
        type = file.split('/')[5]
        md_file = "src/main/resources/" + type + ".md"
        update_md_files.append(md_file)
        level = file.split('/')[6].upper()
        num = int(file.split('/')[7].split('.java')[0].replace('Solution', ''))
        cmd = "sed -ig \"s/^### " + str(num) + " \[\]\[\(.*\)\]()$/### " + str(num) + " \[" + level + "\]\[\\1\]\(" + file.replace('src/main', '..').replace('/', '\/').replace('\n', '') +  "\)/\" " + md_file
        os.system(cmd)
        new_files[num] = type

    for md_file in set(update_md_files):
        cmd = "echo \"" + new_q_template + "\" >> " + md_file
        os.system(cmd)

    if new_files:  # 如果有新文件，则更新README.md
        content = ""
        global git_content
        for key in sorted(new_files.keys()):
            content += "[" + str(key) + "](src/main/resources/" + new_files[key] + ".md), "
            git_content = git_content + ",Solution" + str(key)

        content = content[:-2]
        if already_content != "":  # 如果已有则替换
            content = already_content + ", " + content
            cmd = "sed -ig \"s/" + already_content.replace('/', '\/') + "/" + content.replace('/', '\/') + "/\" README.md"
            cmd = cmd.replace('[', '\[').replace(']', '\]')
        else:  # 否则新增
            content = "| " + today + " | " + content + " |"
            cmd = "echo \"" + content + "\" >> README.md"
        os.system(cmd)


def git_add_commit_push():
    cmd = "git add ."
    os.system(cmd)
    cmd = "git commit -m \"" + git_content + "\""
    os.system(cmd)
    cmd = "git push origin master:master"
    os.system(cmd)


if __name__ == "__main__":
    add_solutions()
    update_resolve_num()
    git_add_commit_push()
